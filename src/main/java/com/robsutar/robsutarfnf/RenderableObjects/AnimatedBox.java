package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;

public class AnimatedBox extends AnimatedObject implements Box{
    public AnimatedBox(int x, int y, AtlasConfig atlasXml) {
        super(x, y, atlasXml);
    }

    @Override
    protected void onTick() {
        if (isInto(getX(),getY(),getWidth(),getHeight())){
            setScale(1.3);
        }
    }
}
