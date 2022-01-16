package com.robsutar.robsutarfnf.Engine.Graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RainbowColor {

    public static List<Color> rainbowColors = rainbowArray();

    public static int slowness = 10;

    private static java.util.List<Color> rainbowArray(){
        java.util.List<Color> colors = new ArrayList<>();
        for (int r=0; r<100; r++) colors.add(new Color(r*255/100,       255,         0));
        for (int g=100; g>0; g--) colors.add(new Color(      255, g*255/100,         0));
        for (int b=0; b<100; b++) colors.add(new Color(      255,         0, b*255/100));
        for (int r=100; r>0; r--) colors.add(new Color(r*255/100,         0,       255));
        for (int g=0; g<100; g++) colors.add(new Color(        0, g*255/100,       255));
        for (int b=100; b>0; b--) colors.add(new Color(        0,       255, b*255/100));
        colors.add(new Color(        0,       255,         0));
        return colors;
    }

    public static Color rainbowColor(int seed){
        int index =(int)((System.currentTimeMillis())/(slowness+1))+seed;
        index =index-(rainbowColors.toArray().length-1)*((index/(rainbowColors.toArray().length-1)));
        if (index<0){
            index = (rainbowColors.toArray().length-1)+index;
        }
        return rainbowColors.get(index);
    }
}
