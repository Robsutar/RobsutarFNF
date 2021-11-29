package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Handler {
    private List<RenderableObject> objects = new ArrayList<>();

    protected void addObject(RenderableObject object){
        objects.add(object);
    }

    protected void removeObject(RenderableObject object){
        objects.remove(object);
    }

    public void render(Graphics2D g2d){
        for (RenderableObject o:objects
             ) {
            o.renderer(g2d);
        }
    }

    public void tick() {
        for (RenderableObject o : objects
        ) {
            o.tick();
        }
    }

    public void bpmTick() {
        for (RenderableObject o : objects
        ) {
            o.bpmTick();
        }
    }
}
