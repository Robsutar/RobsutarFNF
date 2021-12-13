package com.robsutar.robsutarfnf.AnimationBuilder;

import java.util.List;

public class MonoAtlas{

    protected List<String> name;
    protected List<Integer> x;
    protected List<Integer> y;

    protected List<Integer> width;

    protected List<Integer> height;
    protected List<Integer> frameX;
    protected List<Integer> frameY;
    protected List<Integer> frameWidth;
    protected List<Integer> frameHeight;

    MonoAtlas(List<String> name,List<Integer> x, List<Integer> y, List<Integer> width, List<Integer> height,
              List<Integer> frameX, List<Integer> frameY, List<Integer> frameWidth, List<Integer> frameHeight){
        this.name = name;this.x = x;this.y = y;this.width = width;this.height = height;
        this.frameX = frameX;this.frameY = frameY;this.frameWidth = frameWidth;this.frameHeight = frameHeight;
    }
    public List<String> getName() {
        return name;
    }

    public String getName(int index) {
        if (index>=name.toArray().length||index<0){return "";}
        return name.get(index);}

    public int getX(int index) {
        if (index>=x.toArray().length||index<0){return 0;}
        return x.get(index);
    }

    public int getY(int index) {
        if (index>=y.toArray().length||index<0){return 0;}
        return y.get(index);
    }

    public int getWidth(int index) {
        return width.get(index);
    }

    public int getHeight(int index) {
        return height.get(index);
    }

    public int getFrameX(int index) {
        return frameX.get(index);
    }

    public int getFrameY(int index) {
        return frameY.get(index);
    }

    public int getFrameWidth(int index) {
        return frameWidth.get(index);
    }

    public int getFrameHeight(int index) {
        return frameHeight.get(index);
    }
}
