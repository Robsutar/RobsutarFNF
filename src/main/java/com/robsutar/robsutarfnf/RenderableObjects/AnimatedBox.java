package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;

import java.awt.event.MouseEvent;

public abstract class AnimatedBox extends AnimatedObject{
    public AnimatedBox(int x, int y, AtlasConfig atlasXml) {
        super(x, y, atlasXml);
        setMouseInteractive(true);
    }

    @Override
    public void onTick() {
        if (isInto()) {
            setTargetScale(1.3);
        }
    }
}
