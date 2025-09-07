import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Libro {
    public int codigo;
    public String titulo;
    public String autor;
    public int stock;
    public boolean activo;

    public Libro(int codigo, String titulo, String autor, int stock) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
        this.activo = true;
    }

    @Override
    public String toString() {
        return String.format("[codigo=%d, titulo=%s, autor=%s, stock=%d, activo=%s]",
                codigo, titulo, autor, stock, activo);
    }
}

class PrestamoNode {
    public int codigoLibro;
    public String usuario;
    public LocalDate fecha;
    public PrestamoNode siguiente;

    public PrestamoNode(int codigoLibro, String usuario, LocalDate fecha) {
        this.codigoLibro = codigoLibro;
        this.usuario = usuario;
        this.fecha = fecha;
    }
}

class ListaPrestamos {
    private PrestamoNode head, tail;

    public void insertar(int codigoLibro, String usuario, LocalDate fecha) {
        PrestamoNode n = new PrestamoNode(codigoLibro, usuario, fecha);
        if (head == null) head = tail = n;
        else { tail.siguiente = n; tail = n; }
    }

    public boolean remover(int codigoLibro, String usuario) {
        PrestamoNode prev = null, cur = head;
        while (cur != null) {
            if (cur.codigoLibro == codigoLibro && cur.usuario.equals(usuario)) {
                if (prev == null) head = cur.siguiente; else prev.siguiente = cur.siguiente;
                if (cur == tail) tail = prev;
                return true;
            }
            prev = cur; cur = cur.siguiente;
        }
        return false;
    }

    public void listar() {
        if (head == null) { System.out.println("No hay préstamos activos."); return; }
        for (PrestamoNode c = head; c != null; c = c.siguiente)
            System.out.printf("Libro: %d | Usuario: %s | Fecha: %s\n", c.codigoLibro, c.usuario, c.fecha);
    }
}

class HistorialNode {
    public String tipo, descripcion;
    public LocalDate fecha;
    public HistorialNode siguiente, anterior;

    public HistorialNode(String tipo, String descripcion, LocalDate fecha) {
        this.tipo = tipo; this.descripcion = descripcion; this.fecha = fecha;
    }
}

class HistorialDoble {
    private HistorialNode head, tail;

    public void agregar(String tipo, String desc, LocalDate fecha) {
        HistorialNode n = new HistorialNode(tipo, desc, fecha);
        if (head == null) head = tail = n;
        else { tail.siguiente = n; n.anterior = tail; tail = n; }
    }

    public void listarAdelante() {
        for (HistorialNode c = head; c != null; c = c.siguiente)
            System.out.printf("%s | %s | %s\n", c.fecha, c.tipo, c.descripcion);
    }

    public void listarAtras() {
        for (HistorialNode c = tail; c != null; c = c.anterior)
            System.out.printf("%s | %s | %s\n", c.fecha, c.tipo, c.descripcion);
    }
}

public class BibliotecaU1 {
    private static final int MAX_LIBROS = 100, NUM_SUCURSALES = 3;
    private Libro[] catalogo = new Libro[MAX_LIBROS];
    private int[][] disponibilidad = new int[MAX_LIBROS][NUM_SUCURSALES];
    private int cantidadLibros = 0;
    private ListaPrestamos prestamos = new ListaPrestamos();
    private HistorialDoble historial = new HistorialDoble();
    private Scanner sc = new Scanner(System.in);
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private int buscar(java.util.function.Predicate<Libro> criterio) {
        for (int i = 0; i < cantidadLibros; i++)
            if (catalogo[i] != null && catalogo[i].activo && criterio.test(catalogo[i])) return i;
        return -1;
    }

    private void distribuirStock(int idx, int stock) {
        catalogo[idx].stock = stock;
        int base = stock / NUM_SUCURSALES, resto = stock % NUM_SUCURSALES;
        for (int s = 0; s < NUM_SUCURSALES; s++)
            disponibilidad[idx][s] = base + (s < resto ? 1 : 0);
    }

    private void altaLibro() {
        try {
            if (cantidadLibros >= MAX_LIBROS) return;
            System.out.print("Codigo: "); int codigo = Integer.parseInt(sc.nextLine());
            if (buscar(l -> l.codigo == codigo) != -1) { System.out.println("Ya existe."); return; }
            System.out.print("Titulo: "); String t = sc.nextLine();
            System.out.print("Autor: "); String a = sc.nextLine();
            System.out.print("Stock: "); int stock = Integer.parseInt(sc.nextLine());
            catalogo[cantidadLibros] = new Libro(codigo, t, a, stock);
            distribuirStock(cantidadLibros, stock);
            cantidadLibros++;
            historial.agregar("ALTA", "Alta libro "+codigo, LocalDate.now());
        } catch(Exception e){ System.out.println("Error: "+e.getMessage()); }
    }

