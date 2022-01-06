package com.robsutar.robsutarfnf.GameObjects;

import com.robsutar.robsutarfnf.Threads.Ticable;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class GameObject extends SimpleRenderable implements Ticable {
    protected BufferedImage image;

    public GameObject(int centerX, int centerY){
        super(centerX,centerY);
    }

    public GameObject(int centerX, int centerY, int width, int height){
        super(centerX,centerY);
        setDimension(new Dimension(width,height));
    }

    public void setImage(BufferedImage image, boolean bounds){
        this.image = image;
        if (bounds){
            setDimension(new Dimension(image.getWidth(), image.getHeight()));
        }
    }

    @Override
    public void tick() {
        animation.tick();
    }

    public void renderDrawImage(Graphics2D g2d){
        if (image!=null){
            g2d.drawImage(image,0,0,null);
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
        renderDrawImage(g2d);
    }
}
