package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public interface Renderable {
    default void spawn(){
        Main.mainHandler.addObject(this);
    }
    default void kill(){
        Main.mainHandler.removeObject(this);
    }
    default void renderer(Graphics2D g2d){

    }
}
