package com.robsutar.robsutarfnf.RenderableObjects.Player;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Interfaces.WASDInteractive;

public class Player extends AnimatedObject implements WASDInteractive {
    public Player(int x, int y, AtlasConfig atlasXml) {
        super(x, y, atlasXml);
        moveByCenter(x,y);
        wasdSpawn();
    }

    @Override
    public void wPressed() {
        setIndex(getAnimationIndex()+1);
    }
    @Override
    public void sPressed() {
        setIndex(getAnimationIndex()-1);
    }
}
