package com.robsutar.robsutarfnf.AnimationBuilder;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class AnimationStream {
    private List<Stream> animations= new ArrayList<>();
    private int index = 0;
    public AnimationStream(){

    }

    public void add(Stream stream){
        animations.add(stream);
    }

    public Stream getNextStream(boolean reverse){
        if (index<0){index=0;}else if (index>animations.toArray().length-1){index = animations.toArray().length-1;}
        if (animations.toArray().length>0){
            if (reverse){index-=1;}else{index+=1;}

            if (animations.toArray().length-1>=index&&index>-1) {
                return animations.get(index);
            } else if (reverse){
                return animations.get(0);
            } else{
                return animations.get(animations.toArray().length-1);
            }
        }
        return new Stream();
    }
    

    public static AnimationStream genericZoom(int times, double scale){
        AnimationStream as = new AnimationStream();
        for (int i = 0; i < times; i++){
            double scaleI = (scale/times)*i;
            Stream stream = new Stream();
            stream.setScale(scaleI);
            as.add(stream);
        }
        return as;
    }

    public List<Stream> getStreams() {
        return animations;
    }
}
