package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimationStream;
import com.robsutar.robsutarfnf.AnimationBuilder.Stream;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class RenderableObject extends Position implements Renderable {
    private int width,height;
    private double scale=0.5;
    double rotation = 0;

    protected BufferedImage actualImage;
    protected Stream actualStream = new Stream();

    public RenderableObject(Position position){
        super(position);
    }

    public void setActualImage(BufferedImage actualImage) {
        this.actualImage = actualImage;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getOriginalWidth(){
        return width;
    }
    public int getOriginalHeight(){
        return height;
    }

    public int getWidth() {
        return (int) (width*getScale());
    }
    public int getHeight() {
        return (int) (height*getScale());
    }

    public AffineTransform getActualTransform() {
        AffineTransform at = new AffineTransform();
        at.translate(x-getWidth()/2,y-getWidth()/2);
        at.rotate(Math.toRadians(rotation),getWidth()/2.0,getHeight()/2.0);
        at.scale(getScale(),getScale());
        return at;
    }

    public double getScale() {
        return scale+ actualStream.getScale();
    }

    @Override
    public void renderer(Graphics2D g2d) {
        if (actualImage!=null) {
            g2d.fillRect(x-getWidth()/2,y-getHeight()/2,getWidth(),getHeight());
            g2d.drawImage(actualImage, getActualTransform(), null);
        }
    }
}
