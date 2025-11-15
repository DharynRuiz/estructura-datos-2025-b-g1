import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        Graph mapa = new Graph(); // se crea el grafo para almacenar los datos

        // Agregar ciudades (vértices)
        mapa.addVertex("Bogotá");
        mapa.addVertex("Medellín");
        mapa.addVertex("Neiva");
        mapa.addVertex("Barranquilla");
        mapa.addVertex("Cartagena");
        mapa.addVertex("Bucaramanga");

        // Agregar conexiones (carreteras)
        mapa.addEdge("Bogotá", "Medellín");
        mapa.addEdge("Bogotá", "Neiva");
        mapa.addEdge("Medellín", "Barranquilla");
        mapa.addEdge("Neiva", "Cartagena");
        mapa.addEdge("Cartagena", "Barranquilla");
        mapa.addEdge("Bucaramanga", "Bogotá");

        // Mostrar las conexiones del grafo
        System.out.println("Mapa de ciudades (lista de adyacencia):");
        mapa.printAdjacency();
        System.out.println();

        // Recorrido BFS desde Bogotá
        List<String> recorrido = mapa.bfs("Bogotá");
        System.out.println("Recorrido BFS desde 'Bogotá': " + recorrido);

        // Ejemplo adicional: BFS desde Cartagena
        System.out.println("Recorrido BFS desde 'Cartagena': " + mapa.bfs("Cartagena"));
    }
}

