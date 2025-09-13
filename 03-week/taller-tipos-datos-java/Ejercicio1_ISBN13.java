public class Ejercicio1_ISBN13 {

    public static boolean isValidISBN13(String isbn) {
        if (isbn == null || isbn.length() != 13) return false;

        int suma = 0;
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) return false;   // no-dígitos => inválido
            int d = c - '0';
            suma += d * (i % 2 == 0 ? 1 : 3);          // pesos 1,3,1,3,...
        }
        return suma % 10 == 0;
    }

    public static void main(String[] args) {
        String prueba1 = "9780306406157";  // ejemplo clásico (válido)
        String prueba2 = "9780386046517";  // ejemplo (inválido)

        System.out.println("¿ISBN válido? " + isValidISBN13(prueba1)); // true
        System.out.println("¿ISBN válido? " + isValidISBN13(prueba2)); // false
    }
}