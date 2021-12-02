package com.robsutar.robsutarfnf.Interfaces;

import com.robsutar.robsutarfnf.Main;

public interface Ticable {
    default void ticableSpawn(){
        Main.mainHandler.addObject(this);
    }
    default void ticableKill(){
        Main.mainHandler.removeObject(this);
    }

    default void tick(){

    }
}
