package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface Ticable extends FullSpawn{
    default void spawnTick(){
        Handler.addObject(this);
    }
}
