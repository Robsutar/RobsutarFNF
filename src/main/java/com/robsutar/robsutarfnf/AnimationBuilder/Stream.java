package com.robsutar.robsutarfnf.AnimationBuilder;


public class Stream{
    private int x=0,y=0;
    private double scale = 0,rotation=0;
    public Stream(){

    }

    public Stream(int x, int y, double scale,double rotation){
        this.x=x;this.y=y;this.scale=scale;this.rotation=rotation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getScale() {
        return scale;
    }

    public double getRotation() {
        return rotation;
    }
}
