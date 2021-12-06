package com.robsutar.robsutarfnf;

public class Vector2D {
    private double x=0,y=0,scale=0,rotation=0,speedX=0,speedY=0,speedScale=0,speedRotation=0,resistance=0;
    public Vector2D (double x, double y,double resistance){
        this.x=x;this.y=y;
    }

    public void setVectorSpeed(double x,double y,double scale, double rotation){
        this.speedX=x;this.speedY=y;this.speedScale=scale;this.speedRotation=rotation;
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getSpeedScale() {
        return speedScale;
    }

    public double getSpeedRotation() {
        return speedRotation;
    }

    public double getX() {
        return x+1;
    }

    public double getY() {
        return y+1;
    }

    public double getScale() {
        return scale+1;
    }

    public double getRotation() {
        return rotation+1;
    }

    public void multiply(double speed){
        x *= speed;y *= speed;
    }
    public void update(){
        speedX/=(resistance+1);
        speedY/=(resistance+1);
        x *= speedX+1;y *= speedY+1;scale *= speedScale+1;rotation *= speedRotation+1;
    }
}
