package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Frame.GameFrame;
import com.robsutar.robsutarfnf.Handlers.MainHandler;
import com.robsutar.robsutarfnf.RenderableObjects.Menus.TitleScream;
import com.robsutar.robsutarfnf.RenderableObjects.Player.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
public class Main {
    public static String resourcesPath = new File("").getAbsolutePath()+"/resources/";
    public static String assetsPath = resourcesPath+"assets/";
    public static String phasesPath = resourcesPath+"phases/";
    public static String loadingConsoleMessage = "Loading ";
    public static String failedToLoadConsoleMessage = ("Failed to load ");

    public static int xMouse=0;
    public static int yMouse=0;
    private static int WIDTH=1280,HEIGHT=720;

    private static double timer = System.currentTimeMillis();

    public static byte state = 0;
    private static float bpm = 120;

    private static boolean showMousePos = true;

    public static MainHandler mainHandler = new MainHandler();

    public static void main(String[] args){
        new GameFrame();
        new TitleScream(WIDTH/2,HEIGHT/2);
        //new Player(WIDTH/2,HEIGHT/2, XmlFiles.readTextureAtlasXml(phasesPath+"qt/robot.xml"));
    }
    public static int getxMouse() {
        return xMouse;
    }
    public static int getyMouse() {
        return yMouse;
    }

    public static void tick(){
        mainHandler.tick();
        bpmTick();
    }

    public static void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        mainHandler.renderer(g2d);
        if (showMousePos){
            g2d.setColor(Color.yellow);
            g2d.drawString(getxMouse()+" "+getyMouse(),getxMouse(),getyMouse());}

    }

    public static void bpmTick(){
        while(System.currentTimeMillis() - timer > 1000.0/(bpm/60.0)/15) {
            timer += 1000.0/(bpm/60.0)/15;
            mainHandler.bpmTick();
        }
    }

    public static void mousePressed(MouseEvent e) {
        mainHandler.mousePressed(e);
    }

    public static void mouseReleased(MouseEvent e) {
        mainHandler.mouseReleased(e);
    }

    public static void keyPressed(KeyEvent e){
        mainHandler.keyPressed(e);
    }
}
