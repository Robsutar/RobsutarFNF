package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.Animation;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public class Box extends Rectangle {
    private double scale = 1,rotation;
    private float opacity = 1f;

    public Animation animation = new Animation(this);

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
    public void setOpacity(float opacity) {
        this.opacity=opacity;
        if (this.opacity<0f){
            this.opacity=0f;
        } else if (this.opacity>1f){
            this.opacity=1f;
        }
    }
    public float getOpacity(){
        return this.opacity;
    }

    @Override
    public double getCenterX() {return x-getWidth()/2.0;}
    @Override
    public double getCenterY() {
        return y-getHeight()/2.0;
    }
}
