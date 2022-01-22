package com.robsutar.robsutarfnf.Engine.Threads;

import com.robsutar.robsutarfnf.Engine.Handler;

public interface Ticable extends FullSpawn{
    default void spawnTick(){
        Handler.addObject(this);
    }
    default void killTick(){Handler.removeObject(this);}

    default void tick(){

    }
}
