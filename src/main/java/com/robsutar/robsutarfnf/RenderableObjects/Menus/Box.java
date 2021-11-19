package com.robsutar.robsutarfnf.RenderableObjects.Menus;


import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Box extends RenderableObject {
    private int width=0,height=0;

    private BufferedImage image;

    private boolean wasClicked=false;

    public Box(int x, int y, int width, int height){
        setX(x);setY(y);setWidth(width);setHeight(height);
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

    @Override
    protected void renderer(Graphics2D g2d) {
        if (isMouseAbove()){
            g2d.setColor(Color.cyan);
            g2d.drawImage(image,getX(),getY(),null);
        } else{
            g2d.setColor(Color.yellow);
        }
        g2d.fillRect(getX(),getY(),getWidth()/2,getHeight()/2);
        g2d.drawString((Main.getxMouse()+"  "+Main.getyMouse()),Main.getxMouse(),Main.getyMouse());
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
