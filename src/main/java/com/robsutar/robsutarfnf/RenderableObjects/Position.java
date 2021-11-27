package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Main;

public abstract class Position {

    public Position(){

    }

    public Position(int x , int y, double rotation, double scale){
        this.x=x;this.y=y;this.rotation=rotation;this.scale=scale;
    }

    public enum PositionType{
        MIDDLE(),
        BOTTOM(),
    }

    private int x=0;
    private int y=0;
    private double xVelocity=0;
    private double yVelocity=0;
    private double rotation=0;

    private double scale=1;

    public int getX(){return x;}

    public int getY(){return y;}
    public double getxVelocity(){return xVelocity;}

    public double getyVelocity(){return yVelocity;}
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
    public double getScale() {
        return scale;
    }

    public double getRotation() {
        return rotation;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public  void updatePos(){
        x+=xVelocity;y+=yVelocity;
    }
}
