package com.robsutar.robsutarfnf.AbstractObjects;

public abstract class Position extends Renderable{
    protected int x,y;
    protected double xVelocity,yVelocity;
    public int getX(){return x;} public int getY(){return y;}

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setPosition(int x, int y){
        this.x=x;this.y=y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void tick(){
        System.out.println("Ticadinho baitolãp kaskask");
        setPosition((int)(getX()+getxVelocity()),(int)(getY()+getyVelocity()));
    }
}
