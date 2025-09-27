package figuras;

import java.util.ArrayList;

// Clase Main (la única pública)
public class Main {
    public static void main(String[] args) {
        // Crear un ArrayList de figuras
        ArrayList<Figura> listaFiguras = new ArrayList<>();

        // Agregar objetos de cada clase
        listaFiguras.add(new Circulo(5, " Rojo"));
        listaFiguras.add(new Circulo(3.2, "Azul"));
        listaFiguras.add(new Circulo(500, "Fuxia"));

        listaFiguras.add(new Rectangulo(4, 6, " Verde"));
        listaFiguras.add(new Rectangulo(10, 2, "Amarillo"));
        listaFiguras.add(new Rectangulo(90, 10.58, "Azul"));

        listaFiguras.add(new Triangulo(3, 4, 5, " Negro"));
        listaFiguras.add(new Triangulo(6, 6, 6, " Blanco"));
        listaFiguras.add(new Triangulo(60, 50, 60, " Rosa"));

        // Recorrer la lista e imprimir información
        for (Figura figura : listaFiguras) {
            figura.mostrarInformacion();
        }
    }
}
