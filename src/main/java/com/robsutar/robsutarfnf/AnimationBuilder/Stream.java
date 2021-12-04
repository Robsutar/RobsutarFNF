package com.robsutar.robsutarfnf.AnimationBuilder;


import com.robsutar.robsutarfnf.RenderableObjects.Position;

public class Stream extends Position {
    private int x=0,y=0;
    private double scale = 0,rotation=0;
    public Stream(){

    }

    public Stream(int x, int y, double scale,double rotation){
        this.x=x;this.y=y;this.scale=scale;this.rotation=rotation;
    }
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
}
