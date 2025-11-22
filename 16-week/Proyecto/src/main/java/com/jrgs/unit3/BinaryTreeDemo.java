package com.jrgs.unit3;

import javax.swing.*;

public class BinaryTreeDemo {

    // ---- Clase interna para nodo del árbol ----
    static class Nodo {
        int valor;
        Nodo izq, der;

        Nodo(int v) {
            valor = v;
        }
    }

    static Nodo raiz = null;

    // Insertar en el árbol (método estándar de BST)
    public static Nodo insertar(Nodo actual, int valor) {
        if (actual == null) return new Nodo(valor);

        if (valor < actual.valor)
            actual.izq = insertar(actual.izq, valor);
        else
            actual.der = insertar(actual.der, valor);

        return actual;
    }

    // Recorrido in-order
    public static void inorder(Nodo actual, StringBuilder sb) {
        if (actual != null) {
            inorder(actual.izq, sb);
            sb.append(actual.valor).append(" ");
            inorder(actual.der, sb);
        }
    }

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "ARBOLES BINARIOS (BINARY TREE):\n" +
                        "- Insertarás números.\n" +
                        "- Se mostrarán en recorrido IN-ORDER.");

        raiz = null; // Reiniciar cada vez

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "1. Insertar número\n" +
                            "2. Mostrar In-Order\n" +
                            "3. Salir");

            if (opcion == null) return;

            switch (opcion) {
                case "1":
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Número a insertar:"));
                    raiz = insertar(raiz, n);
                    break;

                case "2":
                    StringBuilder sb = new StringBuilder("Recorrido In-Order:\n");
                    inorder(raiz, sb);
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;

                case "3":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}

