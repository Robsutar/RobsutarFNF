package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Files.FileManager;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage BACKGROUND;

    public static BufferedImage MENU_OPTION;

    public static Atlas GF_TITLE;

    public Assets(String assetsTextureFolder){
        if (assetsTextureFolder!=null){
            assetsTextureFolder = FileManager.texturesPath+assetsTextureFolder+"/";
        }
        BACKGROUND = FileManager.loadImage(FileManager.loadFile("textures/wallpaper.jpg",assetsTextureFolder));

        MENU_OPTION = FileManager.loadImage(FileManager.loadFile("textures/menuOption.png",assetsTextureFolder));

        GF_TITLE = new Atlas(FileManager.loadFile("animatedObjects/gfDance/gfDance.xml",assetsTextureFolder));
    }
}
