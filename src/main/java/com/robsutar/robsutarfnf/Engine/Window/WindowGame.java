package com.robsutar.robsutarfnf.Engine.Window;

import com.robsutar.robsutarfnf.Engine.Graphics.Camera;

import javax.swing.*;
import java.awt.*;

public class WindowGame extends JFrame {
    public static Dimension windowDim = Toolkit.getDefaultToolkit().getScreenSize();
    private static boolean fullscreen = false;

    public static WindowGame frame;
    public static GamePanel panel;

    public WindowGame(){
        frame=this;
        panel=new GamePanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.setFocusable(true);

        this.setTitle("Robsutar FNF");
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        bigScreen();
    }

    public static boolean isFullscreen() {
        return fullscreen;
    }

    public static void resize(Dimension dim, boolean noBorder){
        fullscreen=false;

        frame.setWindowDim(dim);

        frame.dispose();
        frame.setSize(windowDim);
        frame.setUndecorated(noBorder);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        if (!noBorder){
            Dimension contentPanel = frame.getContentPane().getSize();
            int wBorder = windowDim.width-contentPanel.width;
            int yBorder = windowDim.height-contentPanel.height;
            frame.setSize(new Dimension(windowDim.width+wBorder, windowDim.height+yBorder));
        }
        Camera.getCamera().setDimension(WindowGame.windowDim);
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
