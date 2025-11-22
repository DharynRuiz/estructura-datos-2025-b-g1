package com.jrgs.unit3;

import javax.swing.*;

public class AVLTreeDemo {

    static class Nodo {
        int valor, altura;
        Nodo izq, der;

        Nodo(int v) {
            valor = v;
            altura = 1;
        }
    }

    static Nodo raiz = null;

    private static int altura(Nodo n) {
        return (n == null) ? 0 : n.altura;
    }

    private static int balance(Nodo n) {
        return (n == null) ? 0 : altura(n.izq) - altura(n.der);
    }

    private static Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izq;
        Nodo t2 = x.der;

        x.der = y;
        y.izq = t2;

        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;

        return x;
    }

    private static Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.der;
        Nodo t2 = y.izq;

        y.izq = x;
        x.der = t2;

        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;

        return y;
    }

    public static Nodo insertar(Nodo n, int valor) {

        if (n == null) return new Nodo(valor);

        if (valor < n.valor) n.izq = insertar(n.izq, valor);
        else n.der = insertar(n.der, valor);

        n.altura = Math.max(altura(n.izq), altura(n.der)) + 1;

        int b = balance(n);

        // Rotaciones
        if (b > 1 && valor < n.izq.valor) return rotacionDerecha(n);
        if (b < -1 && valor > n.der.valor) return rotacionIzquierda(n);
        if (b > 1 && valor > n.izq.valor) {
            n.izq = rotacionIzquierda(n.izq);
            return rotacionDerecha(n);
        }
        if (b < -1 && valor < n.der.valor) {
            n.der = rotacionDerecha(n.der);
            return rotacionIzquierda(n);
        }

        return n;
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
                "ÁRBOL AVL:\n" +
                        "- Árbol que se balancea solo.\n" +
                        "- Inserta números y observa las rotaciones automáticas.");

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

