package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.RenderableObjects.Box;

public class KeyFrame{
    private final int finalX, finalY;
    private final double finalScale;
    private final float finalOpacity;
    public int age = 0,tickLength;
    public KeyFrame(int tickLength,double finalScale,float finalOpacity,int finalX,int finalY ){
        this.tickLength=tickLength;this.finalX=finalX;this.finalY=finalY;
        this.finalScale=finalScale;this.finalOpacity=finalOpacity;
    }

    public boolean keyTick(Box object){
        if (age<=tickLength) {
            int x = (int) (object.getX() + (finalX / tickLength * 1.0));
            int y = (int) (object.getY() + (finalY / tickLength * 1.0));
            double scale = object.getScale() + (finalScale / tickLength);
            float opacity = object.getOpacity() + (finalOpacity / tickLength);
            System.out.println(scale);
            object.setLocation(x, y);
            object.setScale(scale);
            object.setOpacity(opacity);
            age++;
            return true;
        } return false;
    }

    public void reset() {
        age=0;
    }

    public KeyFrame reverse(){
        return new KeyFrame(tickLength,-finalScale,-finalOpacity,-finalX,-finalY);
    }
}
