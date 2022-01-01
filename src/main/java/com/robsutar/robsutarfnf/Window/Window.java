package com.robsutar.robsutarfnf.Window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static Dimension windowDim = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = windowDim.width, height = windowDim.height;
    private static boolean fullscreen = false;

    public static Window frame;

    public Window(){
        //windowDim = new Dimension(width/2,height/2);
        //width = windowDim.width; height = windowDim.height;

        GamePanel panel = new GamePanel();

        this.setTitle("Robsutar FNF");
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        bigScreen();

    }

    public static boolean isFullscreen() {
        return fullscreen;
    }

    public void resize(Dimension dim, boolean noBorder){
        fullscreen=false;
        setWindowDim(dim);

        this.dispose();
        this.setPreferredSize(windowDim);
        this.setUndecorated(noBorder);

        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void fullScreen(){
        resize(Toolkit.getDefaultToolkit().getScreenSize(),true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fullscreen=true;
    }

    public void resizedScreen(double divisor){
        Dimension windowDim = Toolkit.getDefaultToolkit().getScreenSize();
        windowDim.width/=divisor;windowDim.height/=divisor;
        resize(windowDim,false);
    }

    public void bigScreen(){
        resizedScreen(1.2);
    }

    public void mediumScreen(){
        resizedScreen(1.5);
    }

    public void setWindowDim(Dimension dim){
        windowDim = dim;
        width=windowDim.width;height=windowDim.height;
    }
}
