package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.ExtendedPosition;
import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Vector2d;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RenderableObject extends Box implements Renderable, Ticable {

    private byte priority=3;

    protected BufferedImage actualImage;
    protected AffineTransform actualTransform = new AffineTransform();
    private ExtendedPosition actualPosEp = new ExtendedPosition();

    private Vector2d vector = new Vector2d();

    public RenderableObject(int x, int y,BufferedImage img){
        setActualImage(img,true);
        setLocation(x,y);
    }

    public void spawn(){
        spawnTick();
        spawnRender();
    }

    public void setActualImage(BufferedImage actualImage) {
        this.actualImage = actualImage;
    }
    public void setActualImage(BufferedImage actualImage,boolean setBounds) {
        this.actualImage = actualImage;
        if (setBounds&&actualImage!=null){
            this.width=actualImage.getWidth();
            this.height=actualImage.getHeight();
        }
    }
    public void setActualTransform(AffineTransform actualTransform) {
        this.actualTransform = actualTransform;
    }
    public void setActualPosEP(ExtendedPosition extendedPosition) {
        this.actualPosEp=extendedPosition;
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
        setLocation((int)(getX()+vector.getX()),(int)(getY()+vector.getY()));
        onTick();
    }
    @Override
    public void renderer(Graphics2D g2d,byte priority) {
        if (this.priority==priority) {
            onRenderer(g2d);
        }
    }


    protected void onTick(){

    }

    protected void onRenderer(Graphics2D g2d){
        if(actualImage != null) {
            AffineTransform at = new AffineTransform(actualTransform);
            at.translate(getSimX(),getSimY());
            moveByCenter(at);
            double scale = getScale();
            double rotation = getRotation();
            scale *= actualPosEp.getScale();
            rotation += actualPosEp.getRotation();
            at.translate(actualPosEp.getX(), actualPosEp.getY());
            at.translate(getWidth() / 2.0, getHeight() / 2.0);
            at.scale(scale, scale);
            at.translate(-getWidth() / 2.0, -getHeight() / 2.0);
            at.rotate(Math.toRadians(rotation), getWidth() / 2.0, getHeight() / 2.0);
            g2d.drawImage(actualImage, at, null);
        }
    }
}
