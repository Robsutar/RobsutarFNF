package com.robsutar.robsutarfnf.Position;

import com.robsutar.robsutarfnf.Vector2D;

public class Position {
    protected int x = 0,y=0;

    public Position(){

    }
    public  Position(int x , int y){
        this.x=x;this.y=y;
    }

    public void multiplyPos(Vector2D v2d){
        this.x*=v2d.getX();this.y*=v2d.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
