package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Interfaces.BpmTicable;
import com.robsutar.robsutarfnf.RenderableObjects.Position;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedObject extends RenderableObject implements BpmTicable {

    private ArrayList<ArrayList<BufferedImage>> animatedImages = new ArrayList<ArrayList<BufferedImage>>();

    private List<Stream> streams = new ArrayList<>();

    private int animationIndex=0,imageIndex=0;
    private boolean animating = true;

    public AnimatedObject(Position pos, AtlasConfig atlasXml) {
        super(pos);

        AtlasConfig atlas = atlasXml;

        BufferedImage img = ImageManager.loadImage(Assets.AssetsXml.packFolder+atlas.getImagePath());

        ArrayList<ArrayList<String>> animationsName = new ArrayList<ArrayList<String>>();

        for (int i = 0;i < atlas.getName().toArray().length;i++){
            String name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);

            ArrayList<String> innerAnimationsName = new ArrayList<String>();
            ArrayList<BufferedImage> innerImages = new ArrayList<BufferedImage>();

            streams.add(new Stream());

            while (atlas.getName(i).contains(name)){
                name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);
                innerAnimationsName.add(atlas.getName(i));

                BufferedImage tempI = ImageManager.cropImage(img, atlas.getX(i),atlas.getY(i),atlas.getWidth(i),atlas.getHeight(i));
                tempI =  ImageManager.moveImage(tempI,-atlas.getFrameX(i),-atlas.getFrameY(i));
                innerImages.add(tempI);

                setWidth(getOriginalWidth()+tempI.getWidth());
                setHeight(getOriginalHeight()+tempI.getHeight());

                i+=1;
            }
            i-=1;
            animationsName.add(innerAnimationsName);
            animatedImages.add(innerImages);
        }
        setWidth(getOriginalWidth()/atlas.getName().toArray().length);
        setHeight(getOriginalHeight()/atlas.getName().toArray().length);
    }

    public void setIndex(int index){
        if (animatedImages.toArray().length-1<=index) {
            this.animationIndex = 0;
        } else this.animationIndex=index;
    }
    public void setImageIndex(int index){
        if (animatedImages.get(animationIndex).toArray().length-1<=index) {
            this.imageIndex = 0;
        } else {
            this.imageIndex = index;
        }
    }

    @Override
    public void bpmTick() {
        if (animating){
            setImageIndex(imageIndex+1);
            setActualImage(animatedImages.get(animationIndex).get(imageIndex));
        }
    }
}
