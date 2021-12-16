package com.robsutar.robsutarfnf.RenderableObjects.Particles;

import com.robsutar.robsutarfnf.MainHandler;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Particle extends RenderableObject {
    private int speedX, speedY;
    private Color color;
    private int age;
    private int maxAge;
    public Particle(int x, int y, int speedX, int speedY,Color color,int maxAge) {
        super(x, y, null);
        this.speedX=speedX;this.speedY=speedY;this.color=color;this.maxAge=maxAge;
        width=10;height=10;
        vector.setVector(speedX,speedY);
        setPriority((byte) (MainHandler.maxRenderPriority-2));
        spawn();
    }

    @Override
    protected void onTick() {
        age++;
        setOpacity(1f-((float)age/(float)maxAge));
        if (age>=maxAge){
            kill();
        }
    }

    @Override
    protected void onRenderer(Graphics2D g2d) {
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getOpacity()));
        g2d.setColor(color);
        g2d.fillRect(x,y,width,height);
    }
}