    private void bajaLibro() {
        try {
            System.out.print("Codigo: "); int c = Integer.parseInt(sc.nextLine());
            int idx = buscar(l -> l.codigo == c);
            if (idx==-1) return;
            catalogo[idx].activo = false;
            historial.agregar("BAJA", "Baja libro "+c, LocalDate.now());
        } catch(Exception e){ System.out.println("Error: "+e.getMessage()); }
    }

    private void listarCatalogo() {
        for (int i=0;i<cantidadLibros;i++) if (catalogo[i]!=null && catalogo[i].activo) {
            System.out.println(catalogo[i]);
            System.out.println(Arrays.toString(disponibilidad[i]));
        }
    }

    private void prestarLibro() {
        try {
            System.out.print("Codigo: "); int c = Integer.parseInt(sc.nextLine());
            int idx = buscar(l -> l.codigo == c);
            if (idx==-1 || catalogo[idx].stock<=0) return;
            System.out.print("Usuario: "); String u = sc.nextLine();
            distribuirStock(idx, catalogo[idx].stock-1);
            prestamos.insertar(c,u,LocalDate.now());
            historial.agregar("PRESTAMO","Prestamo libro "+c+" a "+u, LocalDate.now());
        } catch(Exception e){ System.out.println("Error: "+e.getMessage()); }
    }

    private void devolverLibro() {
        try {
            System.out.print("Codigo: "); int c = Integer.parseInt(sc.nextLine());
            System.out.print("Usuario: "); String u = sc.nextLine();
            int idx = buscar(l -> l.codigo == c);
            if (idx==-1) return;
            distribuirStock(idx, catalogo[idx].stock+1);
            boolean ok = prestamos.remover(c,u);
            historial.agregar("DEVOLUCION","Devolucion libro "+c+" por "+u, LocalDate.now());
        } catch(Exception e){ System.out.println("Error: "+e.getMessage()); }
    }

    private void cargarDemo() {
        catalogo[0]=new Libro(101,"Java","Autor A",5);
        catalogo[1]=new Libro(102,"Estructuras","Autor B",3);
        catalogo[2]=new Libro(103,"Algoritmos","Autor C",4);
        cantidadLibros=3;
        for(int i=0;i<cantidadLibros;i++) distribuirStock(i,catalogo[i].stock);
        historial.agregar("ALTA","Carga demo",LocalDate.now());
    }

    public void menu() {
        Map<String,Runnable> ops = new HashMap<>();
        ops.put("1", this::altaLibro);
        ops.put("2", this::bajaLibro);
        ops.put("3", ()->{System.out.print("Titulo: ");String t=sc.nextLine();int idx=buscar(l->l.titulo.equalsIgnoreCase(t));if(idx!=-1)System.out.println(catalogo[idx]);});
        ops.put("4", ()->{System.out.print("Codigo: ");int c=Integer.parseInt(sc.nextLine());int idx=buscar(l->l.codigo==c);if(idx!=-1)System.out.println(catalogo[idx]);});
        ops.put("5", this::listarCatalogo);
        ops.put("6", ()->{System.out.print("Codigo: ");int c=Integer.parseInt(sc.nextLine());int idx=buscar(l->l.codigo==c);if(idx!=-1){System.out.print("Nuevo stock: ");int s=Integer.parseInt(sc.nextLine());distribuirStock(idx,s);}});
        ops.put("7", this::prestarLibro);
        ops.put("8", this::devolverLibro);
        ops.put("9", prestamos::listar);
        ops.put("10", historial::listarAdelante);
        ops.put("11", historial::listarAtras);
        ops.put("12", this::cargarDemo);

        boolean salir=false;
        while(!salir){
            System.out.println("\n--- Menú ---\n1.Alta 2.Baja 3.BuscarTitulo 4.BuscarCodigo 5.Listar 6.ActualizarStock 7.Prestar 8.Devolver 9.Prestamos 10.Historial-> 11.Historial<- 12.Demo 0.Salir");
            String opt=sc.nextLine();
            if(opt.equals("0")) salir=true;
            else ops.getOrDefault(opt,()->System.out.println("Opción inválida")).run();
        }
    }

    public static void main(String[] args){
        new BibliotecaU1().menu();
    }
}
