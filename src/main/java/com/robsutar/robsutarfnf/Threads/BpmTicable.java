package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface BpmTicable extends FullSpawn{
    default void spawnBpmTick(){Handler.addObject(this);}
    default void killBpmTick(){
        Handler.removeObject(this);
    }

    default void bpmTick(int age){

    }
}
