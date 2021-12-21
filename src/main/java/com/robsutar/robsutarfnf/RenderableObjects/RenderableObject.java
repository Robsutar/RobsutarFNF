package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.ExtendedPosition;
import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Vector2d;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RenderableObject extends SimpleRenderable implements Ticable {
    protected BufferedImage actualImage;
    protected AffineTransform actualTransform = new AffineTransform();
    private ExtendedPosition actualPosEp = new ExtendedPosition();
    public Vector2d vector = new Vector2d();

    public RenderableObject(int x, int y,BufferedImage img){
        setActualImage(img,true);
        setLocation(x,y);
    }

    @Override
    public void spawn(){
        super.spawn();
        spawnTick();
    }
    @Override
    public void kill(){
        super.kill();
        killTick();
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



    @Override
    public void tick() {
        setLocation((int)(getX()+vector.getX()),(int)(getY()+vector.getY()));
        setOpacity(getOpacity()+vector.getOpacity());
        setScale(getScale()+vector.getScale());
        onTick();
    }
    @Override
    public void renderer(Graphics2D g2d) {
        super.renderer(g2d);
        onRenderer(g2d);
    }


    protected void onTick(){

    }

    @Override
    public void rendererScale(Graphics2D g2d) {
        double scale = getScale();
        scale *= actualPosEp.getScale();
        g2d.translate(getScaledWidth()/2.0,getScaledHeight()/2.0);
        g2d.scale(scale,scale);
        g2d.translate(-getScaledWidth()/2.0,-getScaledHeight()/2.0);
    }

    @Override
    public void rendererRotate(Graphics2D g2d) {
        double rotation = getRotation();
        rotation += actualPosEp.getRotation();
        g2d.rotate(Math.toRadians(rotation),getWidth()/2.0,getHeight()/2.0);
    }

    protected void onRenderer(Graphics2D g2d){
        AffineTransform at = new AffineTransform(actualTransform);
        at.translate(getVisualX(),getVisualY());
        //at.translate(actualPosEp.getX(), actualPosEp.getY());
        if(actualImage != null) {
            g2d.drawImage(actualImage, at, null);
        }
    }
}
