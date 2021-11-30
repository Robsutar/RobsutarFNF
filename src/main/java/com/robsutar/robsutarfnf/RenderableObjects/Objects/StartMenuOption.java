package com.robsutar.robsutarfnf.RenderableObjects.Objects;

import com.robsutar.robsutarfnf.RenderableObjects.StaticBox;

import java.awt.image.BufferedImage;

public class StartMenuOption extends StaticBox {
    public StartMenuOption(int x, int y, BufferedImage img) {
        super(x, y, img);
    }

    @Override
    protected void onTick() {
        if (isInto(getX(),getY(),getWidth(),getHeight())){
            setTargetScale(1.3);
        }
    }

    @Override
    protected void onBpmTick() {

    }
}
