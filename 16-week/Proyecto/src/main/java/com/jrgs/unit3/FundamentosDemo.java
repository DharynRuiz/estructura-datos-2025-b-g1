package com.jrgs.unit3;

import javax.swing.*;

public class FundamentosDemo {

    public static void run() {

        JOptionPane.showMessageDialog(null,
                "FUNDAMENTOS INTERACTIVO:\n" +
                        "- Ingresa dos números.\n" +
                        "- Verás operaciones básicas.");

        int a = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor de A:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor de B:"));

        int suma = a + b;
        int resta = a - b;
        int multi = a * b;
        double div = (b != 0) ? (double)a / b : Double.NaN;

        String msg =
                "Valores ingresados:\n" +
                        "A = " + a + "\n" +
                        "B = " + b + "\n\n" +
                        "Operaciones:\n" +
                        "A + B = " + suma + "\n" +
                        "A - B = " + resta + "\n" +
                        "A * B = " + multi + "\n" +
                        "A / B = " + div;

        JOptionPane.showMessageDialog(null, msg);
    }
}

