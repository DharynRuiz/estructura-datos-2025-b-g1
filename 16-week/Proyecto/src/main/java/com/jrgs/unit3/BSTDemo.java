package com.jrgs.unit3;

import javax.swing.*;

public class    BSTDemo {

    static class Nodo {
        int valor;
        Nodo izq, der;

        Nodo(int v) { valor = v; }
    }

    static Nodo raiz = null;

    public static Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) return new Nodo(valor);
        if (valor < nodo.valor) nodo.izq = insertar(nodo.izq, valor);
        else nodo.der = insertar(nodo.der, valor);
        return nodo;
    }

    public static void inorder(Nodo n, StringBuilder sb) {
        if (n != null) {
            inorder(n.izq, sb);
            sb.append(n.valor).append(" ");
            inorder(n.der, sb);
        }
    }

    public static void run() {
        JOptionPane.showMessageDialog(null,
                "ÁRBOL BINARIO DE BÚSQUEDA (BST):\n" +
                        "- Inserta números.\n" +
                        "- Se muestran ordenados (In-Order).");

        raiz = null;

        while (true) {
            String op = JOptionPane.showInputDialog(
                    "1. Insertar\n" +
                            "2. Mostrar In-Order\n" +
                            "3. Salir");

            if (op == null) return;

            switch (op) {
                case "1":
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Número:"));
                    raiz = insertar(raiz, n);
                    break;

                case "2":
                    StringBuilder sb = new StringBuilder("In-Order:\n");
                    inorder(raiz, sb);
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;

                case "3":
                    return;
            }
        }
    }
}
