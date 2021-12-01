package com.robsutar.robsutarfnf.Frame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private static int width = 1280;
    private static int height = 720;
    private static Dimension windowDim = new Dimension(width,height);
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

    public static int width() {
        return width;
    }

    public static int height() {
        return height;
    }

    public static Dimension getWindowDim() {
        return windowDim;
    }
}
