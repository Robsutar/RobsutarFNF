package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class RenderableObject extends Position{
    private int age;
    private int ageLimit=2134567893;
    private int animIndex=0;
    private int width=0,height=0;

    private double scale=0;

    private boolean immortal=false;

    private boolean alive=true;
    private boolean isAnimated=false;
    private byte state = 0;

    private BufferedImage image;

    private AnimatedObject animatedObject;

    public RenderableObject(PositionType positionType,boolean immortal, BufferedImage img){
        this.immortal=immortal;
        setImage(img);
        move(positionType);
    }

    public RenderableObject(PositionType positionType,boolean immortal, AnimatedObject animatedObject){
        this.immortal=immortal;
        setImage(animatedObject);
        move(positionType);
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image){
        this.image= image;
    }

    public void setImage(AnimatedObject animatedObject){
        this.animatedObject= animatedObject;
        this.isAnimated=true;
        this.image = animatedObject.getAnimatedImages().get(0).get(0);
    }

    public void setScale(double scale){
        this.scale=scale;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setState(int stateNumber){
        int anmObjectStateL = animatedObject.getAffineTransforms().toArray().length;
        this.state= (byte) (stateNumber-(anmObjectStateL*(stateNumber/anmObjectStateL)));
    }

    protected void setAnimIndex(int animIndex){
        int anmObjectStateL = animatedObject.getAffineTransforms().get(state).toArray().length;
        this.animIndex= animIndex-(anmObjectStateL*(animIndex/anmObjectStateL));}

    public int getAnimIndex() {
        return animIndex;
    }

    public int getAge() {
        return age;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public double getScale() {
        return scale;
    }

    public boolean isImmortal() {
        return immortal;
    }

    public boolean isAlive() {
        return alive;
    }

    public void move(PositionType type){
        int x =0;
        int y =0;
        if (type==PositionType.MIDDLE){
            x= Main.getWindowDim().width/2-image.getWidth()/2;
            y=Main.getWindowDim().height/2-image.getHeight()/2;
        }
        setX(x);
        setY(y);
    }

    public void onTick(){
        if (immortal||age<ageLimit) {
            updatePos();
            tick();
        }
    }

    public void onRenderer(Graphics2D g2d){
        if (immortal||age<ageLimit) {
            age++;
            renderer(g2d);
        }
    }

    public void onBpm(){
        bpm();
    }

    protected void renderer(Graphics2D g2d){
        if(isAnimated){
            AffineTransform at = new AffineTransform( animatedObject.getAffineTransforms().get(state).get(animIndex));
            at.translate(getX(),getY());
            at.translate(-image.getWidth()/2.0*scale,-image.getHeight()/2.0*scale);
            at.scale(scale+1,scale+1);
            g2d.drawImage(animatedObject.getAnimatedImages().get(state).get(animIndex),at,null);
        } else {
            g2d.drawImage(image,getX(),getY(),null);
        }
    }

    protected abstract void tick();

    protected void bpm(){
        if (isAnimated){
            setAnimIndex(animIndex+1);
        }
    }
}
