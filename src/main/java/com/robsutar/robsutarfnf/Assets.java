package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static Image ICON;
    public static BufferedImage BACKGROUND;

    public static BufferedImage MENU_OPTION;

    public static BufferedImage ARROW_UP;
    public static BufferedImage ARROW_DOWN;
    public static BufferedImage ARROW_LEFT;
    public static BufferedImage ARROW_RIGHT;

    public static Atlas GF_TITLE;

    public static Atlas TEMPORARY_ROBOT;

    public static Atlas ARROW_ASSETS;

    public static Font HEAVY_FONT;

    public static Font LIGHT_FONT;

    public Assets(String assetsTextureFolder){
        if (assetsTextureFolder!=null){
            assetsTextureFolder = FileManager.texturesPath+assetsTextureFolder+"\\";
        }
        ICON = FileManager.loadImage(FileManager.loadFile("icon.png",assetsTextureFolder));

        BACKGROUND = FileManager.loadImage(FileManager.loadFile("textures\\wallpaper.jpg",assetsTextureFolder));

        MENU_OPTION = FileManager.loadImage(FileManager.loadFile("textures\\menuOption.png",assetsTextureFolder));

        GF_TITLE = new Atlas(FileManager.loadFile("animatedObjects\\gfDance\\gfDance.xml",assetsTextureFolder));

        TEMPORARY_ROBOT = new Atlas(FileManager.loadFile("phases\\qt\\robot.xml",assetsTextureFolder));

        HEAVY_FONT = FileManager.loadFont(FileManager.loadFile("cocoSharp-heavy.ttf",assetsTextureFolder));

        LIGHT_FONT = FileManager.loadFont(FileManager.loadFile("cocoSharp-light.ttf",assetsTextureFolder));

        ARROW_ASSETS = new Atlas(FileManager.loadFile("toCut\\NOTE_assets.xml",assetsTextureFolder));

        ARROW_UP = ARROW_ASSETS.getImage(ARROW_ASSETS.getAnimationIndex("arrowUP"),0);
        ARROW_DOWN = ARROW_ASSETS.getImage(ARROW_ASSETS.getAnimationIndex("arrowDOWN"),0);
        ARROW_LEFT = ARROW_ASSETS.getImage(ARROW_ASSETS.getAnimationIndex("arrowLEFT"),0);
        ARROW_RIGHT = ARROW_ASSETS.getImage(ARROW_ASSETS.getAnimationIndex("arrowRIGHT"),0);
    }
}
