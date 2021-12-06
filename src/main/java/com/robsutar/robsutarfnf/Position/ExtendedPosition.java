package com.robsutar.robsutarfnf.Position;

import com.robsutar.robsutarfnf.Vector2D;

public class ExtendedPosition extends Position {
    protected double scale=1,rotation=0;
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

    @Override
    public void multiplyPos(Vector2D v2d){
        this.x*=v2d.getX();this.y*=v2d.getY();this.scale*=v2d.getScale();this.rotation*=v2d.getRotation();
    }

    public double getScale() {
        return scale;
    }

    public double getRotation() {
        return rotation;
    }
}
