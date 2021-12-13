package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;

public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*8/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static float bpm = 120;

    public static MainHandler handler = new MainHandler();

    public static Graphics2D defaultG2d;

    public static void main(String[] args){
        new WindowFrame();

        RenderableObject ob =  new RenderableObject(WIDTH/2,HEIGHT/2);
        ob.setActualImage(ImageManager.loadImage(Assets.assetsPath+"textures/menu/menuOption.png"),true);
        ob.spawn();
    }
}
