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

    public double getSimX(){
        double multiplier =(double) Main.WIDTH/Main.simulatedWIDTH;
        return (x*multiplier);
    }
    public double getSimY(){
        double multiplier =(double) Main.HEIGHT/Main.simulatedHEIGHT;
        return (y*multiplier);
    }

    public void moveByCenter(AffineTransform at){
        at.translate(-getWidth()/2,-getHeight()/2);
    }

}
