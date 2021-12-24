package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

import java.awt.*;

public interface Renderable {
    default void spawnRender(){
        Main.handler.addObject(this);
    }
    default void killRender(){
        Main.handler.removeObject(this);
    }

    default int  getPriority(){
        return PriorityTypes.RANDOM_OBJECT;
    }

    default void renderer(Graphics2D g2d){

    }
}
