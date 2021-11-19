package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.AbstractObjects.Box;
import com.robsutar.robsutarfnf.AnimationBuilder.AnimationFactory;
import com.robsutar.robsutarfnf.AnimationBuilder.SpriteJsonConfig;
import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Frame.GameFrame;
import com.robsutar.robsutarfnf.Handlers.GuiHandler;
import com.robsutar.robsutarfnf.Handlers.Handlers;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.InGameObjects.Player;
import com.robsutar.robsutarfnf.Menus.Buttons.BaseButton;

import java.awt.*;
import java.io.File;

public class Main {
    static Handlers handlers = new Handlers();

    //xxs66232145
    public static String resourcesPath = new File("src/main/resources/").getAbsolutePath();
    public static String assetsPath = resourcesPath+"/assets/";
    public static String phasesPath = assetsPath+ "/phases/";
    public static String loadingConsoleMessage = "Loading: ";public static String failedToLoadConsoleMessage = ("Failed to load ");

    public static int xMouse;
    public static int yMouse;

    public static byte state = 0;

    public static void main(String[] args){

        new GameFrame(handlers);

        String liannaPhaseFolder = phasesPath+"lianna/";
        String lianaJsonConfig = liannaPhaseFolder+"lianna-Config.json";
        JsonFiles.writePhaseConfig(liannaPhaseFolder+"lianna-Config.json");

        BaseButton button = new BaseButton(ImageManager.loadImage(assetsPath+"/cenary/img.png"),50,50);
        Player player1 = new Player(lianaJsonConfig,liannaPhaseFolder);

        GuiHandler guiHandler =  new GuiHandler();
        guiHandler.addObject(button);
        guiHandler.addObject(player1);
        handlers.addHandler(guiHandler);

    }
    public static void tick(){
        handlers.handlersTick();
    }
    public static void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        handlers.handlersRenderer(g2d);
    }
    public static int getMouseX() {
        return xMouse;
    }

    public static int getMouseY() {
        return yMouse;
    }
}
