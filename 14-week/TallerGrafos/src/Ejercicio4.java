import java.util.*;

public class Ejercicio4 {

    // Versión simple de DFS (recursiva)
    public static List<String> dfs(Graph g, String start) {
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfsRec(g, start, visited, order);
        return order;
    }

    private static void dfsRec(Graph g, String node, Set<String> visited, List<String> order) {
        if (visited.contains(node)) return;
        visited.add(node);
        order.add(node);

        // obtener los vecinos usando reflexión sobre la estructura de Graph
        try {
            var field = Graph.class.getDeclaredField("adj");
            field.setAccessible(true);
            Map<String, List<String>> adj = (Map<String, List<String>>) field.get(g);
            for (String neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                dfsRec(g, neighbor, visited, order);
            }
        } catch (Exception e) {
            System.out.println("Error accediendo al grafo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();

        // Crear un grafo de ejemplo
        grafo.addEdge("A", "B");
        grafo.addEdge("A", "C");
        grafo.addEdge("B", "D");
        grafo.addEdge("C", "E");
        grafo.addEdge("D", "F");

        System.out.println("Lista de adyacencia:");
        grafo.printAdjacency();
        System.out.println();

        // BFS y DFS desde A
        List<String> bfsOrden = grafo.bfs("A");
        List<String> dfsOrden = dfs(grafo, "A");

        System.out.println("Recorrido BFS desde 'A': " + bfsOrden);
        System.out.println("Recorrido DFS desde 'A': " + dfsOrden);
    }
}

