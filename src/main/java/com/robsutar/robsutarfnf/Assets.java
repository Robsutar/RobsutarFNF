package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Assets {
    boolean externalTexture = false;
    private static String resourcepackFolder = Main.resourcesPath+"assets/";
    public  Assets(String resourcepackFolder){
        if (resourcepackFolder != null){
            Assets.resourcepackFolder =  Main.resourcesPath+resourcepackFolder+"/";externalTexture=true;
        }


    }
    public static class AssetsTextures{
        public static final String packFolder = resourcepackFolder+"textures/";
        public static BufferedImage START_MENU_BACKGROUND = ImageManager.loadImage(packFolder+"startMenuBackground.png");
        public static BufferedImage START_MENU_OPTION = ImageManager.loadImage(packFolder+"startMenuOption.png");
    }
    public static class AssetsXml{
        public static final String packFolder = resourcepackFolder+"animatedObjects/";

        public static AtlasConfig GF_DANCE = XmlFiles.readTextureAtlasXml(packFolder+"gfDance.xml");
    }
}