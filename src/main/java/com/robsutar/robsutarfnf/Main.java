package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Frame.GameFrame;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

public class Main {
    public static String resourcesPath = new File("").getAbsolutePath()+"/resources/";
    public static String assetsPath = resourcesPath+"assets/";
    public static String phasesPath = resourcesPath+"phases/";
    public static String loadingConsoleMessage = "Loading ";
    public static String failedToLoadConsoleMessage = ("Failed to load ");

    public static int xMouse;
    public static int yMouse;
    private static int WIDTH=1280,HEIGHT=720;

    private static double timer = System.currentTimeMillis();

    public static byte state = 0;
    private static float bpm = 120;
    private static char divisor = 16;

    private static boolean showMousePos = true;

    public static void main(String[] args){

        new GameFrame();

    }
    public static int getxMouse() {
        return xMouse;
    }
    public static int getyMouse() {
        return yMouse;
    }

    public static void tick(){
        while(System.currentTimeMillis() - timer > 1000.0/(bpm/60.0)/divisor) {
            timer += 1000.0/(bpm/60.0)/divisor;
        }
    }

    public static void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if (showMousePos){
            g2d.setColor(Color.yellow);
            g2d.drawString(getxMouse()+" "+getyMouse(),getxMouse(),getyMouse());}
    }

    public static Dimension getWindowDim() {
        return  new Dimension(WIDTH,HEIGHT);
    }

    public static void mouseReleased(MouseEvent e) {
    }

    public static void mousePressed(MouseEvent e) {
    }
}
