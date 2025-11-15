import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        Graph red = new Graph(); // se crea un objeto grafo llamado red para poder representar la red social

        // nombramos el grafo y mediante addVertex Agregamos usuarios (vértices, claves)
        red.addVertex("Jesus");
        red.addVertex("Ariel");
        red.addVertex("Dharyn");
        red.addVertex("Andree");
        red.addVertex("Juan");
        red.addVertex("Cadavid");

        // llamamos el grafo y mediante add.Edge Agregamos amistades (aristas, valores)
        red.addEdge("Jesus", "Ariel");
        red.addEdge("Jesus", "Dharyn");
        red.addEdge("Ariel", "Andree");
        red.addEdge("Dharyn", "Juan");
        red.addEdge("Andree", "Cadavid");
        red.addEdge("Juan", "Cadavid");

        // Imprimimos la lista de adyacencia
        System.out.println("Lista de adyacencia:");
        red.printAdjacency();
        System.out.println();

        // Recorrido BFS desde "Jesus"
        List<String> recorrido = red.bfs("Jesus");
        System.out.println("Recorrido BFS desde 'Jesus': " + recorrido);

        // prueba BFS desde otro usuario:
        System.out.println("Recorrido BFS desde 'Andree': " + red.bfs("Andree"));
    }
}

