package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.Gameplay.Player;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;

public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*9/16;
    public static int simulatedWIDTH = 1920,simulatedHEIGHT = simulatedWIDTH*9/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static float bpm = 120;

    public static MainHandler handler = new MainHandler();

    public static void main(String[] args){
        new WindowFrame();

        Player p = new Player(simulatedWIDTH/2,simulatedHEIGHT/2,XmlFiles.readTextureAtlasXml(Assets.assetsPath+"animatedObjects/gfDance/gfDance.xml"));

        RenderableObject ob =  new RenderableObject(simulatedWIDTH/2,simulatedHEIGHT/2,ImageManager.loadImage(Assets.assetsPath+"textures/menu/menuOption.png"));
        ob.spawn();
        p.spawn();
    }
}
