package com.jrgs.unit3;

import javax.swing.*;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "LINKEDLIST INTERACTIVO:\n" +
                        "- Ingresa nombres.\n" +
                        "- Se agregará también uno al inicio y uno al final.\n" +
                        "- Observa el orden final.");

        LinkedList<String> lista = new LinkedList<>();

        int total = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuántos nombres quieres agregar?"));

        for (int i = 0; i < total; i++) {
            String nombre = JOptionPane.showInputDialog("Ingresa nombre " + (i + 1) + ":");
            lista.add(nombre);
        }

        // Ejemplos de operaciones típicas
        lista.addFirst("Inicio");
        lista.addLast("Final");

        StringBuilder sb = new StringBuilder("Contenido de la LinkedList:\n");
        for (String elemento : lista) {
            sb.append("- ").append(elemento).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}

