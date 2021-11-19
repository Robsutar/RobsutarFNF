package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.AbstractObjects.Renderable;
import com.robsutar.robsutarfnf.AnimationBuilder.AnimationFactory;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GuiHandler extends BaseHandler {

    public GuiHandler(){
    }

    @Override
    public void tick() {
    }

    @Override
    public void renderer(Graphics2D g) {
        /*
        int x = 640;
        int y = 370;

        AffineTransform at = new AffineTransform(affineTransforms.get(state).get(animIndex));
        BufferedImage img = images.get(state).get(animIndex);

        at.translate(-images.get(state).get(0).getWidth()/2.0,-images.get(state).get(0).getHeight()/2.0); //only first image width and height
        at.translate(x,y);

        ImageManager.makeImage(g,img,at);


         */
    }
}
