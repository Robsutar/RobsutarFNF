package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.ExtendedPosition;
import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.MainHandler;
import com.robsutar.robsutarfnf.Vector2d;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RenderableObject extends Box implements Renderable, Ticable {

    private byte priority= (byte) (MainHandler.maxRenderPriority-1);
    private float opacity = 1;

    protected BufferedImage actualImage;
    protected AffineTransform actualTransform = new AffineTransform();
    private ExtendedPosition actualPosEp = new ExtendedPosition();
    public Vector2d vector = new Vector2d();

    public RenderableObject(int x, int y,BufferedImage img){
        setActualImage(img,true);
        setLocation(x,y);
    }

    public void spawn(){
        spawnTick();
        spawnRender();
    }
    public void kill(){
        killTick();
        killRender();
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
    public void setOpacity(float opacity) {
        if (opacity>=0&&opacity<=1) {
            this.opacity = opacity;
        }
    }

    public void setPriority(byte priority) {
        if ((priority>=0&&priority<= MainHandler.maxRenderPriority)){
            this.priority = priority;
        } else {
            this.priority = MainHandler.maxRenderPriority;
        }
    }
    public byte getPriority() {
        return priority;
    }

    public int getVisualX(){
        return (int) (x-getWidth()/2);
    }
    public int getVisualY(){
        return (int) (y-getHeight()/2);
    }
    public float getOpacity() {
        return opacity;
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
        AffineTransform at = new AffineTransform(actualTransform);
        at.translate(getVisualX(),getVisualY());
        double scale = getScale();
        double rotation = getRotation();
        scale *= actualPosEp.getScale();
        rotation += actualPosEp.getRotation();
        at.translate(actualPosEp.getX(), actualPosEp.getY());
        at.translate(getWidth() / 2.0, getHeight() / 2.0);
        at.scale(scale, scale);
        at.translate(-getWidth() / 2.0, -getHeight() / 2.0);
        at.rotate(Math.toRadians(rotation), getWidth() / 2.0, getHeight() / 2.0);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));
        if(actualImage != null) {
            g2d.drawImage(actualImage, at, null);
        }
    }
}
