package com.robsutar.robsutarfnf.GameObjects;

import com.robsutar.robsutarfnf.Box;
import com.robsutar.robsutarfnf.Threads.Renderable;
import com.robsutar.robsutarfnf.Window.Anchor.Anchor;

import java.awt.*;

public abstract class SimpleRenderable extends Box implements Renderable {
    public SimpleRenderable(){
    }

    public SimpleRenderable(Anchor anchor){
        this.anchor=anchor;
    }

    protected void renderOpacity(Graphics2D g2d){
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getValidOpacity()));
    }

    private void renderRotate(Graphics2D g2d){
        g2d.rotate(Math.toRadians(getRotation()),getWidth()/2,getHeight()/2);
    }

    public void renderScale(Graphics2D g2d){
        g2d.translate(getWidth()/2,getHeight()/2);
        g2d.scale(getValidScale(),getValidScale());
        g2d.translate(-getWidth()/2,-getHeight()/2);
    }

    public void renderTranslateMiddle(Graphics2D g2d){
        g2d.translate(-getWidth()/2,-getHeight()/2);
    }

    public void renderTranslateXY(Graphics2D g2d){
        g2d.translate(x,y);
    }

    public void renderAnchor(Graphics2D g2d){g2d.translate(anchor.getX(), anchor.getY());}

    @Override
    public void render(Graphics2D g2d) {
        renderOpacity(g2d);
        renderAnchor(g2d);
        renderTranslateXY(g2d);
        renderTranslateMiddle(g2d);
        renderRotate(g2d);
        renderScale(g2d);
    }
}
