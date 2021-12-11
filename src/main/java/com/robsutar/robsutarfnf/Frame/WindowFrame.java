package com.robsutar.robsutarfnf.Frame;

import com.robsutar.robsutarfnf.Main;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {
    private static Dimension windowDim = new Dimension(Main.WIDTH,Main.HEIGHT);
    public WindowFrame(){
        GamePanel panel = new GamePanel();

        this.add(panel);
        this.setTitle("Robsutar FNF");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}