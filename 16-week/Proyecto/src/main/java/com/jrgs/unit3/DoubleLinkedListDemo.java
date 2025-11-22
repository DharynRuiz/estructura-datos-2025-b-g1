package com.jrgs.unit3;

import javax.swing.*;
import java.util.LinkedList;

public class DoubleLinkedListDemo {

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "LISTA DOBLEMENTE ENLAZADA (INTERACTIVO):\n" +
                        "- Ingresa números.\n" +
                        "- Se recorrerá hacia adelante y hacia atrás.\n" +
                        "- Observa cómo permite doble dirección.");

        LinkedList<Integer> lista = new LinkedList<>();

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuántos números quieres agregar?"));

        for (int i = 0; i < cantidad; i++) {
            int n = Integer.parseInt(JOptionPane.showInputDialog(
                    "Número " + (i + 1) + ":"));
            lista.add(n);
        }

        StringBuilder sb = new StringBuilder("Recorrido hacia adelante:\n");
        for (int n : lista) sb.append(n).append(" ");

        sb.append("\n\nRecorrido hacia atrás:\n");
        for (int i = lista.size() - 1; i >= 0; i--) {
            sb.append(lista.get(i)).append(" ");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}

