package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.image.BufferedImage;


public class StartMenu extends Box{
    private final BufferedImage image =  ImageManager.loadImage(Main.assetsPath +"box.png");

    public StartMenu(int x, int y, int width, int height,AnimatedObject animatedObject) {
        super(x, y, width, height,animatedObject);
        isAnimated(true);
    }
    @Override
    public void tick(){
        setState(getAge()/20);
    }
}
