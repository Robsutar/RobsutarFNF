package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Frame.GameFrame;
import com.robsutar.robsutarfnf.Main;

public class Position {
    protected int x=0,y=0;

    public Position(){
    }

    public Position (Position pos){
        this.x= pos.x;this.y= pos.y;
    }

    public Position(int x, int y){
        this.x=x;this.y=y;
    }
    public Position(PositionTypes types){
        if (types==PositionTypes.CENTER){
            this.x = GameFrame.width()/2;this.y=GameFrame.height()/2;
        }
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public enum PositionTypes{
        CENTER()
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
