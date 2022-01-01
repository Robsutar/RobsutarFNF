package com.robsutar.robsutarfnf.Window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static Dimension windowDim = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = windowDim.width, height = windowDim.height;

    public Window(){
        windowDim = new Dimension(width/2,height/2);

        width = windowDim.width; height = windowDim.height;

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
