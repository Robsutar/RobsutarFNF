package com.robsutar.robsutarfnf.RenderableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class RenderableObject extends Position{

    private int width=0,height=0;

    protected double scale = 1;
    protected double targetScale = 1;

    protected boolean animating = true;
    protected boolean backToOriginalScale = true;

    private BufferedImage actualImage;

    private AffineTransform actualTransform;


    public RenderableObject(int x, int y) {
        super(x, y);
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setActualImage(BufferedImage actualImage) {
        this.actualImage = actualImage;
    }
    public void setActualTransform(AffineTransform actualTransform) {
        this.actualTransform = actualTransform;
    }
    public BufferedImage getActualImage() {
        return actualImage;
    }
    public AffineTransform getActualTransform() {
        AffineTransform at = new AffineTransform(actualTransform);
        at.translate(getX()-(getWidth()/2.0)*scale,getY()-(getHeight()/2.0)*scale);
        at.scale(scale,scale);
        return at;
    }

    public void setBackToOriginalScale(boolean backToOriginalScale) {
        this.backToOriginalScale = backToOriginalScale;
    }
    public void setAnimating(Boolean bool){
        this.animating=bool;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
    public void setTargetScale(double targetScale) {
        this.targetScale = targetScale;
    }



    public void tick() {
        onTick();
    }

    public void renderer(Graphics2D g2d){
        if (getActualImage()!=null&&getActualTransform()!=null) {
            g2d.drawImage(getActualImage(), getActualTransform(), null);
        }
    }
    public void bpmTick(){
        if(animating) {
            if (targetScale!=1) {
                scale += (targetScale - scale) / 5;
                targetScale = 1;
            }
            else if (backToOriginalScale&&scale!=1){
                scale -= (scale-1)/10;
            }
        }
        onBpmTick();
    }

    protected abstract void onTick();
    protected abstract void onBpmTick();
}
