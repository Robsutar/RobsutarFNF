package com.robsutar.robsutarfnf.Interfaces;

import com.robsutar.robsutarfnf.Main;

public interface WASDInteractive {
    default void wasdSpawn(){
        Main.mainHandler.addObject(this);
    }
    default void wasdKill(){
        Main.mainHandler.removeObject(this);
    }

    default void wPressed(){

    }
    default void aPressed(){

    }
    default void sPressed(){

    }
    default void dPressed(){

    }
}
