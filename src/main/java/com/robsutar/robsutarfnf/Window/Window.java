package com.robsutar.robsutarfnf.Window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static Dimension windowDim = Toolkit.getDefaultToolkit().getScreenSize();
    private static boolean fullscreen = false;

    public static Window frame;

    public Window(){

        GamePanel panel = new GamePanel();
        panel.setBackground(Color.BLACK);

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
        this.setSize(windowDim);
        this.setUndecorated(noBorder);

        this.setVisible(true);
        this.setLocationRelativeTo(null);

        if (!noBorder){
            Dimension contentPanel = this.getContentPane().getSize();
            int wBorder = windowDim.width-contentPanel.width;
            int yBorder = windowDim.height-contentPanel.height;
            this.setSize(new Dimension(windowDim.width+wBorder, windowDim.height+yBorder));
        }
    }

    public void setWindowDim(Dimension dim){windowDim = dim;}

    public void fullScreen(){resize(Toolkit.getDefaultToolkit().getScreenSize(),true);fullscreen=true;}
    public void bigScreen(){resize(bigWindow(),false);}
    public void mediumScreen(){resize(mediumWindow(),false);}

    public static int wdt(){return windowDim.width;}
    public static int hgt(){
        return windowDim.height;
    }

    private Dimension getWindowDim(double multiplier){
        Dimension wd = Toolkit.getDefaultToolkit().getScreenSize();
        wd.width*=multiplier;wd.height*=multiplier;

        int supWidth = wd.height*16/9;
        int supHeight = wd.width*9/16;

        Dimension dimension;

        if (supWidth>wd.width){
            dimension = new Dimension(wd.width,supHeight);
        } else if (supHeight>wd.height){
            dimension = new Dimension(supWidth,wd.height);
        } else {
            dimension = new Dimension(supWidth,supHeight);
        }

        return dimension;
    }

    private Dimension mediumWindow (){
        return getWindowDim(0.6);
    }
    private Dimension bigWindow (){
        return getWindowDim(0.8);
    }

}
