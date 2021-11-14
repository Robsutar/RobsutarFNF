package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimationFactory;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GuiHandler extends BaseHandler {

    int animIndex;

    AnimationFactory factory;
    ArrayList<ArrayList<BufferedImage>> images;

    public GuiHandler(AnimationFactory factory){
        this.factory=factory;
        this.images=factory.getAnimatedObject().getAnimatedImages();
    }

    @Override
    public void onTick() {
        animIndex = age;
        int lastAnimFrame = images.get(Main.state).toArray().length;
        if (animIndex >= lastAnimFrame) {
            animIndex = animIndex - lastAnimFrame*(animIndex/lastAnimFrame);
        }
    }

    @Override
    public void renderer(Graphics2D g) {
        AffineTransform at = AffineTransform.getTranslateInstance(20,20);
        ImageManager.makeImage(g,images.get(Main.state).get(animIndex), at);
    }
}
