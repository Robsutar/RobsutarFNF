package com.robsutar.robsutarfnf.Engine.Threads;

import com.robsutar.robsutarfnf.Engine.Handler;

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
