package com.robsutar.robsutarfnf.Interfaces;

import com.robsutar.robsutarfnf.Main;
import java.awt.event.MouseEvent;

import static com.robsutar.robsutarfnf.Main.getxMouse;
import static com.robsutar.robsutarfnf.Main.getyMouse;

public interface MouseInteractive  {
    default void mouseISpawn(){
        Main.mainHandler.addObject(this);
    }
    default void mouseIKill(){
        Main.mainHandler.removeObject(this);
    }

    default boolean isInto(int x, int y, double width, double height){
        return getxMouse() >= x && getxMouse() <= width+ x && getyMouse() >=  y && getyMouse() <= height+  y;
    }
    default void mousePressed(){
    }
    default void mouseReleased(){
    }
}
