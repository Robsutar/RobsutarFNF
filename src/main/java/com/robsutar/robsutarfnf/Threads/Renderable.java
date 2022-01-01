package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface Renderable extends FullSpawn{
    default void spawnRenderable(){
        Handler.addObject(this);
    }
    default void killRenderable(){
        Handler.removeObject(this);
    }
}
