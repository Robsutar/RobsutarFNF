package com.robsutar.robsutarfnf.Frame;

import com.robsutar.robsutarfnf.AnimationBuilder.Stream;
import com.robsutar.robsutarfnf.RenderableObjects.Position;

public class Camera{
    Stream actualStream = new Stream();
    private double rotation=0,scale=1;

    public Camera(){
    }

    public int getX(){
        return actualStream.getX();
    }
    public int getY(){
        return actualStream.getY();
    }

    public double getRotation() {
        return rotation;
    }

    public double getScale() {
        return scale;
    }
}
