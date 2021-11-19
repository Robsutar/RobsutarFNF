package com.robsutar.robsutarfnf.InGameObjects;

import com.robsutar.robsutarfnf.AbstractObjects.Position;
import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.AnimationBuilder.AnimationFactory;
import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.AnimationBuilder.SpriteJsonConfig;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends AnimationFactory {

    public Player(String SPRITEJSONCONFIG, String FOLDER) {
        super(SPRITEJSONCONFIG, FOLDER);
    }

    @Override
    protected void renderer(Graphics2D g) {
        animIndex = getAge();
        state = Main.state;
        System.out.println(animIndex);
        int lastAnimFrame = getAnimatedObject().getAnimatedImages().get(state).toArray().length;
        if (animIndex >= lastAnimFrame) {
            animIndex = animIndex - lastAnimFrame*(animIndex/lastAnimFrame);
        }
        ImageManager.makeImage(getAnimatedObject().getAnimatedImages().get(state).get(animIndex),getX(),getY(),g);
    }

    @Override
    protected void tick() {

    }
}
