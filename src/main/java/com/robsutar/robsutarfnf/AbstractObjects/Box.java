package com.robsutar.robsutarfnf.AbstractObjects;

public abstract class Box extends Position{
    protected int width,height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isIntoBox(int x,int y){
        if(x>=this.x&&x<=width&&y>=this.y&&y<=height){
            return true;
        }
        return false;
    }
}
