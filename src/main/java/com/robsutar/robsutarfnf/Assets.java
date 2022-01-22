package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static Image ICON;
    public static BufferedImage BACKGROUND;

    public static BufferedImage MENU_OPTION;

    public static Atlas GF_TITLE;

    public static Atlas TEMPORARY_ROBOT;

    public static Font HEAVY_FONT;

    public static Font LIGHT_FONT;

    public Assets(String assetsTextureFolder){
        if (assetsTextureFolder!=null){
            assetsTextureFolder = FileManager.texturesPath+assetsTextureFolder+"/";
        }
        ICON = FileManager.loadImage(FileManager.loadFile("icon.png",assetsTextureFolder));

        BACKGROUND = FileManager.loadImage(FileManager.loadFile("textures/wallpaper.jpg",assetsTextureFolder));

        MENU_OPTION = FileManager.loadImage(FileManager.loadFile("textures/menuOption.png",assetsTextureFolder));

        GF_TITLE = new Atlas(FileManager.loadFile("animatedObjects/gfDance/gfDance.xml",assetsTextureFolder));

        TEMPORARY_ROBOT = new Atlas(FileManager.loadFile("phases/qt/robot.xml",assetsTextureFolder));

        HEAVY_FONT = FileManager.loadFont(FileManager.loadFile("cocoSharp-heavy.ttf",assetsTextureFolder));

        LIGHT_FONT = FileManager.loadFont(FileManager.loadFile("cocoSharp-light.ttf",assetsTextureFolder));
    }
}
