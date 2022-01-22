package com.robsutar.robsutarfnf.Engine;

import java.awt.*;

public class ExtendedRectangle extends Rectangle {
    protected double rotation;
    protected double scale = 1;
    protected float opacity = 1f;

    public double getRotation() {
        return rotation;
    }

    public float getOpacity() {
        return opacity;
    }

    public double getScale() {
        return scale;
    }

    public double getScaledWidth(){return this.width*this.scale;}
    public double getScaledHeight(){return this.height*this.scale;}

    public double getScaledX(){return this.x*this.scale;}
    public double getScaledY(){return this.y*this.scale;}

    public void setDimension(Dimension dimension){
        this.setWidth(dimension.width);setHeight(dimension.height);
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public void setX(int x){this.x=x;}

    public void setY(int y){this.y=y;}


    public void setBounds(int width, int height){
        setWidth(width);setHeight(height);
    }

    public void setWidth(int width){
        this.width=width;
    }
    public void setHeight(int height){
        this.height=height;
    }
}
