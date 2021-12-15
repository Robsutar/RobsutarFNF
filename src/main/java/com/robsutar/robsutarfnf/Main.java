package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.Gameplay.Player;
import com.robsutar.robsutarfnf.RenderableObjects.Init.MousePositionIndicator;
import com.robsutar.robsutarfnf.RenderableObjects.Init.TextInformation;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.image.BufferedImage;

public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*9/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static float bpm = 120;

    public static MainHandler handler = new MainHandler();

    public static void main(String[] args){
        new WindowFrame();
        new MousePositionIndicator();

        BufferedImage menuOption = ImageManager.loadImage(Assets.assetsPath+"textures/menu/menuOption.png");

        Player p = new Player(WIDTH/2,HEIGHT/2,XmlFiles.readTextureAtlasXml(Assets.assetsPath+"animatedObjects/gfDance/gfDance.xml"));

        RenderableObject ob =  new RenderableObject(WIDTH/2,HEIGHT/2,menuOption);

        //TextInformation text = new TextInformation("&1Loading &2"+"lov"+": &7"+"path",menuOption);
        TextInformation text = new TextInformation(new String[]{"&1Loading ","&2"+"fileTpezinDoi"+": ","&7"+"user/robsutar/gfdance"},null);
        p.spawn();
        text.spawn();
    }
}
