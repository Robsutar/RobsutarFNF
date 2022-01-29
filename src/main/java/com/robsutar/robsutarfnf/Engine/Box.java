package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Movement.MovementStream;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Box extends ExtendedRectangle {

    protected Point absolutePosition = new Point();

    protected Anchor anchor = Anchor.ANCHOR_NONE;

    public MovementStream animation = new MovementStream(this);

    protected List<Box> subordinatedObjects = new ArrayList<>();


    public Point getScaledPoint(Point point){
        Point dim = new Point(point);

        int xDist = width/2-dim.x;
        int yDist = height/2-dim.y;

        xDist/=getScale();
        yDist/=getScale();

        dim.x+=xDist* (getScale()-1);
        dim.y+=yDist* (getScale()-1);
        return dim;
    }

    public Point getAbsolutePosition(){
        return absolutePosition;
    }

    public int getFullX(){return x+ anchor.getX();}

    public int getFullY(){return y+ anchor.getY();}
    public float getValidOpacity(){
        if (opacity>1f){
            return 1f;
        }
        if (opacity<0){
            return 0f;
        }
        return opacity;
    }

    public double getValidScale(){
        if (scale<0){return 0;}
        return scale;
    }

    public boolean isInto(Point point){
        if (getScale()<0.1||getOpacity()<0.1f){return false;}
        Point absolutePos = getAbsolutePosition();
        return isInto(point, absolutePos.x,absolutePos.y,(int)getScaledWidth(),(int)getScaledHeight());
    }

    public static BufferedImage scaleImage(BufferedImage originalImage, int targetWidth,int targetHeight){
        double scaleW=(double) originalImage.getWidth()/targetWidth;
        double scaleH=(double) originalImage.getHeight()/targetHeight;

        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    public static boolean isInto(Point point, int px,int py, int width,int height) {
        int x = point.x;
        int y = point.y;
        return (x>=px&&x<=width+px)&&(y >= py && y <= height + py);
    }
}
