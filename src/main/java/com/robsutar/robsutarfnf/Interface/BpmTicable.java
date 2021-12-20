package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;

public interface BpmTicable {
    default void spawnBpm(){
        Main.handler.addObject(this);
    }
    default void killBpm(){
        Main.handler.removeObject(this);
    }
    default void bpmTick(){

    }
}
