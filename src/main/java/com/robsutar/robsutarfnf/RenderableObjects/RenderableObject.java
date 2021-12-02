package com.robsutar.robsutarfnf.RenderableObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class RenderableObject extends Position implements Renderable {
    protected int originalWidth,originalHeight;
    protected int width,height;
    private double scale=1;

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

    public void setScale(double scale) {
        this.scale = scale;
        this.width= (int) (originalWidth*scale);
        this.height= (int) (originalHeight*scale);
    }

    @Override
    public void renderer(Graphics2D g2d) {
        if (actualImage!=null&&actualTransform!=null) {
            AffineTransform at = new AffineTransform(actualTransform);
            at.translate(x-width/2,y-height/2);
            at.scale(scale,scale);
            g2d.drawImage(actualImage, at, null);
        }
    }
}
