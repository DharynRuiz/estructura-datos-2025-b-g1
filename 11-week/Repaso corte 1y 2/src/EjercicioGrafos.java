import java.util.*;
public class EjercicioGrafos {
    private Map<String, List<String>> adyacencias = new HashMap<>();
// CREAMOS LA CLASE GRAFO PARA ALMACENAR LAS CIUDADES Y SUS CONEXIONES SE USA UN HASH MAP DONDE LA CLAVE VA A SER EL NOMBRE DE LA CUIDAD
    // Y VALOR INA LISTA DE CIUDADES CONECTADAS DIRECTAMENTE A ELLA

    public void agregarVertice(String ciudad) {
        adyacencias.putIfAbsent(ciudad, new ArrayList<>());
    }
// CON ESTE METODO AGREGAMOS UNA CIUDAD AL MAPA, NOS APOYAMOS CON putIfAbsent PARA MOSTRAR QUE LA CIUDAD NO EXISTE Y LA AGREGA CON UNA LUISTA VACIA
    //SI YA EXISTE NO LA VUELVE A AGREGAR PARA EVITAR DUPLICADOS

    public void agregarArista(String c1, String c2) {
        agregarVertice(c1);
        agregarVertice(c2);
        adyacencias.get(c1).add(c2);
        adyacencias.get(c2).add(c1); // Si quieres grafo no dirigido (ida y vuelta)
    }
// CON ESTE METODO CONECTAMOS DOS CIUDADES SE AGREGA EL DESTINO A LA LISTA DEL ORIGEN Y VICEVERSA

    public void mostrarGrafo() {
        for (var entry : adyacencias.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

 // METODO PARA ENCONTRAR LA RUTA MAS CORTA BFS, USAMOS Breadth-First Search PORQ UE ENCUENTRA LA RUTA AMS CORTA EN CAMINOS
    // DONDE COLA ALMACENA LAS CIUDADES PENDIENTES POR VISITAR(PRIMERO QUE ENTRA, PRIMERO QUE SALE)
    // VISITADO LO CRAMOS PARA GUARDAR CIUDADES YA VISITADAS Y NO REPETIR
    // PADRE  LO CREAMOS PARA RECONSTRUIR EL CAMINO FINAL
    public List<String> rutaMasCortaBFS(String inicio, String destino) {
        Queue<String> cola = new LinkedList<>();
        Map<String, String> padre = new HashMap<>();
        Set<String> visitado = new HashSet<>();

        cola.add(inicio);
        visitado.add(inicio);
        padre.put(inicio, null);
// SACAMOS LA CIUDAD DE LA COLA SI ENCOTRNAMOS LA CIUDAD DE DESTINO SE DETIENE, RECORREMOS TODAS LAS IUDADES CONECTADAS YH SI NO LA HA VISITADO
        //LO MARCAMOS COMO VISITADO, LO AGREGAMOS A LA COLA Y GUARDAMOS EN QUIEN ES SU PADRE
        while (!cola.isEmpty()) {
            String actual = cola.poll();

            if (actual.equals(destino)) break;

            for (String vecino : adyacencias.getOrDefault(actual, new ArrayList<>())) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    padre.put(vecino, actual);
                    cola.add(vecino);
                }
            }
        }
// USAMOS EL PADRE PARA VOLVER DESDE ELD ESTINO HASTA EL ORIGEN, INSERTAMOS CADA CIUDAD AL INICOO DE LA LISTA PARA QUE EL CAMINO QUEDE ORDENADO Y RETORNAMOS A LA RUTA FINAL MAS CORTA
        List<String> camino = new LinkedList<>();
        String paso = destino;

        while (paso != null) {
            camino.add(0, paso);
            paso = padre.get(paso);
        }

        if (!camino.get(0).equals(inicio)) return null; // No existe camino
        return camino;
    }

 // INICIALIZAMOS EL EJERCICIO
    // AQUI SE CREAN LAS CIUDADES, LUEGO SE CONECTAN COMO SI FUERAN CARRETERAS, BUSCAMOS LA RUTA MAS CORTA ENTRE DOS CIUDADES. SE IMPRIME ALGO COMO
    //BOGOTA-MEDELLIN-CALI-BARRANQUILLA
    public static void main(String[] args) {
        EjercicioGrafos mapa = new EjercicioGrafos();

        mapa.agregarArista("Bogotá", "Medellín");
        mapa.agregarArista("Bogotá", "Cali");
        mapa.agregarArista("Medellín", "Barranquilla");
        mapa.agregarArista("Cali", "Pasto");
        mapa.agregarArista("Pasto", "Ipiales");
        mapa.agregarArista("Barranquilla", "Santa Marta");

        System.out.println("Mapa de ciudades (Grafo):");
        mapa.mostrarGrafo();

        System.out.println("\nRuta más corta de Bogotá a Ipiales:");
        List<String> ruta = mapa.rutaMasCortaBFS("Bogotá", "Ipiales");
        System.out.println(ruta);
    }
}

