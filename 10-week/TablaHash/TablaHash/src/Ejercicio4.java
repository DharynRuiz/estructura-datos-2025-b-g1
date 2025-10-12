import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println(" PRUEBA DE TAMAÑO DE LA TABLA HASH ");
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa la capacidad inicial de la tabla: ");                 //EN ESTE CASO NO DEFINIMOS NOSOTROS LA CAPACIDAD DE LA TABLA SI NO QUE SEA EL USUARIO
        int capacidad = sc.nextInt();

        HashTable<Integer, String> tabla = new HashTable<>(capacidad);                  // CREAMOS LA TABLA QUE ALMACENA PARES CLAVE-VALOR INTEGER COMO CLAVE Y STRING COMO VALOR

        System.out.print("¿Cuántos elementos quieres insertar?: ");
        int cantidad = sc.nextInt();                                                    // USUARIO INGRESA LA CANTIDAD, EN CASO TAL DE QUE LA CANTIDAD SEA MAYOR A SU CAPACIDAD SE FORZARA UNA COLISION
        sc.nextLine(); // limpiar buffer

        for (int i = 1; i <= cantidad; i++) {
            tabla.put(i, "Valor" + i);
        }

        System.out.println("\n RESULTADOS ");
        System.out.println("Capacidad inicial: " + capacidad);                          //IMPRIMIMOS LOS VALORES Y EL TAMAÑO REAL DE LA TABLA, LA IDEA ES QUE DEVUELVA EL NUMERO REAL DE PARES CLAVE VALOR ALMACENADOS Y NO LA CAPACIDAD
        System.out.println("Elementos insertados: " + cantidad);
        System.out.println("Tamaño real reportado por la tabla: " + tabla.tamaño());
        System.out.println("\nContenido de la tabla:");
        tabla.imprimirTabla();

        sc.close();
    }
}
