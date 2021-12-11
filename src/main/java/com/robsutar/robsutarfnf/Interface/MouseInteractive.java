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
}
