package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public interface AnimationTicable {
    default void spawnAnimationTick(){
        Main.handler.addObject(this);
    }
    default void killAnimationTick(){
        Main.handler.removeObject(this);
    }
    default void animationTick(){

    }
}
