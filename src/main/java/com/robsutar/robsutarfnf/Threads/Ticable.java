package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface Ticable extends FullSpawn{
    default void spawnTick(){
        Handler.addObject(this);
    }
    default void killTick(){Handler.removeObject(this);}

    default void tick(){

    }
}
