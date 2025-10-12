import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        HashTable<String, Integer> contador = new HashTable<>(20); // CREAMOS Y DEFINIMOS UNA TABLA CONN UNA CAPACIDAD DE 20 POSICIONES
        Scanner sc = new Scanner(System.in);                                //CADA PALABRA SERA LA CLAVE String Y LA CANTIDAD DE REPETICIONES SERA EL Interger

        System.out.println(" CONTADOR DE PALABRAS ");
        System.out.println("Escribe una frase o párrafo:");                 //INGRESAMOS UNA FRASE O PARRAFO Y LO CONVERTIMOS CON EL TOLOWERCASE TODO A MINISCULAS
        String texto = sc.nextLine().toLowerCase();

        String[] palabras = texto.split("[^a-záéíóúñ]+");             // SEPARAMOS EL TEXTO INGRESADO ELIMINANDO CUALQUIER COSA QUE NO SEA UNA LETRA
                                                                            //CON ("[^a-záéíóúñ]+") DONDE [^] EL SIMBOLO ^ NIEGA TODO LO QUE NO SEA LETRAS
                                                                            //CON ("[^a-záéíóúñ]+") DONDE  a-z MARCA LAS LETRAS EN MINUSCOLA DE LA A A LA Z
                                                                            //CON ("[^a-záéíóúñ]+") DONDE  áéíóúñ INCLUYE LAS LETRAS CON TILDE Y A LA LETRA Ñ
                                                                            //EN LA APRTE DEL TEXTO.SPLIT RECORRE TODO EL TEXTO PARA IDENTIFICAR LOS SEPARADORES MARCANDO UNA COMPLEJDIAD
                                                                            //DE O(n) POR QUE ANALIZA CARACTER POR CARACTER
        for (String palabra : palabras) {
            if (palabra.isEmpty()) continue;

            Integer valorActual = contador.get(palabra);                    // PARA CADA PALABRA SI NO EXISTE EN LA TABLA SE AGREGA UN VALOR 1 Y SI YA EXISTE SE INCREMENTA SU CONTADOR
            if (valorActual == null) {
                contador.put(palabra, 1);
            } else {
                contador.put(palabra, valorActual + 1);
            }
        }

        System.out.println("\n RESULTADOS ");
        contador.imprimirTabla();                                           // IMPRIME TODAS LAS PALABRAS Y CUANTAS VECES APARECERN

        sc.close();
    }
}
