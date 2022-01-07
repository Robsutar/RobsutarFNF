package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Box;
import com.robsutar.robsutarfnf.Files.FileManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Atlas {

    private final XmlImageStream semiAtlas;
    private final JsonReadjust readjust;

    public Atlas(File xmlPath){
        semiAtlas=new XmlImageStream(xmlPath);
        String jsonPath = semiAtlas.folderPath+(
                semiAtlas.getImageName().replace(".png",".json"));
        readjust = new JsonReadjust(FileManager.loadFile(jsonPath));
        if (readjust.getReadjusts()==null) {
            List<Box> rdj = new ArrayList<>();
            for (int i = 0; i < semiAtlas.getNames().toArray().length; i++) {
                rdj.add(new Box());
            }
            FileManager.writeJson(jsonPath, JsonReadjust.writeAnimationReadjust(rdj));
            readjust.setReadjusts(rdj);
        }
    }

    public void rotate(int animationIndex, int range){
        Collections.rotate(semiAtlas.images.get(animationIndex),1);
        Collections.rotate(semiAtlas.framesX.get(animationIndex),1);
        Collections.rotate(semiAtlas.framesY.get(animationIndex),1);
    }

    public void rotate(int animationIndex){
        rotate(animationIndex,1);
    }

    public int getFrameX(int animationIndex){
        if (!semiAtlas.framesX.isEmpty()) {
            return semiAtlas.framesX.get(animationIndex).get(0);
        }
        return 0;
    }
    public int getFrameY(int animationIndex){
        if (!semiAtlas.framesY.isEmpty()) {
            return semiAtlas.framesY.get(animationIndex).get(0);
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

    public BufferedImage getImage(int animationIndex){
        if (!semiAtlas.images.isEmpty()) {
            return semiAtlas.images.get(animationIndex).get(0);
        }
        return null;
    }

    public Box getReadjust(int animationIndex){
        return readjust.getReadjusts().get(animationIndex);
    }

    public void renderReadjust(Graphics2D g2d, int animationIndex){
        int x = -getFrameX(animationIndex)+getReadjust(animationIndex).x;
        int y = -getFrameY(animationIndex)+getReadjust(animationIndex).y;
        g2d.translate(x,y);
    }
}
