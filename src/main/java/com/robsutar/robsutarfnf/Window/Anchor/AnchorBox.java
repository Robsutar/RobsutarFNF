package com.robsutar.robsutarfnf.Window.Anchor;

import com.robsutar.robsutarfnf.Box;

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
