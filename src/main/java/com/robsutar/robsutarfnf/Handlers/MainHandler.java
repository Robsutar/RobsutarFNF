package com.robsutar.robsutarfnf.Handlers;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainHandler{
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler){
        handlers.add(handler);
    }

    public void removeHandler(Handler handler){
        handlers.remove(handler);
    }

    public void render(Graphics2D g2d){
        for (Handler h:handlers
             ) {
            h.render(g2d);
        }
    }

    public void tick() {
        for (Handler h:handlers
        ) {
            h.tick();
        }
    }

    public void bpmTick() {
        for (Handler h:handlers
        ) {
            h.bpmTick();
        }
    }

    public void mousePressed(MouseEvent e ){
        for (Handler h:handlers
        ) {
            h.onMousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e ){
        for (Handler h:handlers
        ) {
            h.onMouseReleased(e);
        }
    }
}
