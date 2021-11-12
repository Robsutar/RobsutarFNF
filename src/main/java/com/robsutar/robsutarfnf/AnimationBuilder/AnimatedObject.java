package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public BufferedImage getUp(int index) {
        return up.get(index);
    }
    public BufferedImage geLeft(int index) {
        return left.get(index);
    }
    public BufferedImage getDown(int index) {
        return down.get(index);
    }
    public BufferedImage getRight(int index) {
        return right.get(index);
    }

    public AnimatedObject(BufferedImage img, AtlasConfig atlas, SpriteJsonConfig config){

        int tL = atlas.getName().toArray().length;
        for (int i = 0;i<tL;i++){
            if (Objects.equals(atlas.getName().get(i), config.getUp())){
                this.up.add(ImageManager.cropImage(img,atlas.getX().get(i),atlas.getY().get(i),
                        atlas.getWidth().get(i),atlas.getHeight().get(i)));
            } else if (Objects.equals(atlas.getName().get(i), config.getUp())){
                this.left.add(ImageManager.cropImage(img,atlas.getX().get(i),atlas.getY().get(i),
                        atlas.getWidth().get(i),atlas.getHeight().get(i)));
            } else if (Objects.equals(atlas.getName().get(i), config.getUp())){
                this.down.add(ImageManager.cropImage(img,atlas.getX().get(i),atlas.getY().get(i),
                        atlas.getWidth().get(i),atlas.getHeight().get(i)));
            } else if (Objects.equals(atlas.getName().get(i), config.getUp())){
                this.right.add(ImageManager.cropImage(img,atlas.getX().get(i),atlas.getY().get(i),
                        atlas.getWidth().get(i),atlas.getHeight().get(i)));
            }
        }
    }
}
