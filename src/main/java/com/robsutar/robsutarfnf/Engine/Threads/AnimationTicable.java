package com.robsutar.robsutarfnf.Engine.Threads;

import com.robsutar.robsutarfnf.Engine.Handler;

public interface AnimationTicable extends FullSpawn{
    default void spawnAnimationTick(){Handler.addObject(this);}
    default void killAnimationTick(){
        Handler.removeObject(this);
    }

    default void animationTick(){

    }
}
