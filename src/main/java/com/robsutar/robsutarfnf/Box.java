package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Graphics.Camera;
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

    public double getScaledX(){return this.x*this.scale;}
    public double getScaledY(){return this.y*this.scale;}

    public void setDimension(Dimension dimension){
        this.setWidth(dimension.width);setHeight(dimension.height);
    }

    public Point getScaledPoint(Point point){
        Point dim = new Point(point);

        int xDist = width/2-dim.x;
        int yDist = height/2-dim.y;

        xDist/=getScale();
        yDist/=getScale();

        dim.x+=xDist* (getScale()-1);
        dim.y+=yDist* (getScale()-1);
        return dim;
    }

    public Point getAbsolutePosition(){
        return new Point((int)(x-getScaledWidth()/2),(int)(y-getScaledHeight()/2));
    }

    public boolean isInto(Point point){
        Point absolutePos = getAbsolutePosition();
        if (point.x>=absolutePos.x&&point.x<=getScaledWidth()+getAbsolutePosition().x){
            if (point.y>=absolutePos.y&&point.y<=getScaledHeight()+getAbsolutePosition().y){
                return true;
            }
        }
        return false;
    }
}
