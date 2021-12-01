package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.RenderableObjects.Renderable;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainHandler {
    List<Renderable> renderables = new ArrayList<>();

    public void addObject(Renderable object){
        renderables.add(object);
    }

    public void removeObject(Renderable object){
        renderables.remove(object);
    }

    public void renderer(Graphics2D g2d){
        for (Renderable r:renderables){
            r.renderer(g2d);
        }
    }
}
