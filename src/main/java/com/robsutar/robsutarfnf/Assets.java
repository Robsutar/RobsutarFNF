package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.FileReader;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage BACKGROUND;

    public Assets(String assetsTextureFolder){
        if (assetsTextureFolder!=null){
            assetsTextureFolder = FileReader.texturesPath+assetsTextureFolder+"/";
        }
        BACKGROUND = FileReader.loadImage(FileReader.loadFile("textures/wallpaper.jpg",assetsTextureFolder));
    }
}
