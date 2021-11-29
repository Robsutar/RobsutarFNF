package com.robsutar.robsutarfnf.RenderableObjects;

import java.awt.*;

public abstract class RenderableObject extends Position{

    public RenderableObject(int x, int y) {
        super(x, y);
    }

    public void tick() {
        onTick();
    }
    public void renderer(Graphics2D g2d){onRenderer(g2d);}
    public void bpmTick(){onBpmTick();}

    protected abstract void onTick();
    protected abstract void onRenderer(Graphics2D g2d);
    protected abstract void onBpmTick();
}
