package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Menu.MainMenu.TitleMenu;
import com.robsutar.robsutarfnf.Menu.WindowCuboids;

import java.awt.*;

public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*9/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static MainHandler handler = new MainHandler();

    public static Assets mainAssets;

    public static void main(String[] args){
        new WindowFrame();
        mainAssets = new Assets();

        new TitleMenu();
    }
}
