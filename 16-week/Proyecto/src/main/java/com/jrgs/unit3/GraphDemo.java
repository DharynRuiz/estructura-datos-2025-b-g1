package com.jrgs.unit3;

import javax.swing.*;
import java.util.*;

public class GraphDemo {

    static Map<String, List<String>> grafo = new HashMap<>();

    public static void agregarNodo(String n) {
        grafo.putIfAbsent(n, new ArrayList<>());
    }

    public static void agregarArista(String a, String b) {
        grafo.get(a).add(b);
    }

    public static String bfs(String inicio) {
        StringBuilder sb = new StringBuilder("BFS desde " + inicio + ":\n");
        Queue<String> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();

        q.add(inicio);
        visit.add(inicio);

        while (!q.isEmpty()) {
            String actual = q.poll();
            sb.append(actual).append(" ");

            for (String v : grafo.get(actual)) {
                if (!visit.contains(v)) {
                    visit.add(v);
                    q.add(v);
                }
            }
        }

        return sb.toString();
    }

    public static String dfs(String inicio) {
        StringBuilder sb = new StringBuilder("DFS desde " + inicio + ":\n");
        Set<String> visit = new HashSet<>();
        Stack<String> pila = new Stack<>();

        pila.push(inicio);

        while (!pila.isEmpty()) {
            String actual = pila.pop();
            if (!visit.contains(actual)) {
                visit.add(actual);
                sb.append(actual).append(" ");

                List<String> hijos = grafo.get(actual);
                Collections.reverse(hijos); // Para un DFS ordenado
                for (String h : hijos) pila.push(h);
            }
        }

        return sb.toString();
    }

    public static void run() {
        JOptionPane.showMessageDialog(null,
                "GRAFO — LISTA DE ADYACENCIA\n" +
                        "- Agrega nodos y aristas.\n" +
                        "- Ejecuta BFS y DFS.");

        grafo.clear();

        while (true) {
            String op = JOptionPane.showInputDialog(
                    "1. Agregar nodo\n" +
                            "2. Agregar arista A → B\n" +
                            "3. BFS\n" +
                            "4. DFS\n" +
                            "5. Ver grafo\n" +
                            "6. Salir");

            if (op == null) return;

            switch (op) {
                case "1":
                    agregarNodo(JOptionPane.showInputDialog("Nombre del nodo:"));
                    break;

                case "2":
                    String a = JOptionPane.showInputDialog("Nodo origen:");
                    String b = JOptionPane.showInputDialog("Nodo destino:");
                    agregarArista(a, b);
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null,
                            bfs(JOptionPane.showInputDialog("Nodo inicial BFS:")));
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null,
                            dfs(JOptionPane.showInputDialog("Nodo inicial DFS:")));
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null, grafo.toString());
                    break;

                case "6":
                    return;
            }
        }
    }
}

