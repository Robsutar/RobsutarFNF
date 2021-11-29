package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedObject extends RenderableObject {

    ArrayList<ArrayList<BufferedImage>> animatedImages = new ArrayList<ArrayList<BufferedImage>>();

    ArrayList<ArrayList<AffineTransform>> affineTransforms = new ArrayList<ArrayList<AffineTransform>>();

    private int width=0,height=0,animationIndex=0,imageIndex=0;

    private double scale = 1;

    private boolean animating = true;

    public AnimatedObject(int x, int y, AtlasConfig atlasXml) {
        super(x,y);

        AtlasConfig atlas = atlasXml;

        BufferedImage img = ImageManager.loadImage(Assets.AssetsXml.packFolder+atlas.getImagePath());

        ArrayList<ArrayList<String>> animationsName = new ArrayList<ArrayList<String>>();

        for (int i = 0;i < atlas.getName().toArray().length;i++){
            String name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);

            ArrayList<String> innerAnimationsName = new ArrayList<String>();
            ArrayList<BufferedImage> innerImages = new ArrayList<BufferedImage>();
            ArrayList<AffineTransform> innerAfineTransforms = new ArrayList<>();

            while (atlas.getName(i).contains(name)){
                name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);
                innerAnimationsName.add(atlas.getName(i));

                BufferedImage tempI = ImageManager.cropImage(img, atlas.getX(i),atlas.getY(i),atlas.getWidth(i),atlas.getHeight(i));
                innerImages.add(tempI);

                width += tempI.getWidth();height+= tempI.getHeight();

                AffineTransform tempT = new AffineTransform();
                tempT.translate(-atlas.getFrameX(i),-atlas.getFrameY(i));

                innerAfineTransforms.add(tempT);

                i+=1;
            }
            i-=1;
            animationsName.add(innerAnimationsName);
            animatedImages.add(innerImages);
            affineTransforms.add(innerAfineTransforms);
        }
        width /= atlas.getName().toArray().length;
        height /= atlas.getName().toArray().length;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void setIndex(int index){
        if (animatedImages.toArray().length-1<=index) {
            this.animationIndex = index;
        } else this.animationIndex=0;
    }

    public void setImageIndex(int index){
        if (index<animatedImages.get(animationIndex).toArray().length) {
            this.imageIndex = index;
        } else {
            this.imageIndex = 0;
        }
    }

    public void stopAnimation(){
        this.animating=false;
    }
    public  void startAnimation(){
        this.animating=true;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public BufferedImage getActualImage(){
        return animatedImages.get(animationIndex).get(imageIndex);
    }

    public AffineTransform getActualTransform(){
        AffineTransform at = new AffineTransform(affineTransforms.get(animationIndex).get(imageIndex));
        at.translate(getX()-(getWidth()/2.0)*scale,getY()-(getHeight()/2.0)*scale);
        at.scale(scale,scale);
        return at;
    }

    @Override
    protected void onBpmTick() {
        if(animating) {
            setImageIndex(imageIndex + 1);
        }
    }
    @Override
    protected void onRenderer(Graphics2D g2d) {
        g2d.drawImage(getActualImage(),getActualTransform(),null);
    }
}
