package com.robsutar.robsutarfnf.Menus.Buttons;

import com.robsutar.robsutarfnf.AbstractObjects.Box;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BaseButton extends Box {
    BufferedImage image;
    public BaseButton(BufferedImage image){
        this.image=image;
    }

    @Override
    protected void renderer(Graphics2D g) {
        g.setBackground(Color.blue);
        g.fillRect(50,50,50,50);
        g.drawImage(this.image,getX(),getY(),getWidth(),getHeight(),null);
    }

    @Override
    protected void onTick() {
        System.out.println("basebuttoins");

    }
}
