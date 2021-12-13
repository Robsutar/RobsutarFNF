package com.robsutar.robsutarfnf;

public class ExtendedPosition {
    protected double x,y;
    protected double scale=1,rotation=0;
    protected int targetX=0,targetY=0;

    public ExtendedPosition(){

    }

    public ExtendedPosition(int x , int y){
        this.x=x;this.y=y;
    }

    public ExtendedPosition (int x , int y, double scale, double rotation){
        this.x=x;this.y=y;
        this.scale=scale;this.rotation=rotation;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getScale() {
        return scale;
    }

    public double getRotation() {
        return rotation;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}