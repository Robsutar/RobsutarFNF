package com.robsutar.robsutarfnf.Position;

public class Box extends ExtendedPosition {
    protected int width = 0,height=0;
    public Box(int x,int y){
        super(x,y);
    }
    public Box(int x ,int y,int width, int height){
        super(x,y);
        this.width=width;this.height=height;
    }
    public Box(int x, int y, double scale, double rotation, int width, int height ){
        super(x,y,scale,rotation);
        this.width=width;this.height=height;
    }

    public void moveByCenter(int centerX, int centerY){
        x=centerX-getWidth()/2;y=centerY-getHeight()/2;
    }

    public int getByCenter(int num,int length){
         return num-length/2;
    }

    @Override
    public void setTargetPos(int targetX, int targetY) {
        super.setTargetPos(targetX-getWidth()/2, targetY-getHeight()/2);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
