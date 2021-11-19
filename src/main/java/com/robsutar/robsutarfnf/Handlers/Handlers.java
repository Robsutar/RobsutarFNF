package com.robsutar.robsutarfnf.Handlers;

import java.awt.*;
import java.util.LinkedList;

public class Handlers extends BaseHandler{
    LinkedList<BaseHandler> handlers = new LinkedList<>();

    public void addHandler(BaseHandler handler){
        this.handlers.add(handler);
    }

    public void removeHandler(BaseHandler handler){
        this.handlers.remove(handler);
    }

    public void handlersTick(){
        for (BaseHandler h: handlers
        ) {
            h.onTick();
        }
    }
    public void handlersRenderer(Graphics2D g){
        for (BaseHandler h: handlers
        ) {
            h.onRenderer(g);
        }
    }
    @Override
    public void tick() {
        handlersTick();
    }

    @Override
    public void renderer(Graphics2D g) {
        handlersRenderer(g);
    }
}
