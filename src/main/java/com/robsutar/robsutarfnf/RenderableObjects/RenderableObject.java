package com.robsutar.robsutarfnf.RenderableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class RenderableObject extends Position implements Renderable {
    protected double width,height;

    protected BufferedImage actualImage;
    protected AffineTransform actualTransform;

    public RenderableObject(Position position){
        super(position);
    }

    public void setActualImage(BufferedImage actualImage) {
        this.actualImage = actualImage;
    }
    public void setActualTransform(AffineTransform actualTransform) {
        this.actualTransform = actualTransform;
    }

    @Override
    public void renderer(Graphics2D g2d) {
        if (actualImage!=null&&actualTransform!=null) {
            AffineTransform at = new AffineTransform(actualTransform);
            at.translate(x-width/2,y-height/2);
            g2d.drawImage(actualImage, at, null);
        }
    }
}
