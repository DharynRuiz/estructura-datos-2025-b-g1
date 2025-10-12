public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println(" COLISIONES CONTROLADAS ");


        HashTable<String, Integer> tabla = new HashTable<>(5); // CREAMOS LA TABLA Y ASIGANAMOS UNA CAPACIDAD DE 5 BUCKETS
        tabla.put("A", 1);                                              // INSERTAMOS LAS CLAVES
        tabla.put("M", 2);
        tabla.put("O", 3);
        tabla.put("R", 4);                                              // EN ESTA TABLA SE BUSCA CREAR UNA COLISION CONTROLADA PARA QUE LOS VALORES SE ALMACENEN EN EL MISMO BLOQUE
        tabla.put("E", 5);


        System.out.println("\n CONTENIDO DE LA TABLA ");  // IMRPIMIMOS LA TABLA
        tabla.imprimirTabla();


        System.out.println("\nValor asociado a 'A': " + tabla.get("A")); // IMPRIMIMOS EL VALOR ASIGNADOA  ACADA BUCKET
        System.out.println("Valor asociado a 'E': " + tabla.get("E"));
    }
}
