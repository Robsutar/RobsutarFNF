package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.image.BufferedImage;


public class StartMenu extends Box{
    private final BufferedImage image =  ImageManager.loadImage(Main.assetsPath +"box.png");

    public StartMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        setImage(image);
    }

    @Override
    protected void renderer(Graphics2D g2d) {
        if (isMouseAbove()){
            g2d.setColor(Color.cyan);
            g2d.drawImage(getImage(),getX(),getY(),null);
        } else{
            g2d.setColor(Color.red);
        }
        g2d.fillRect(getX(),getY(),getWidth()/2,getHeight()/2);
        g2d.drawString((Main.getxMouse()+"  "+Main.getyMouse()),Main.getxMouse(),Main.getyMouse());
    }
}
