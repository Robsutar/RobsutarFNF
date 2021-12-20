package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Audio.Music;
import com.robsutar.robsutarfnf.Files.WavFiles;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.BpmVisualizer;
import com.robsutar.robsutarfnf.RenderableObjects.SimpleText;
import com.robsutar.robsutarfnf.RenderableObjects.TextBox;
import com.robsutar.robsutarfnf.RenderableObjects.Gameplay.Player;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*9/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static Assets mainAssets;

    public static MainHandler handler = new MainHandler();
    public static void main(String[] args){
        new WindowFrame();
        mainAssets = new Assets();

        //new GameIntroduction();

        //new MousePositionIndicator();

        BpmVisualizer bpmVisualizer = new BpmVisualizer();

        //handler.setActualMusic(mainAssets.INTRODUCTION_MUSIC);


        SimpleText text = new SimpleText(WIDTH/2,HEIGHT/2,"&#R&#o&#b&#s&#u&#t&#a&#r &#R&#o&#b&#s&#u&#t&#a&#r &#R&#o&#b&#s&#u&#t&#a&#r");

        Player p = new Player(WIDTH/2,HEIGHT/2,mainAssets.GF_DANCE_TITLE);

        RenderableObject background =  new RenderableObject(WIDTH/2,HEIGHT/2,mainAssets.WALLPAPER);
        background.setPriority((byte) 0);
        background.setScale(0.63);

        text.spawn();
        bpmVisualizer.spawnBpm();
        //p.spawn();
        //background.spawn();


    }
}
