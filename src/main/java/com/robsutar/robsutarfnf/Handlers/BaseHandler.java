package com.robsutar.robsutarfnf.Handlers;
import com.robsutar.robsutarfnf.AbstractObjects.Renderable;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseHandler extends Renderable {
    protected LinkedList<Renderable> renderableList=new LinkedList<>();
    public void addObject(Renderable r){
        renderableList.add(r);
    }

    @Override
    public void onRenderer(Graphics2D g) {
        for (Renderable r:renderableList
             ) {
            r.onRenderer(g);
        }
        renderer(g);
    }
}
