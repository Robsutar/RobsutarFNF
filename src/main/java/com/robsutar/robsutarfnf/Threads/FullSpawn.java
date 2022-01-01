package com.robsutar.robsutarfnf.Threads;

import com.robsutar.robsutarfnf.Handler;

public interface FullSpawn {
    default void spawnAll(){
        if (this instanceof Renderable){
            Handler.addObject((Renderable) this);
        }
        if (this instanceof Ticable) {
            Handler.addObject((Ticable) this);
        }
        if (this instanceof BpmTicable) {
            Handler.addObject((BpmTicable) this);
        }
    }
    default void killAll(){
        if (this instanceof Renderable){
            Handler.removeObject((Renderable) this);
        }
        if (this instanceof Ticable) {
            Handler.removeObject((Ticable) this);
        }
        if (this instanceof BpmTicable) {
            Handler.removeObject((BpmTicable) this);
        }
    }
}
