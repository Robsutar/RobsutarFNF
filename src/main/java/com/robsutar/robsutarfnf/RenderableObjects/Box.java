package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Main;

public interface Box {
    default boolean isInto(int x, int y, int width, int height){
        x -= width/2.0;
        y -= height/2.0;
        return Main.getxMouse() >= x && Main.getxMouse() <= width+x && Main.getyMouse() >= y && Main.getyMouse() <= height+y;
    }
}
