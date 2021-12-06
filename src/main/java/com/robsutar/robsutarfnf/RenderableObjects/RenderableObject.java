package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Interfaces.BpmTicable;
import com.robsutar.robsutarfnf.Interfaces.Renderable;
import com.robsutar.robsutarfnf.Interfaces.Ticable;
import com.robsutar.robsutarfnf.Position.Box;
import com.robsutar.robsutarfnf.Position.ExtendedPosition;
import com.robsutar.robsutarfnf.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RenderableObject extends Box implements Renderable, Ticable {
    protected Vector2D vector = new Vector2D(0,0,0.2);
    protected ExtendedPosition actualPosED = new ExtendedPosition();
    protected AffineTransform actualTransform = new AffineTransform();
    protected BufferedImage actualImage;
    public RenderableObject(int x, int y) {
        super(x, y);
        ticableSpawn();
        renderSpawn();
    }

    public void setActualPosEP(ExtendedPosition actualTransform) {
        this.actualPosED = actualTransform;
    }
    public void setActualImage(BufferedImage actualImage) {
        this.actualImage = actualImage;
    }
    public void setActualTransform(AffineTransform actualTransform) {
        this.actualTransform = actualTransform;
    }

    public void setVector(double xSpeed, double ySpeed, double scaleSpeed, double rotationSpeed){
        vector.setVectorSpeed(xSpeed,ySpeed,scaleSpeed,rotationSpeed);
    }
    @Override
    public void tick() {
        vector.update();
        multiplyPos(vector);
    }

    @Override
    public int getWidth() {
        if (!(width >0)){
            width=actualImage.getWidth();
        }
        return super.getWidth();
    }

    @Override
    public double getScale() {
        return super.getScale();
    }

    @Override
    public int getHeight() {
        if (!(height >0)){
            if (actualImage!=null) {
                height = actualImage.getHeight();
            }
        }
        return super.getHeight();
    }

    @Override
    public void render(Graphics2D g2d) {
        if (actualImage!=null&&actualTransform!=null) {
            AffineTransform at = new AffineTransform(actualTransform);
            double scale = getScale();
            double rotation = getRotation();
            scale*= actualPosED.getScale();
            rotation+= actualPosED.getRotation();
            at.translate(actualPosED.getX(), actualPosED.getY());
            at.translate(getX(),getY());
            at.translate(getWidth()/2.0,getHeight()/2.0);
            at.scale(scale,scale);
            at.translate(-getWidth()/2.0,-getHeight()/2.0);
            at.rotate(Math.toRadians(rotation),getWidth()/2.0,getHeight()/2.0);
            g2d.drawImage(actualImage,at,null);
        }
    }
}
