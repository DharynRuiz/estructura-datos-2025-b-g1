package com.jrgs.unit3;

import javax.swing.*;
import java.util.Stack;

public class StackDemo {

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "DEMO DE STACK (Pila):\n" +
                        "- Funciona con LIFO (Último en entrar, primero en salir).\n" +
                        "- Puedes agregar valores (push) y retirar valores (pop).");

        Stack<String> pila = new Stack<>();

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "¿Qué deseas hacer?\n" +
                            "1. Push (agregar)\n" +
                            "2. Pop (retirar)\n" +
                            "3. Ver pila\n" +
                            "4. Salir");

            if (opcion == null) return;

            switch (opcion) {
                case "1":
                    String valor = JOptionPane.showInputDialog("Ingresa un valor a la pila:");
                    pila.push(valor);
                    break;

                case "2":
                    if (pila.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La pila está vacía.");
                    } else {
                        String eliminado = pila.pop();
                        JOptionPane.showMessageDialog(null, "Elemento retirado: " + eliminado);
                    }
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Pila actual:\n" + pila);
                    break;

                case "4":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}

