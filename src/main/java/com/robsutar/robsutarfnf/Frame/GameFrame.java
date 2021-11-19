package com.robsutar.robsutarfnf.Frame;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        GamePanel panel = new GamePanel();

        this.add(panel);
        this.setTitle("Robsutar FNF engine! 2.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
