package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Frame.WindowFrame;
import com.robsutar.robsutarfnf.Menu.GameIntroduction;
import com.robsutar.robsutarfnf.Menu.WindowCubids;
import com.robsutar.robsutarfnf.RenderableObjects.Init.BpmVisualizer;
import com.robsutar.robsutarfnf.RenderableObjects.SimpleText;
import com.robsutar.robsutarfnf.RenderableObjects.Gameplay.Player;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

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

        SimpleText text = new SimpleText(WIDTH/2,HEIGHT/2,"&#R&#o&#b&#s&#u&#t&#a&#r &#R&#o&#b&#s&#u&#t&#a&#r &#R&#o&#b&#s&#u&#t&#a&#r");

        Player p = new Player(WIDTH/2,HEIGHT/2,mainAssets.GF_DANCE_TITLE);

        RenderableObject background =  new RenderableObject(WIDTH/2,HEIGHT/2,mainAssets.WALLPAPER);
        background.setScale(0.63);

        WindowCubids windowCubids = new WindowCubids();

        p.spawn();
    }
}
