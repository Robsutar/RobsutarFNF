package com.robsutar.robsutarfnf.Engine.Threads;

import com.robsutar.robsutarfnf.Engine.Handler;

import java.awt.*;

public interface Renderable extends FullSpawn{

    int BACKGROUND_PRIORITY = 0;
    int PLAYER_PRIORITY = 2;
    int RANDOM_OBJECT_PRIORITY = 3;
    int TEXT_BOX_PRIORITY= 14;
    int MAX_PRIORITY = 15;

    default void spawnRender(){
        Handler.addObject(this);
    }
    default void killRender(){Handler.removeObject(this);}

    default int getPriority(){
        return RANDOM_OBJECT_PRIORITY;
    }

    void render(Graphics2D g2d);

    default boolean affectedByCamera(){
        return true;
    }
}
