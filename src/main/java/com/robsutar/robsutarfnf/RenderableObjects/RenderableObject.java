package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Vector2d;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RenderableObject extends Rectangle implements Renderable, Ticable {

    private byte priority=3;

    protected BufferedImage actualImage;
    protected AffineTransform actualTransform = new AffineTransform();

    private Vector2d vector = new Vector2d();

    public RenderableObject(int x, int y){
        setLocation(x,y);
        moveByCenter();
    }

    public void spawn(){
        spawnTick();
        spawnRender();
    }

    public void moveByCenter(){
        translate((int)(-getWidth()/2), (int) (-getHeight()/2));
    }

    public void setActualImage(BufferedImage actualImage) {
        this.actualImage = actualImage;
    }
    public void setActualImage(BufferedImage actualImage,boolean setBounds) {
        this.actualImage = actualImage;
        if (setBounds){
            this.width=actualImage.getWidth();
            this.height=actualImage.getHeight();
        }
    }
    public void setActualTransform(AffineTransform actualTransform) {
        this.actualTransform = actualTransform;
    }

    public void setPriority(byte priority) {
        if ((priority>0&&priority<4)){
            this.priority = priority;
        } else {
            this.priority = 3;
        }
    }

    @Override
    public void tick() {
        x+=vector.getX();y+=vector.getY();
    }

    @Override
    public void renderer(Graphics2D g2d,byte priority) {
        if (this.priority==priority) {
            if(actualImage != null) {
                AffineTransform at = new AffineTransform(actualTransform);
                at.translate(getX(), getY());
                g2d.drawImage(actualImage, at, null);
            }
        }
    }
}
