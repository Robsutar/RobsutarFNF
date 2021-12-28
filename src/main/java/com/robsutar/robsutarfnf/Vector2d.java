package com.robsutar.robsutarfnf;

import javax.swing.*;

public class Vector2d {
    private double x;
    private double y;

    private double scale;
    private float opacity;

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
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

    public double getScale() {
        return scale;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setVector(double x, double y){
        this.x=x;this.y=y;
    }
}
