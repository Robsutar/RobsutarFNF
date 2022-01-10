package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Movement.MovementStream;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.AnchorTypes;

import java.awt.*;

public class Box extends Rectangle {
    private double rotation;
    private double scale = 1;
    private float opacity = 1f;

    protected Anchor anchor = AnchorTypes.ANCHOR_NONE;

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

    public void setBounds(int width, int height){
        setWidth(width);setHeight(height);
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

    public double getValidScale(){
        if (scale<0){return 0;}
        return scale;
    }

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
        return new Point((int)(getFullX()-getScaledWidth()/2),(int)(getFullY()-getScaledHeight()/2));
    }

    public int getFullX(){return x+ anchor.getX();}
    public int getFullY(){return y+ anchor.getY();}

    public boolean isInto(Point point){
        if (getScale()<0.1||getOpacity()<0.1f){return false;}
        Point absolutePos = getAbsolutePosition();
        int x = point.x;
        int y = point.y;
        if (x>=absolutePos.x&&x<=getScaledWidth()+getAbsolutePosition().x){
            if (y>=absolutePos.y&&y<=getScaledHeight()+getAbsolutePosition().y){
                return true;
            }
        }
        return false;
    }
}
