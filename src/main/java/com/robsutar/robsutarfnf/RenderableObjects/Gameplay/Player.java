package com.robsutar.robsutarfnf.RenderableObjects.Gameplay;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.image.BufferedImage;

public class Player extends AnimatedObject {
    public Player(int x, int y, AtlasConfig atlas) {
        super(x,y,atlas);
        setPriority((byte) 1);
    }
}
