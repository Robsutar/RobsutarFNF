package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class StaticBox extends RenderableObject implements Box{
    public StaticBox(int x, int y, BufferedImage img) {
        super(x, y);
        setActualImage(img);
        setActualTransform(new AffineTransform());
        setWidth(img.getWidth());
        setHeight(img.getHeight());
    }
}
