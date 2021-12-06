package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Position.ExtendedPosition;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

public class Assets {
    boolean externalTexture = false;
    private static String resourcepackFolder = Main.assetsPath;
    public Assets(String resourcepackFolder){
        if (resourcepackFolder != null){
            Assets.resourcepackFolder =  Main.resourcesPath+resourcepackFolder+"/";externalTexture=true;
        }
    }
    public static class AssetsImages{
        public static final String packFolder = resourcepackFolder+"textures/";
        public static BufferedImage GF_DANCE_TITLE = ImageManager.loadImage(packFolder+"gfDance/gfDanceTitle.png");
    }
    public static class AssetsXml{
        public static final String packFolder = resourcepackFolder+"animatedObjects/";
        public static final AtlasConfig GF_DANCE_TITLE = XmlFiles.readTextureAtlasXml(packFolder+"gfDance/gfDance.xml");

    }
    public static class AssetsExtendedPosition{
    }
}
