package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;

public interface MouseInteractive {
    default void spawnMouseInteractive(){
        Main.handler.addObject(this);
    }
    default void killMouseInteractive(){
        Main.handler.removeObject(this);
    }
    default void mousePressed(){
    }

    default void mouseReleased() {
    }

    default void mouseDragged(int xDistance, int yDistance){

    }
    default boolean isInto(int x, int y, int width, int height){
        int mX = Main.xMouse;
        int mY = Main.yMouse;

        int wdt = width+x;
        int hgt = height+y;

        return mX>=x && mX <=wdt && mY>=y && mY <=hgt;
    }
}
