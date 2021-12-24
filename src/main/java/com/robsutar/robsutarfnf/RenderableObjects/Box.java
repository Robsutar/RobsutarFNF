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
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}

    @Override
    public double getCenterX() {return x-getWidth()/2.0;}
    @Override
    public double getCenterY() {
        return y-getHeight()/2.0;
    }
}
