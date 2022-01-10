package com.robsutar.robsutarfnf.Engine.Threads;

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
        if (this instanceof AnimationTicable) {
            AnimationTicable o = (AnimationTicable) this;o.spawnAnimationTick();
        }
        if (this instanceof MouseInteractive) {
            MouseInteractive o = (MouseInteractive) this;o.spawnMouseInteractive();
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
        if (this instanceof AnimationTicable) {
            AnimationTicable o = (AnimationTicable) this;o.killAnimationTick();
        }
        if (this instanceof MouseInteractive) {
            MouseInteractive o = (MouseInteractive) this;o.killMouseInteractive();
        }
    }
}
