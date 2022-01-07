package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface AnimationTicable extends FullSpawn{
    default void spawnAnimationTick(){Handler.addObject(this);}
    default void killAnimationTick(){
        Handler.removeObject(this);
    }

    default void animationTick(){

    }
}
