package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface BpmTicable extends FullSpawn{
    default void spawnBpmTicable(){
        Handler.addObject(this);
    }
    default void killBpmTicable(){
        Handler.removeObject(this);
    }
}
