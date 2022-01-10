package com.robsutar.robsutarfnf.Engine.Window.Anchor;

import com.robsutar.robsutarfnf.Engine.Box;

public class AnchorBox extends Anchor{
    private final Box object;

    public AnchorBox(Box object){
        this.object=object;
    }
    @Override
    public int getX() {
        return object.getFullX();
    }
    @Override
    public int getY() {
        return object.getFullY();
    }
}
