package com.robsutar.robsutarfnf;

import java.text.DecimalFormat;

public class Vector2D {
    private double x=0.0,y=0.0,scale=0.0,rotation=0.0,resistance=1;
    private double targetScale=0,targetRotation=0;
    public Vector2D (){
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

    public double getRotation() {
        return rotation;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setTargetScale(double targetScale) {
        this.targetScale = targetScale;
    }

    public void setTargetRotation(double targetRotation) {
        this.targetRotation = targetRotation;
    }

    public void update(){
        if (x!=0) {x = update(x);}
        if (y!=0) {y = update(y);}
        scale = update(scale,targetScale,2);
        rotation = update(rotation,targetRotation,18);
        /*
        System.out.println("X : "+x+" Y : "+y);
        System.out.println("Scale : "+scale+" Rotation : "+rotation);
        System.out.println("Target Scale : "+targetScale+" Target Rotation : "+targetRotation);

         */
    }
    private double update (double sr, double target, double speed){
        if (sr>target){
            sr-=((target*resistance)+resistance)*(resistance*speed);
            if (sr<target){
                sr=target;
            }
        } else if (sr<target){
            sr +=((target*resistance)+resistance)*(resistance*speed);
            if (sr>target){
                sr=target;
            }
        }
        return sr;
    }

    private double update(double xy) {
        if (xy<0) {
            xy += resistance;
            if (xy>0){
                xy=0;
            }
        } else if (xy>0){
            xy-= resistance;
            if (xy<0){
                xy=0;
            }
        }
        return xy;
    }
}
