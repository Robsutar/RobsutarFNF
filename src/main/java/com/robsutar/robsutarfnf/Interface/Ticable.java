package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public interface Ticable {
    default void spawnTick(){
        Main.handler.addObject(this);
    }
    default void killTick(){
        Main.handler.removeObject(this);
    }
    default void tick(){

    }
}
