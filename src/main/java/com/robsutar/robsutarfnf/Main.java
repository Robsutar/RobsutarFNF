package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Menu.TitleMenu.TitleMenu;
import com.robsutar.robsutarfnf.RenderableObjects.Init.MousePositionIndicator;


public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*9/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static MainHandler handler = new MainHandler();

    public static Assets mainAssets;

    public static void main(String[] args){
        new WindowFrame();
        mainAssets = new Assets();

        TitleMenu titleMenu = new TitleMenu();
        titleMenu.spawn();

        new MousePositionIndicator();
    }
}
