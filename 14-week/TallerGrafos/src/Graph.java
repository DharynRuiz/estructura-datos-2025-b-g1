import java.util.*;

public class Graph {
    // se implementa una hashmap para poder crear una lista donde cada vertice tiene una lista de adyacencia
    // una clave. se designa solo String
    private final Map<String, List<String>> adj = new HashMap<>();

    public void addVertex(String v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }// con este metodo agregaremos un vertice en caso de que no exista

    public void addEdge(String v1, String v2) {
        adj.putIfAbsent(v1, new ArrayList<>());//si el vertice no existe se crea
        adj.putIfAbsent(v2, new ArrayList<>());
        adj.get(v1).add(v2);// conectamos el vertice 1 y el 2
        adj.get(v2).add(v1);//conectamos el vertice 2 al 1 y creamos la lista de adyacencia
    }// con este metodo agregaremos una arista en dos vertices

    public List<String> bfs(String start) {
        List<String> order = new ArrayList<>();// creamos el metodo BFS para recorrer los grafos mediante cola
        if (!adj.containsKey(start)) return order;// guarando el orden de lo recorrio y si el nodo esta vacio retorna vacio

        Set<String> visited = new HashSet<>();//aca guardamos los nodos ya visitados
        Queue<String> queue = new LinkedList<>();//implementacion de la FIFO usando BFS

        visited.add(start);//marca el nodo inicial
        queue.add(start);//y con este agramos a la cola

        while (!queue.isEmpty()) {// mientras alla nodos en la cola toma el primer nodo y lo guarda
            String current = queue.poll();// en el orden en que lo visita
            order.add(current);

            for (String neighbor : adj.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {//recorre sus nodos vecino y si no fue visitado se marca y se agrega a la cola
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return order;//devuelve el orden recorrido
    }

   //imprimimos la lista de adyacencia
    public void printAdjacency() {
        for (String v : adj.keySet()) {
            System.out.println(v + " -> " + adj.get(v));
        }
    }
}
