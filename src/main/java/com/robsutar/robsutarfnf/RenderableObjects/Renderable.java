package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public interface Renderable{

    default void renderableSpawn(){
        Main.mainHandler.addObject(this);
    }
    default void renderableKill(){
        Main.mainHandler.removeObject(this);
    }

    default void renderer(Graphics2D g2d){

    }
}
