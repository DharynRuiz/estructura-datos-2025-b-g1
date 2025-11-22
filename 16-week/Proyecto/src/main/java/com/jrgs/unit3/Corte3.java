package com.jrgs.unit3;

import javax.swing.*;

public class Corte3 {
    JPanel mainPanel;
    private JButton AVLTREEDEMOButton;
    private JButton BSTDEMOButton;
    private JButton GRAPHDEMOButton;
    private JButton COMPLEJIDADDEMOButton;
    public Corte3() {

        AVLTREEDEMOButton.addActionListener(e -> AVLTreeDemo.run());
        BSTDEMOButton.addActionListener(e -> BSTDemo.run());
        GRAPHDEMOButton.addActionListener(e -> GraphDemo.run());
        COMPLEJIDADDEMOButton.addActionListener(e -> ComplejidadDemo.run());

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Corte3");
        frame.setContentPane(new Corte3().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(250,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
