package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedObject {
    List<BufferedImage> up = new ArrayList<>();
    List<BufferedImage> left = new ArrayList<>();
    List<BufferedImage> down = new ArrayList<>();
    List<BufferedImage> right = new ArrayList<>();

    public List<BufferedImage> getUp() {
        return up;
    }

    public List<BufferedImage> getLeft() {
        return left;
    }

    public List<BufferedImage> getDown() {
        return down;
    }

    public List<BufferedImage> getRight() {
        return right;
    }

    public BufferedImage getUp(int index) {return up.get(index);}
    public BufferedImage geLeft(int index) {
        return left.get(index);
    }
    public BufferedImage getDown(int index) {
        return down.get(index);
    }
    public BufferedImage getRight(int index) {
        return right.get(index);
    }

    public ArrayList<ArrayList<BufferedImage>> getAnimatedImages() {
        return animatedImages;
    }

    public ArrayList<ArrayList<AffineTransform>> getAffineTransforms() {
        return affineTransforms;
    }

    ArrayList<ArrayList<BufferedImage>> animatedImages = new ArrayList<ArrayList<BufferedImage>>();

    ArrayList<ArrayList<AffineTransform>> affineTransforms = new ArrayList<ArrayList<AffineTransform>>();

    public AnimatedObject(BufferedImage img, AtlasConfig atlas, SpriteJsonConfig config) {

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

                AffineTransform tempT = new AffineTransform();
                double xLoc = tempI.getWidth()/2.0;
                double yLoc = tempI.getHeight()/2.0;
                tempT.translate(-atlas.getFrameX(i),-atlas.getFrameY(i));

                //tempT.translate(-xLoc,-yLoc);

                innerAfineTransforms.add(tempT);

                i+=1;
            }
            i-=1;
            animationsName.add(innerAnimationsName);
            animatedImages.add(innerImages);
            affineTransforms.add(innerAfineTransforms);
        }
    }
}
