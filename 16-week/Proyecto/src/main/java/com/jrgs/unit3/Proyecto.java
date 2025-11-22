package com.jrgs.unit3;

import javax.swing.*;

public class Proyecto {
    private JPanel mainPanel;
    private JButton corte1Button;
    private JButton corte2Button;
    private JButton corte3Button;
    public Proyecto() {
        corte1Button.addActionListener(e -> {
            JFrame frame = new JFrame("Corte 1");
            frame.setContentPane(new Corte1().mainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        corte2Button.addActionListener(e -> {
            JFrame frame = new JFrame("Corte 2");
            frame.setContentPane(new Corte2().mainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        corte3Button.addActionListener(e -> {
            JFrame frame = new JFrame("Corte 3");
            frame.setContentPane(new Corte3().mainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Proyecto");
        frame.setContentPane(new Proyecto().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(250,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
