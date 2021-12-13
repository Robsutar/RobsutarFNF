package com.robsutar.robsutarfnf.RenderableObjects.Gameplay;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;

public class Player extends AnimatedObject {
    public Player(int x, int y, AtlasConfig atlas) {
        super(x,y,atlas);
        setPriority((byte) 1);
    }
}
