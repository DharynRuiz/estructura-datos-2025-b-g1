package com.jrgs.unit3;

import javax.swing.*;

public class Corte1 {
   public JPanel mainPanel;
    private JButton ARRAYSDEMOButton;
    private JButton LINKDLISTDEMOButton;
    private JButton DOUBLELINKDLISTDEMOButton;
    private JButton FUNDAMENTOSDEMOButton;

    public Corte1() {

        ARRAYSDEMOButton.addActionListener(e -> ArraysDemo.run());
        LINKDLISTDEMOButton.addActionListener(e -> LinkedListDemo.run());
        DOUBLELINKDLISTDEMOButton.addActionListener(e -> DoubleLinkedListDemo.run());
        FUNDAMENTOSDEMOButton.addActionListener(e -> FundamentosDemo.run());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Corte1");
        frame.setContentPane(new Corte1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(250,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
