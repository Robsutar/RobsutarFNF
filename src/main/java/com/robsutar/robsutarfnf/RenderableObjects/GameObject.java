package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Vector2d;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class GameObject extends SimpleRenderable implements Renderable, Ticable {
    protected BufferedImage image;
    public double maxScale=8;
    public double minScale=-8;

    public Vector2d vector= new Vector2d();

    public GameObject(int x, int y){
        setLocation(x,y);
    }

    public void setImage(BufferedImage image,boolean setBounds) {
        this.image = image;
        if (setBounds){
            width = image.getWidth();height=image.getHeight();
        }
    }

    public void rendererDrawImage(Graphics2D g2d){
        if (image!=null){
            AffineTransform at = new AffineTransform();
            at.translate(getCenterX(),getCenterY());
            g2d.drawImage(image,at,null);
        }
    }

    public void addVector () {
        setLocation((int) (getX() + vector.getX()), (int) (getY() + vector.getY()));
        setOpacity(getOpacity() + vector.getOpacity());

        double addVc = getScale() + vector.getScale();
        if(addVc > maxScale|| addVc < minScale) {
            if (addVc >maxScale) {
                setScale(maxScale);
            } else {
                setScale(minScale);
            }
        } else {
            setScale(getScale()+vector.getScale());
        }
    }

    @Override
    public void tick() {
        addVector();
    }

    @Override
    public void renderer(Graphics2D g2d) {
        super.renderer(g2d);
        rendererDrawImage(g2d);
    }

    public void spawn(){
        spawnTick();
        spawnRender();
    }
}
