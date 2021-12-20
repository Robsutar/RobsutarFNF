package com.robsutar.robsutarfnf;


import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Audio.AudioManager;
import com.robsutar.robsutarfnf.Audio.Music;
import com.robsutar.robsutarfnf.Files.WavFiles;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.TextBox;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {
    private static final String RESET = "\033[0m";
    private static final String RED_BOLD = "\033[1;31m";
    private static final String CYAN = "\033[0;36m";
    private static final String BLUE_BOLD = "\033[1;34m";

    public static String resourcesPath = new File("").getAbsolutePath()+"/resources/";
    public static String assetsPath = resourcesPath+"assets/";
    public static String phasesPath = resourcesPath+"phases/";
    public static String soundsPath = assetsPath+"sounds/";
    public static String texturesPath = assetsPath+"textures/";

    public final AtlasConfig GF_DANCE_TITLE;

    public final BufferedImage WALLPAPER;

    public final Music INTRODUCTION_MUSIC;

    public Assets(){
        TextBox box = new TextBox(450,111,"Loading","assets", Color.blue);
        box.spawn();

        box.setSubtitle("animations");
        GF_DANCE_TITLE = XmlFiles.readTextureAtlasXml(assetsPath+"animatedObjects/gfDance/gfDance.xml");
        box.setSubtitle("images");
        WALLPAPER = ImageManager.loadImage(texturesPath+"wallpaper.jpg");
        box.setSubtitle("sounds");
        INTRODUCTION_MUSIC = new Music(WavFiles.loadWav(soundsPath+"introduction.wav"),126);

        box.kill();
    }

    public static void loading(String string, String fileType){
        System.out.println(BLUE_BOLD+"Loading "+CYAN+fileType+": "+RESET+string);
    }
    public static void failedLoad(String string){
        System.out.println(RED_BOLD+"Failed to load: "+RESET+string);
    }
}
