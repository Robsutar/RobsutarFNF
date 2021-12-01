package com.robsutar.robsutarfnf.RenderableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RenderableObject implements Renderable{
    protected int x=0,y=0;
    protected double width,height;

    protected BufferedImage actualImage;
    protected AffineTransform actualTransform;

    public RenderableObject(int x,int y){
        this.x=x;this.y=y;
    }

    @Override
    public void renderer(Graphics2D g2d) {
        if (actualImage!=null&&actualTransform!=null) {
            g2d.drawImage(actualImage, actualTransform, null);
        }
    }
}
