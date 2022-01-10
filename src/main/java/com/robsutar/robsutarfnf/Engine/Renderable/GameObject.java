package com.robsutar.robsutarfnf.Engine.Renderable;

import com.robsutar.robsutarfnf.Engine.Threads.Ticable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject extends SimpleRenderable implements Ticable {
    protected int priority;

    public GameObject(Anchor anchor){
        super(anchor);
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public void tick() {
        animation.tick();
    }
}
