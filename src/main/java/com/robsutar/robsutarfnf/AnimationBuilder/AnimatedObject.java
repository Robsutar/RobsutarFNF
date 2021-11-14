package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;

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

    public List<BufferedImage> getAnimImages(int index) {
        return animImages.get(index);
    }

    public List<List<BufferedImage>> getAnimImages() {
        return animImages;
    }

    List<List<BufferedImage>> animImages = new ArrayList<>();

    public AnimatedObject(BufferedImage img, AtlasConfig atlas, SpriteJsonConfig config) {

        ArrayList<ArrayList<String>> animationsName = new ArrayList<ArrayList<String>>();

        for (int i = 0;i < atlas.getName().toArray().length;i++){
            String name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);
            ArrayList<String> innerAnimationsName = new ArrayList<String>();

            while (atlas.getName(i).contains(name)){
                name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);
                innerAnimationsName.add(name);
                i+=1;
            }
            System.out.println("Else: "+atlas.getName(i)+" ; "+name);
            animationsName.add(innerAnimationsName);
        }

        for (int i = 0;i < animationsName.toArray().length;i++){
            for (int z = 0;z < animationsName.get(i).toArray().length;z++) {
                    System.out.println(+i + ":" + z + " / " + animationsName.get(i).get(z));
            }
        }

        /*
        int cCA = config.getCustomAnimations().toArray().length;
        int aN = atlas.getName().toArray().length;
        loop : for (int i = 0; i < aN; i++ ){
            for (int z = 0; z < cCA; z++ ){

                List<BufferedImage> images = new ArrayList<>();

                while (atlas.getName(i).contains(config.getCustomAnimations(z))){
                        System.out.println(atlas.getName(i)+" : "+(config.getCustomAnimations(z)));
                    System.out.println("Image printed!");

                    images.add(ImageManager.cropImage(img, atlas.getX(i),atlas.getY(i),atlas.getWidth(i),atlas.getHeight(i) ));

                    i+=1;
                    if (i>=aN){this.animImages.add(images);break loop;}
                }
                System.out.println("LONGURA"+images.toArray().length);

                this.animImages.add(images);

            }
            i--;
        }

         */
    }
}
