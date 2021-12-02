package com.robsutar.robsutarfnf.AnimationBuilder;

import java.awt.geom.AffineTransform;
import java.util.List;

public class AnimationStream {
    private List<Stream> animations;
    private int index = 0;

    public AffineTransform getTransform(AffineTransform transform){
        AffineTransform at = new AffineTransform(transform);
        if (animations!=null) {
            Stream stream = animations.get(index);
            at.translate(stream.getX(), stream.getY());
            at.scale(stream.getScale(), stream.getScale());
        }
        return at;
    }
}
