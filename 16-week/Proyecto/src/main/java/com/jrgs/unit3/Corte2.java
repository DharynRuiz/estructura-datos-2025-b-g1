package com.jrgs.unit3;

import javax.swing.*;

public class Corte2 {
    JPanel mainPanel;
    private JButton STACKDEMOButton;
    private JButton QUEUEDEMOButton;
    private JButton HASHTABLEDEMOButton;
    private JButton BINARYTREEDEMOButton;
    public Corte2() {

        STACKDEMOButton.addActionListener(e -> StackDemo.run());
        QUEUEDEMOButton.addActionListener(e -> QueueDemo.run());
        HASHTABLEDEMOButton.addActionListener(e -> HashTableDemo.run());
        BINARYTREEDEMOButton.addActionListener(e -> BinaryTreeDemo.run());
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Corte2");
        frame.setContentPane(new Corte2().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(250,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
