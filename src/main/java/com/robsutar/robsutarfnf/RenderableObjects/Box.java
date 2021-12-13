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

    public void setWidth(int width){
        this.setSize(width, (int) getHeight());
    }
    public void setHeight(int height){
        this.setSize((int) getWidth(),height);
    }

    public void moveByCenter(AffineTransform at){
        at.translate(-getWidth()/2,-getHeight()/2);
    }

}
