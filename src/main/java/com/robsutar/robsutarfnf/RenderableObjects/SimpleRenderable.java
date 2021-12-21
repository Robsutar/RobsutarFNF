package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Interface.Renderable;

import java.awt.*;

public class SimpleRenderable extends Box implements Renderable {
    protected int priority=0;
    private float opacity = 1f;

    public void setPriority(int priority){this.priority=priority;}

    public void spawn(){
        spawnRender();
    }
    public void kill(){
        killRender();
    }

    public void setOpacity(float opacity) {
        this.opacity=opacity;
        if (this.opacity<0f||this.opacity>1f){
            this.opacity=0f;
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
        g2d.rotate(Math.toRadians(getRotation()),getWidth()/2.0,getHeight()/2.0);
    }

    public void rendererScale(Graphics2D g2d){
        g2d.translate(getScaledWidth()/2.0,getScaledHeight()/2.0);
        g2d.scale(getScale(),getScale());
        g2d.translate(-getScaledWidth()/2.0,-getScaledHeight()/2.0);
    }

    @Override
    public void renderer(Graphics2D g2d) {
        rendererOpacity(g2d);
        rendererRotate(g2d);
        rendererScale(g2d);
    }
}
