package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface FullSpawn {
    default void spawnAll(){
        if (this instanceof Renderable){
            Renderable o = (Renderable) this;o.spawnRender();
        }
        if (this instanceof Ticable) {
            Ticable o = (Ticable) this;o.spawnTick();
        }
        if (this instanceof BpmTicable) {
            BpmTicable o = (BpmTicable) this;o.spawnBpmTick();
        }
    }
    default void killAll(){
        if (this instanceof Renderable){
            Renderable o = (Renderable) this;o.killRender();
        }
        if (this instanceof Ticable) {
            Ticable o = (Ticable) this;o.killTick();
        }
        if (this instanceof BpmTicable) {
            BpmTicable o = (BpmTicable) this;o.killBpmTick();
        }
    }
}
