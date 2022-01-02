package com.robsutar.robsutarfnf.GameObjects;

import com.robsutar.robsutarfnf.Threads.Ticable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject extends SimpleRenderable implements Ticable {
    private BufferedImage image;

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
}
