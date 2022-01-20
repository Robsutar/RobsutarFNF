package com.robsutar.robsutarfnf.Fnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Engine.Box;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.List;

public class Atlas {

    private final XmlImageStream semiAtlas;
    private final JsonReadjust readjust;

    private final String folder;
    private final String jsonPath;

    public Atlas(File xmlPath){
        semiAtlas=new XmlImageStream(xmlPath);
        folder = semiAtlas.folderPath;
        jsonPath = (semiAtlas.getImageName().replace(".png",".json"));
        readjust = new JsonReadjust(FileManager.loadFile(folder+jsonPath));
        if (readjust.getReadjusts()==null) {
            List<Box> rdj = new ArrayList<>();
            for (int i = 0; i < semiAtlas.getNames().toArray().length; i++) {
                rdj.add(new Box());
            }
            readjust.setReadjusts(rdj);
        }
    }

    public void writeReadjustFile(List<Box> newReadjust){
        readjust.setReadjusts(newReadjust);
        FileManager.writeJson(folder,jsonPath, JsonReadjust.writeAnimationReadjust(newReadjust));
    }

    public int getAnimationIndex(String animationName){
        for(int i = 0; i <getNames().toArray().length;i++){
            if (Objects.equals(getNames().get(i), animationName)){
                return i;
            }
        }
        return 0;
    }

    public String getAnimationName(int index){
        if (index<0||index>=getNames().toArray().length){
            return null;
        }
        return getNames().get(index);
    }

    public int getFrameX(int animationIndex, int imageIndex){
        if (!semiAtlas.framesX.isEmpty()) {
            return semiAtlas.framesX.get(animationIndex).get(imageIndex);
        }
        return 0;
    }
    public int getFrameY(int animationIndex, int imageIndex){
        if (!semiAtlas.framesY.isEmpty()) {
            return semiAtlas.framesY.get(animationIndex).get(imageIndex);
        }
        return 0;
    }

    public int getWidth(int animationIndex){
        return semiAtlas.getWidths().get(animationIndex);
    }

    public int getHeight(int animationIndex){
        return semiAtlas.getHeights().get(animationIndex);
    }

    public List<String> getNames(){return semiAtlas.getNames();}

    public BufferedImage getImage(int animationIndex, int imageIndex){
        if (!semiAtlas.images.isEmpty()) {
            return semiAtlas.images.get(animationIndex).get(imageIndex);
        }
        return null;
    }

    public Box getReadjust(int animationIndex){
        return readjust.getReadjusts().get(animationIndex);
    }

    public void renderReadjust(Graphics2D g2d, int animationIndex, int imageIndex){
        int x = -getFrameX(animationIndex,imageIndex)+getReadjust(animationIndex).x;
        int y = -getFrameY(animationIndex,imageIndex)+getReadjust(animationIndex).y;
        g2d.translate(x,y);
    }

    public String getName() {
        return semiAtlas.getImageName().replace(".png","");
    }

    public List<Box> getReadjust() {
        return readjust.getReadjusts();
    }

    public List<List<BufferedImage>> getImages() {
        return semiAtlas.getImages();
    }
}
