package com.robsutar.robsutarfnf.Interfaces;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public interface Renderable {
    default void renderSpawn(){
        Main.mainHandler.addObject(this);
    }
    default void renderKill(){
        Main.mainHandler.removeObject(this);
    }

    default void render(Graphics2D g2d){

    }
}
