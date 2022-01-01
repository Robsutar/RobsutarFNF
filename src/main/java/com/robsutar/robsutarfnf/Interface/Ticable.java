package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.MainHandler;

public interface Ticable {
    default void spawnTick(){
        MainHandler.addObject(this);
    }
    default void killTick(){
        Main.handler.removeObject(this);
    }
    default void tick(){

    }
}
