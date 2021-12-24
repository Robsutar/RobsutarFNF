package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;
import com.robsutar.robsutarfnf.RenderableObjects.Gameplay.Player;

public class Main {
    public static int WIDTH = 1620,HEIGHT = WIDTH*9/16;
    public static int xMouse = WIDTH/2, yMouse = HEIGHT/2;

    public static MainHandler handler = new MainHandler();

    public static Assets mainAssets;

    public static void main(String[] args){
        new WindowFrame();
        mainAssets = new Assets();

        Player p = new Player(Main.WIDTH/2,Main.HEIGHT/2,mainAssets.GF_DANCE_TITLE);
        Player p2 = new Player(Main.WIDTH/2,Main.HEIGHT/2,XmlFiles.readTextureAtlasXml(Assets.phasesPath+"qt/robot.xml"));
        p.spawn();
        p2.spawn();
        p2.setPriority(p2.getPriority()+1);
    }
}
