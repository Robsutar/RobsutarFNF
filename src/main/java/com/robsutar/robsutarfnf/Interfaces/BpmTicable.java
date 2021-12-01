package com.robsutar.robsutarfnf.Interfaces;

import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Renderable;

public interface BpmTicable {
    default void bpmSpawn(){
        Main.mainHandler.addObject(this);
    }
    default void bpmKill(){Main.mainHandler.removeObject(this);}

    default void bpmTick(){

    }
}
