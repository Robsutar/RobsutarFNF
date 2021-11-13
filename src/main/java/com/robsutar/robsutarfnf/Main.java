package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimationFactory;
import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Frame.GameFrame;
import com.robsutar.robsutarfnf.Handlers.GuiHandler;
import com.robsutar.robsutarfnf.Handlers.Handlers;

import java.awt.*;
import java.io.File;

public class Main {
    static Handlers handlers = new Handlers();

    public static String resourcesPath = new File("src/main/resources/").getAbsolutePath();
    public static String phasesPath = resourcesPath+"/phases/";
    public static String loadingConsoleMessage = "Loading: ";public static String failedToLoadConsoleMessage = ("Failed to load ");

    public static void main(String[] args){

        new GameFrame(handlers);

        String liannaPhaseFolder = phasesPath+"lianna/";
        String lianaJsonConfig = liannaPhaseFolder+"lianna-Config.json";
        JsonFiles.writePhaseConfig(liannaPhaseFolder+"lianna-Config.json");
        AnimationFactory factory = new AnimationFactory(lianaJsonConfig,liannaPhaseFolder);

        GuiHandler guiHandler =  new GuiHandler(factory);
        handlers.addHandler(guiHandler);

    }
    public static void tick(){
        handlers.handlersTick();
    }
    public static void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        handlers.handlersRenderer(g2d);
    }
}
