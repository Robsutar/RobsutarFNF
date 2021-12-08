package com.robsutar.robsutarfnf.Position;

import com.robsutar.robsutarfnf.Vector2D;

public class ExtendedPosition extends Position {
    protected double scale=1,rotation=0;
    protected int targetX=0,targetY=0;
    protected boolean chasingTarget = false;
    protected double speed=10;
    protected Vector2D vector = new Vector2D();

    public ExtendedPosition(){

    }

    public ExtendedPosition(int x , int y){
        super(x,y);
    }

    public ExtendedPosition (int x , int y, double scale, double rotation){
        super(x,y);
        this.scale=scale;this.rotation=rotation;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setTargetPos(int targetX, int targetY) {
        if (targetX>x-speed&&targetX<x+speed &&targetY>y-speed&&targetY<y+speed) {
            this.chasingTarget=false;
            this.vector.setX(0);
            this.vector.setY(0);
        } else {
            this.targetX = targetX;
            this.targetY = targetY;
            this.chasingTarget = true;
        }
    }

    public void updatePos(){
        if (chasingTarget) {
            double tX = targetX-x;
            double tY = targetY-y;
            double delta = Math.sqrt(Math.pow(tX,2)+Math.pow(tY,2));
            vector.setX(tX/delta*speed);
            vector.setY(tY/delta*speed);
        }
        vector.update();
        multiplyPos(vector);
    }

    public double getScale() {
        return scale;
    }

    public double getRotation() {
        return rotation;
    }

    public Vector2D getVector() {
        return vector;
    }
}
