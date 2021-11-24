package com.robsutar.robsutarfnf.RenderableObjects.Menus;


import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Box extends RenderableObject {

    private boolean wasClicked=false;

    public Box(PositionType positionType, BufferedImage img){
        super(positionType,true,img);
        setWidth(img.getWidth());setHeight(img.getHeight());
    }

    public Box(PositionType positionType, AnimatedObject animatedObject){
        super(positionType,true,animatedObject);
        setWidth(animatedObject.getWidth());setHeight(animatedObject.getHeight());
    }

    public boolean isInto(){
        int x= Main.getxMouse(), y = Main.getyMouse();
        return x >= getX() && x <= getWidth()+getX() && y >= getY() && y <= getHeight()+getY();
    }

    public boolean isMouseAbove(){
        return isInto();
    }

    public void onPressed(MouseEvent e){
        if (isInto()) {
            pressed(e);
            wasClicked=true;
        }
    }

    public void pressed(MouseEvent e){
        System.out.println("no CLICKED action for this button");
    }

    public void onReleased(MouseEvent e){
        if (wasClicked) {
            wasClicked=false;
            released(e);
        }
    }

    public  void released(MouseEvent e){
        System.out.println("no RELEASED action for this button");
    }
}
