package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Main;

public abstract class Position {

    public enum PositionType{
        MIDDLE(),
        BOTTOM(),
    }

    private int x=0;
    private int y=0;
    private double xVelocity=0,yVelocity=0;

    public int getX(){return x;}
    public int getY(){return y;}

    public double getxVelocity(){return xVelocity;}
    public double getyVelocity(){return yVelocity;}

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
