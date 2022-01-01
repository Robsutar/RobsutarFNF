package com.robsutar.robsutarfnf.Graphics;

import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Box;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Camera extends Box implements Ticable, Renderable {
    public Color color = Color.white;
    public Stroke stroke = new BasicStroke(2);

    public Camera(){
        setWidth(Main.WIDTH);
        setHeight(Main.HEIGHT);
        setLocation(width/2,height/2);
    }

    @Override
    public void tick() {
        animation.tick();
        setLocation(Main.xMouse,Main.yMouse);
    }

    @Override
    public void renderer(Graphics2D g2d) {
        g2d.translate(x-width/2,y-height/2);
        g2d.setColor(color);
        g2d.setStroke(stroke);
        g2d.rotate(Math.toRadians(getRotation()),getWidth()/2,getHeight()/2);
        g2d.translate(x,y);
        g2d.scale(getScale(),getScale());
        g2d.translate(-x,-y);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getOpacity()));
    }
}
