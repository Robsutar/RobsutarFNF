package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

import java.awt.*;

public class SimpleRenderable extends Box implements Renderable {
    protected int priority= PriorityTypes.RANDOM_OBJECT;
    public boolean disappear = false;

    public void setPriority(int priority){this.priority=priority;}

    public void spawn(){
        spawnRender();
    }
    public void kill(){
        killRender();
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    public void rendererOpacity(Graphics2D g2d){
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getOpacity()));
    }
    public void rendererRotate(Graphics2D g2d){
        g2d.rotate(Math.toRadians(getRotation()),x,y);
    }
    public void rendererScale(Graphics2D g2d){
        g2d.translate(x,y);
        g2d.scale(getScale(),getScale());
        g2d.translate(-x,-y);
    }

    @Override
    public void renderer(Graphics2D g2d) {
        if (disappear&&getOpacity()<=0){
            kill();
        }
        rendererOpacity(g2d);
        rendererRotate(g2d);
        rendererScale(g2d);
    }
}
