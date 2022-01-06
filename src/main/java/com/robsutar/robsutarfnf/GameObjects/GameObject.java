package com.robsutar.robsutarfnf.GameObjects;

import com.robsutar.robsutarfnf.Threads.Ticable;
import com.robsutar.robsutarfnf.Window.WindowPositions.Anchor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject extends SimpleRenderable implements Ticable {
    protected BufferedImage image;

    public GameObject(Anchor anchor){
        super(anchor);
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
