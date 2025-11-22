package com.jrgs.unit3;

import javax.swing.*;

public class ArraysDemo {

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "ARRRAYS INTERACTIVO:\n" +
                        "- Ingresa la cantidad de elementos.\n" +
                        "- Luego ingresarás cada valor.\n" +
                        "- Se mostrará el contenido del array.");

        // Pedir tamaño del array
        int size = Integer.parseInt(JOptionPane.showInputDialog(
                "¿Cuántos valores deseas guardar en el array?"));

        int[] numeros = new int[size];

        // Llenar el array con valores ingresados
        for (int i = 0; i < size; i++) {
            numeros[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingresa el valor para la posición " + i + ":")
            );
        }

        // Mostrar contenido
        StringBuilder sb = new StringBuilder("Contenido del array:\n");
        for (int i = 0; i < numeros.length; i++) {
            sb.append("posición ").append(i)
                    .append(" → ").append(numeros[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}


