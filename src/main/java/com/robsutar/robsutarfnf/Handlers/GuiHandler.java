package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimationFactory;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

public class GuiHandler extends BaseHandler {

    int animIndex;
    AnimationFactory factory;

    public GuiHandler(AnimationFactory factory){
        this.factory=factory;
    }

    @Override
    public void onTick() {
        animIndex = age;
        int lastAnimFrame = 6;
        if (animIndex >= lastAnimFrame) {
            animIndex = animIndex - lastAnimFrame*(animIndex/lastAnimFrame);
        }
    }

    @Override
    public void renderer(Graphics2D g) {
        AffineTransform at = AffineTransform.getTranslateInstance(20,20);
        //ImageManager.makeImage(g,factory.getAnimatedObject().getAnimImages().get(0).get(0), at);
    }
}
