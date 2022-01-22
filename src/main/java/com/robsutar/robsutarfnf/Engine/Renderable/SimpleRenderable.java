package com.robsutar.robsutarfnf.Engine.Renderable;

import com.robsutar.robsutarfnf.Engine.Box;
import com.robsutar.robsutarfnf.Engine.Threads.Renderable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class SimpleRenderable extends Box implements Renderable {
    protected BufferedImage image;
    public SimpleRenderable(){
    }

    public SimpleRenderable(Anchor anchor){
        this.anchor=anchor;
    }

    public void setImage(BufferedImage image, boolean bounds){
        this.image = image;
        if (bounds){
            setDimension(new Dimension(image.getWidth(), image.getHeight()));
        }
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

    public void renderAnchor(Graphics2D g2d){
        g2d.translate(anchor.getX(), anchor.getY());
    }

    public void renderDrawImage(Graphics2D g2d){
        if (image!=null){
            g2d.drawImage(image,0,0,null);
        }
    }

    protected void subordinatesRender(Graphics2D g2d){
        for (Box o:subordinatedObjects){
            if (o instanceof Renderable) {
                ((Renderable) o).render(g2d);
            }
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        renderOpacity(g2d);
        renderAnchor(g2d);
        renderTranslateXY(g2d);
        renderTranslateMiddle(g2d);
        renderRotate(g2d);
        renderScale(g2d);
        renderDrawImage(g2d);
        subordinatesRender(g2d);
        AffineTransform at = g2d.getTransform();
        absolutePosition = new Point((int)at.getTranslateX(),(int)at.getTranslateY());
    }
}
