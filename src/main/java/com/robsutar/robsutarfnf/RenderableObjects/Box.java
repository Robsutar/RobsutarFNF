package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Box extends Rectangle {
    private double scale = 1,rotation;

    public double getScale() {
        return scale;
    }
    public double getRotation() {
        return rotation;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
    public void setWidth(int width){
        this.setSize(width, (int) getHeight());
    }

    public void setHeight(int height){
        this.setSize((int) getWidth(),height);
    }

    public void moveByCenter(AffineTransform at){
        at.translate(-getWidth()/2,-getHeight()/2);
    }

    public int getVisualX(){
        return (int) (x*getScale()-getScaledWidth()/2);
    }
    public int getVisualY(){
        return (int) (y*getScale()-getScaledHeight()/2);
    }

    public double getScaledWidth(){
        return this.getWidth()*scale;
    }
    public double getScaledHeight(){
        return this.getHeight()*scale;
    }
}
