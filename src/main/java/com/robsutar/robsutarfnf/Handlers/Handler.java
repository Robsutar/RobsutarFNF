package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class Handler {
    private List<RenderableObject> objects = new ArrayList<>();

    public void addObject(RenderableObject object){
        objects.add(object);
    }
    public void removeObject(RenderableObject object){
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

    public void onMousePressed(MouseEvent e){
        for (RenderableObject o : objects){
            o.mousePressed(e);
        }
    }
    public void onMouseReleased(MouseEvent e){
        for (RenderableObject o : objects){
            o.mouseReleased(e);
        }
    }
}
