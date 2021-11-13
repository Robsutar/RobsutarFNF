package com.robsutar.robsutarfnf.AbstractObjects;

import java.awt.*;

public abstract class Renderable extends Ticable {

    public void onRenderer(Graphics2D g){
        renderer(g);
    }

    protected abstract void renderer(Graphics2D g);
}
