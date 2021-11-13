package com.robsutar.robsutarfnf.Frame;

import com.robsutar.robsutarfnf.Handlers.Handlers;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(Handlers handlers){
        GamePanel panel = new GamePanel(handlers);

        this.add(panel);
        this.setTitle("Robsutar FNF engine! 0.03");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
