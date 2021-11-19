package com.robsutar.robsutarfnf.Menus.Buttons;

import com.robsutar.robsutarfnf.AbstractObjects.Box;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BaseButton extends Box {
    BufferedImage image;
    public BaseButton(BufferedImage image,int x,int y){
        setPosition(x,y);
        this.image=image;
    }

    @Override
    protected void renderer(Graphics2D g) {
        g.setBackground(Color.blue);
        g.fillRect(Main.getMouseX(),Main.getMouseY(),50,50);
        ImageManager.makeImage(image,getX(),getY(),g);
    }

    @Override
    public void tick() {

    }
}
