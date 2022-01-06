package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

import java.awt.event.MouseEvent;

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
}
