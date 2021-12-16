package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.TextBox;
import com.robsutar.robsutarfnf.RenderableObjects.Gameplay.Player;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*9/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static float bpm = 120;

    public static Assets mainAssets;

    public static MainHandler handler = new MainHandler();;

    public static void main(String[] args){
        new WindowFrame();
        mainAssets = new Assets();

        //new MousePositionIndicator();

        BufferedImage wallpaper = mainAssets.WALLPAPER;

        Player p = new Player(WIDTH/2,HEIGHT/2,mainAssets.GF_DANCE_TITLE);

        RenderableObject background =  new RenderableObject(WIDTH/2,HEIGHT/2,wallpaper);
        background.setPriority((byte) 0);
        background.setScale(0.63);

        p.spawn();
        background.spawn();
    }
}
