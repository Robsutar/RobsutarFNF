package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.AnimationBuilder.AnimationFrames;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.Interface.AnimationTicable;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedObject extends GameObject implements AnimationTicable {

    private List<AnimationFrames> images = new ArrayList<>();

    private List<Box> readjustPos;

    private int animationIndex = 0;

    private final String fullImagePath;

    public AnimatedObject(AnimatedObject animatedObject){
        super((int)animatedObject.getX(),(int)animatedObject.getY());
        this.images=animatedObject.images;this.readjustPos =animatedObject.readjustPos;this.fullImagePath= animatedObject.fullImagePath;
    }

    public AnimatedObject(int x, int y, AtlasConfig atlas) {
        super(x, y);

        BufferedImage fullImage = atlas.getImage();

        fullImagePath=atlas.getFolderPath()+atlas.getImageName();

        for (int i =0; i<atlas.getName().toArray().length;i++){
            List<BufferedImage> imgs = new ArrayList<>();
            List<Integer> fX = new ArrayList<>();
            List<Integer> fY = new ArrayList<>();
            String animationName = atlas.getName(i).substring(0, atlas.getName(i).length() - 4);

            int maxWidth = 0;
            int maxHeight = 0;

            while (atlas.getName(i).contains(animationName)){

                int frameX = atlas.getFrameX(i);
                int frameY = atlas.getFrameY(i);
                int width = atlas.getWidth(i);
                int height = atlas.getHeight(i);

                BufferedImage im = ImageManager.cropImage(fullImage,atlas.getX(i),atlas.getY(i),width,height);

                if (maxWidth<width){maxWidth=width;} if (maxHeight<height){maxHeight=height;}

                imgs.add(im);
                fX.add(frameX);
                fY.add(frameY);

                i++;
            }
            i--;
            images.add(new AnimationFrames(imgs,fX,fY,maxWidth,maxHeight,animationName));
        }

        readjustPos = atlas.getReadjustPos();

        while (readjustPos.toArray().length<images.toArray().length) {
            readjustPos.add(new Box());
        }

        updateAnimation();
    }

    @Override
    public void spawn() {
        super.spawn();
        spawnAnimationTick();
    }

    public void setAnimationIndex(int index){
        if (index<0){this.animationIndex=images.toArray().length-1;}
        else if (index>=images.toArray().length){this.animationIndex=0;}
        else{this.animationIndex=index;}
        updateAnimation();
    }

    public List<Box> getReadjustPos() {
        return readjustPos;
    }

    public String getFullImagePath() {
        return fullImagePath;
    }

    public void updateAnimation(){
        this.width=images.get(animationIndex).getWidth();
        this.height=images.get(animationIndex).getHeight();
    }

    public int getAnimationIndex(){return animationIndex;}

    @Override
    public void rendererDrawImage(Graphics2D g2d) {
        AffineTransform at = images.get(animationIndex).getActualFrame();
        g2d.drawImage(image,(int)(getCenterX()+at.getTranslateX()+readjustPos.get(animationIndex).getX()),
                (int) (getCenterY()+at.getTranslateY()+readjustPos.get(animationIndex).getY()),null);
    }

    @Override
    public void animationTick() {
        images.get(animationIndex).rotate(1);
        setImage(images.get(animationIndex).getActualImage(),false);
    }
}
