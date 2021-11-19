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
    public static String phasesPath = assetsPath+"phases/";

    public static String loadingConsoleMessage = "Loading ";
    public static String failedToLoadConsoleMessage = ("Failed to load ");

    public static int xMouse;
    public static int yMouse;

    public static byte state = 0;

    public static MainHandler mainHandler = new MainHandler();

    public static void main(String[] args){

        new GameFrame();

        MenuHandler menuHandler=new MenuHandler();

        mainHandler.addHandler(menuHandler);

        String liannaPhaseFolder = phasesPath+"lianna/";
        String lianaJsonConfig = liannaPhaseFolder+"lianna-Config.json";
        JsonFiles.writePhaseConfig(liannaPhaseFolder+"lianna-Config.json");

    }
    public static int getxMouse() {
        return xMouse;
    }
    public static int getyMouse() {
        return yMouse;
    }

    public static void tick(){
    }

    public static void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        mainHandler.onRenderer(g2d);
    }

    public static void mousePressed(MouseEvent e) {
        mainHandler.onMousePressed(e);
    }

    public static void mouseReleased(MouseEvent e) {
        mainHandler.onMouseReleased(e);
    }
}
