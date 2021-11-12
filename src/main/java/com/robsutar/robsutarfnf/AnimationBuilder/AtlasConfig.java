package com.robsutar.robsutarfnf.AnimationBuilder;

import java.util.List;

public class AtlasConfig {

    protected String imagePath;

    protected List<String> name;
    protected List<Integer> x;
    protected List<Integer> y;

    protected List<Integer> width;

    protected List<Integer> height;
    protected List<Integer> frameX;
    protected List<Integer> frameY;
    protected List<Integer> frameWidth;
    protected List<Integer> frameHeight;
    public AtlasConfig(String imagePath,List<String> name,List<Integer> x, List<Integer> y, List<Integer> width, List<Integer> height,
                       List<Integer> frameX, List<Integer> frameY, List<Integer> frameWidth, List<Integer> frameHeight){

        this.x = x;this.y = y;this.width = width;this.height = height;
        this.frameX = frameX;this.frameY = frameY;this.frameWidth = frameWidth;this.frameHeight = frameHeight;
        this.name = name;this.imagePath = imagePath;
    }
    public List<String> getName() {
        return name;
    }

    public List<Integer> getX() {
        return x;
    }

    public List<Integer> getY() {
        return y;
    }

    public List<Integer> getWidth() {
        return width;
    }

    public List<Integer> getHeight() {
        return height;
    }

    public List<Integer> getFrameX() {
        return frameX;
    }

    public List<Integer> getFrameY() {
        return frameY;
    }

    public List<Integer> getFrameWidth() {
        return frameWidth;
    }

    public List<Integer> getFrameHeight() {
        return frameHeight;
    }
}
