package com.robsutar.robsutarfnf.RenderableObjects.Menus;


import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Box extends RenderableObject {
    private int width=0,height=0;

    private BufferedImage image;
    private AnimatedObject animatedObject;

    private boolean wasClicked=false;
    private boolean isAnimated=false;

    private byte state=0;
    private int animIndex=0;

    public Box(int x, int y, int width, int height, BufferedImage img){
        setX(x);setY(y);setWidth(width);setHeight(height);setImage(img);
    }

    public Box(int x, int y, int width, int height, AnimatedObject animatedObject){
        setX(x);setY(y);setWidth(width);setHeight(height);setImage(animatedObject);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image){
        this.image= ImageManager.cropImage(image,0,0,width,height);
    }

    public void setImage(AnimatedObject animatedObject){
        this.animatedObject= animatedObject;
        this.isAnimated=true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isInto(int x,int y){
        return x >= this.getX() && x <= width && y >= this.getY() && y <= height;
    }

    public boolean isInto(){
        int x= Main.getxMouse(), y = Main.getyMouse();
        return x >= this.getX() && x <= width && y >= this.getY() && y <= height;
    }

    public boolean isMouseAbove(){
        return isInto();
    }

    public void isAnimated(Boolean bool){this.isAnimated=bool;}

    public void setState(int stateNumber){
        int anmObjectStateL = animatedObject.getAffineTransforms().toArray().length;
        this.state= (byte) (stateNumber-(anmObjectStateL*(stateNumber/anmObjectStateL)));
    }

    private void setAnimIndex(int animIndex){
        int anmObjectStateL = animatedObject.getAffineTransforms().get(state).toArray().length;
        this.animIndex= animIndex-(anmObjectStateL*(animIndex/anmObjectStateL));}

    @Override
    protected void renderer(Graphics2D g2d) {
        if(isAnimated){
            setAnimIndex(getAge());
            g2d.drawImage(animatedObject.getAnimatedImages().get(state).get(animIndex),animatedObject.getAffineTransforms().get(state).get(animIndex),null);
        } else {
            g2d.drawImage(image,getX(),getY(),null);
        }
    }

    @Override
    protected void tick() {
    }

    public void onPressed(MouseEvent e){
        if (isInto()) {
            clicked(e);
        }
    }

    public  void clicked(MouseEvent e){
        wasClicked=true;
        System.out.println("no CLICKED action for this button");
    }

    public void onReleased(MouseEvent e){
        if (wasClicked) {
            wasClicked=false;
            if (isMouseAbove()) {
                released(e);
            }
        }
    }

    public  void released(MouseEvent e){
        System.out.println("no RELEASED action for this button");
    }
}
