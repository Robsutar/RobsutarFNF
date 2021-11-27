package com.robsutar.robsutarfnf.ImageBuffer;

import com.robsutar.robsutarfnf.RenderableObjects.Position;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class AnimationStream extends Position {
    private List<AffineTransform> transforms= new ArrayList<>();

    public  AnimationStream (List<Position> positions){

        for (int i = 0; i < positions.toArray().length;i++){
            Position p = positions.get(i);
            AffineTransform t = new AffineTransform();
            t.translate(p.getX(),p.getY());
            t.rotate(p.getRotation());
            t.scale(p.getScale(),p.getScale());
            transforms.add(t);
        }

    }

    public List<AffineTransform> getTransforms() {
        return transforms;
    }
}
