package com.jrgs.unit3;

import javax.swing.*;

public class ComplejidadDemo {

    public static void run() {
        while (true) {
            String op = JOptionPane.showInputDialog(
                    "COMPLEJIDAD ALGORÍTMICA (Big-O)\n" +
                            "1. O(1)\n" +
                            "2. O(n)\n" +
                            "3. O(n²)\n" +
                            "4. Salir");

            if (op == null) return;

            switch (op) {
                case "1":
                    JOptionPane.showMessageDialog(null,
                            "O(1): Tiempo constante.\n" +
                                    "Ejemplo: Acceder a un índice de un array.");
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null,
                            "O(n): Tiempo lineal.\n" +
                                    "Ejemplo: Recorrer un arreglo con un for.");
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null,
                            "O(n²): Tiempo cuadrático.\n" +
                                    "Ejemplo: Doble for anidado.");
                    break;

                case "4":
                    return;
            }
        }
    }
}
