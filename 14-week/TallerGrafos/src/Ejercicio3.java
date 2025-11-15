import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        Graph grafo = new Graph();

        // Componente 1
        grafo.addEdge("A", "B");
        grafo.addEdge("B", "C");

        // Componente 2
        grafo.addEdge("D", "E");

        // Nodo aislado (sin conexiones)
        grafo.addVertex("F");

        System.out.println("Grafo con componentes conexos:");
        grafo.printAdjacency();
        System.out.println();

        // Recorridos BFS desde diferentes nodos
        List<String> desdeA = grafo.bfs("A");
        System.out.println("Recorrido BFS desde 'A': " + desdeA);

        List<String> desdeD = grafo.bfs("D");
        System.out.println("Recorrido BFS desde 'D': " + desdeD);

        List<String> desdeF = grafo.bfs("F");
        System.out.println("Recorrido BFS desde 'F' (nodo aislado): " + desdeF);
    }
}
