package com.robsutar.robsutarfnf.Engine.Interfaces;

import com.robsutar.robsutarfnf.Engine.Handler;

import java.awt.event.MouseWheelEvent;

public interface MouseInteractive extends FullSpawn{
    default void spawnMouseInteractive(){Handler.addObject(this);}
    default void killMouseInteractive(){
        Handler.removeObject(this);
    }

    default void mouseClicked() {
    }
    default void mousePressed() {
    }
    default void mouseReleased() {
    }
    default void mouseDragged(int xDistance, int yDistance){

    }
    default void mouseWheel(MouseWheelEvent e){

    }
}
