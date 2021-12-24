package com.robsutar.robsutarfnf.Graphics;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimationFrames {

    private final List<BufferedImage> images;
    private final List<Integer> frameX;
    private final List<Integer> frameY;

    private final int width,height;

    private final String animationName;

    public AnimationFrames(List<BufferedImage> images,List<Integer> frameX,List<Integer> frameY,int maxWidth,int maxHeight,String animationName){
        this.images=images;this.frameX=frameX;this.frameY=frameY;this.animationName=animationName;this.width=maxWidth;this.height=maxHeight;
    }

    public void rotate(int length){
        Collections.rotate(images,length);
        Collections.rotate(frameX,length);
        Collections.rotate(frameY,length);
    }

    public BufferedImage getActualImage(){
        return images.get(0);
    }

    public AffineTransform getActualFrame(){
        AffineTransform at = new AffineTransform();
        at.translate(-frameX.get(0),-frameY.get(0));
        return at;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getAnimationName(){return this.animationName;}
}
