package com.robsutar.robsutarfnf.Assets;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.image.BufferedImage;

public class MenuAssets {

    private String assetsPath = Main.assetsPath;
    private String animatedObjectsFolder = assetsPath+"animatedObjects/";
    private String texturesFolder = assetsPath+"textures/";
    public AtlasConfig GF_DANCE_TITLE = XmlFiles.readTextureAtlasXml(animatedObjectsFolder+"gfDance/gfDance.xml");
    public BufferedImage MENU_OPTION = ImageManager.loadImage(texturesFolder+"menu/menuOption.png");

    public MenuAssets(){

    }

}
