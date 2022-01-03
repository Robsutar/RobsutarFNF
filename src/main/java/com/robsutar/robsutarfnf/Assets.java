package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Files.FileManager;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage BACKGROUND;

    public static Atlas GF_TITLE;

    public Assets(String assetsTextureFolder){
        if (assetsTextureFolder!=null){
            assetsTextureFolder = FileManager.texturesPath+assetsTextureFolder+"/";
        }
        BACKGROUND = FileManager.loadImage(FileManager.loadFile("textures/wallpaper.jpg",assetsTextureFolder));

        GF_TITLE = new Atlas(FileManager.loadFile("phases/qt/robot.xml",assetsTextureFolder));
    }
}
