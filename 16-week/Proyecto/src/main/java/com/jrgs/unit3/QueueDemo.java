package com.jrgs.unit3;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "DEMO DE QUEUE (Cola):\n" +
                        "- Funciona con FIFO (Primero entra, primero sale).\n" +
                        "- Puedes encolar y desencolar valores.");

        Queue<String> cola = new LinkedList<>();

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "¿Qué deseas hacer?\n" +
                            "1. Enqueue (agregar)\n" +
                            "2. Dequeue (retirar)\n" +
                            "3. Ver cola\n" +
                            "4. Salir");

            if (opcion == null) return;

            switch (opcion) {
                case "1":
                    String valor = JOptionPane.showInputDialog("Ingresa un valor a la cola:");
                    cola.add(valor);
                    break;

                case "2":
                    if (cola.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La cola está vacía.");
                    } else {
                        String eliminado = cola.poll();
                        JOptionPane.showMessageDialog(null, "Elemento retirado: " + eliminado);
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Cola actual:\n" + cola);
                    break;

                case "4":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}

