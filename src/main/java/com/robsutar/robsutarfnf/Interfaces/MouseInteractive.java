package com.robsutar.robsutarfnf.Interfaces;

import com.robsutar.robsutarfnf.Main;

import java.awt.event.MouseEvent;

import static com.robsutar.robsutarfnf.Main.getxMouse;
import static com.robsutar.robsutarfnf.Main.getyMouse;

public interface MouseInteractive {
    default void mouseISpawn(){
        Main.mainHandler.addObject(this);
    }
    default void mouseIKill(){
        Main.mainHandler.removeObject(this);
    }

    default boolean isInto(int x, int y, double width, double height){
        double xS = x-width/2.0;
        double yS = y-height/2.0;
        return getxMouse() >= xS && getxMouse() <= width+xS && getyMouse() >= yS && getyMouse() <= height+yS;
    }
    default void mousePressed(MouseEvent e){
    }
    default void mouseReleased(MouseEvent e){
    }
}
