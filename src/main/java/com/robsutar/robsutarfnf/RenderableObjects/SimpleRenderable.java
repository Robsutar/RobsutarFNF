package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

import java.awt.*;

public class SimpleRenderable extends Box implements Renderable {
    protected int priority= PriorityTypes.RANDOM_OBJECT;
    private float opacity = 1f;
    public boolean disappear = false;

    public void setPriority(int priority){this.priority=priority;}

    public void spawn(){
        spawnRender();
    }
    public void kill(){
        killRender();
    }

    public void setOpacity(float opacity) {
        this.opacity=opacity;
        if (this.opacity<0f){
            this.opacity=0f;
        } else if (this.opacity>1f){
            this.opacity=1f;
        }
    }
    public float getOpacity() {
        return opacity;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    public void rendererOpacity(Graphics2D g2d){
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));
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
