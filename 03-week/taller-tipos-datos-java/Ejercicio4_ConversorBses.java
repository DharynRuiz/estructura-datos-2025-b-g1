public class Ejercicio4_ConversorBses  {
    public static String compressRLE(String texto) { // Metodo que comprime un string usando RLE(ES UNA TECNICA PARA COMPRIMIR DATOS)
        if (texto == null || texto.isEmpty()) return ""; // Descartamos que el texto no sirva o este vacio

        StringBuilder resultado = new StringBuilder();// creamos una secuencia con StringBuilder
        int contador = 1;//agremamos un contador para las repeticiones de los carcateres

        for (int i = 1; i <= texto.length(); i++) {//

            if (i < texto.length() && texto.charAt(i) == texto.charAt(i - 1)) {
                contador++;
            } else {
                resultado.append(texto.charAt(i - 1)).append(contador);
                contador = 1;
            }
        }
        return resultado.toString();
        // se ahce un recorrido carcater por caracter del segundo hasta el ultimo,
        // asi sucesibamente, sin son igaules incrementa el contador si no se finaliza
        // agregamos el resultado al caracter anterior y la veces que se repitio
        // se devuelve el texto comprimido
    }

    public static double compressionRatio(String original, String comprimido) {
        if (original == null || original.isEmpty()) return 0.0;
        return (double) comprimido.length() / original.length();
        // si el texto esta vacio hacemos una division por 0 para evitar un error por el mismo
    }
        // iniciamos la prueba
    public static void main(String[] args) {
        String texto = "AABBBBBCCCCDE";   // TEXTO de prueba
        String comprimido = compressRLE(texto);// llamamos al metodo de comrpesion

        System.out.println("Texto original: " + texto);
        System.out.println("Comprimido: " + comprimido);
        System.out.println("Longitud original: " + texto.length());
        System.out.println("Longitud comprimida: " + comprimido.length());
        System.out.println("Ratio de compresión: " + compressionRatio(texto, comprimido));
        // imprimimos los resultados
    }
}