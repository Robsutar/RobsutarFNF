package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public interface Renderable {
    default void spawnRender(){
        Main.handler.addObject(this);
    }
    default void killRender(){
        Main.handler.removeObject(this);
    }

    int getPriority();

    default void renderer(Graphics2D g2d){

    }
}
