package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Movement.MovementStream;

import java.awt.*;

public class Box extends Rectangle {
    private double rotation;
    private double scale = 1;
    private float opacity = 1f;

    public MovementStream animation = new MovementStream(this);

    public Box(){

    }

    public Box(int x, int y){
        setLocation(x,y);
    }

    public double getRotation() {
        return rotation;
    }

    public float getOpacity() {
        return opacity;
    }

    public double getScale() {
        return scale;
    }

    public float getValidOpacity(){
        if (opacity>1f){
            return 1f;
        }
        if (opacity<0){
            return 0f;
        }
        return opacity;
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

    public void setWidth(int width){
        this.width=width;
    }
    public void setHeight(int height){
        this.height=height;
    }

    public double getScaledWidth(){return this.width*this.scale;}
    public double getScaledHeight(){return this.height*this.scale;}

    public void setDimension(Dimension dimension){
        this.setWidth(dimension.width);setHeight(dimension.height);
    }
}
