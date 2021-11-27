package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Frame.GameFrame;
import com.robsutar.robsutarfnf.Handlers.MainHandler;
import com.robsutar.robsutarfnf.Handlers.MenuHandler;

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

    public static MainHandler mainHandler = new MainHandler();

    public static  Camera camera;

    public static Camera.CameraState camState=new Camera.CameraState(0,0,0,1);

    public static void main(String[] args){

        new GameFrame();

        MenuHandler menuHandler=new MenuHandler();

        mainHandler.addHandler(menuHandler);

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
            mainHandler.onBpm();
        }
    }

    public static void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if (camera!=null){
            camState=camera.update();
        }
        Camera.construct(g2d,camState);

        mainHandler.onRenderer(g2d);

        if (showMousePos){
            g2d.setColor(Color.yellow);
            g2d.drawString(getxMouse()+" "+getyMouse(),getxMouse(),getyMouse());}
    }

    public static void mousePressed(MouseEvent e) {
        mainHandler.onMousePressed(e);
    }

    public static void mouseReleased(MouseEvent e) {
        mainHandler.onMouseReleased(e);
    }

    public static Dimension getWindowDim() {
        return  new Dimension(WIDTH,HEIGHT);
    }
}
