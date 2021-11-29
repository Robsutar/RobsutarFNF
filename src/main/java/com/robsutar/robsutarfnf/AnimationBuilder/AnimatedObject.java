package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedObject {

    ArrayList<ArrayList<BufferedImage>> animatedImages = new ArrayList<ArrayList<BufferedImage>>();

    ArrayList<ArrayList<AffineTransform>> affineTransforms = new ArrayList<ArrayList<AffineTransform>>();

    private int width=0,height=0;

    public AnimatedObject(AtlasConfig atlasXml) {

        AtlasConfig atlas = atlasXml;

        BufferedImage img = ImageManager.loadImage(Assets.AssetsXml.packFolder+atlas.imagePath);

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
}
