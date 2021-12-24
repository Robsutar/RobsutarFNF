package com.robsutar.robsutarfnf.RenderableObjects.Gameplay;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Interface.KeyboardInteractive;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends AnimatedObject implements KeyboardInteractive {

    public Player(int x, int y, AtlasConfig atlasXml) {
        super(x, y, atlasXml);
        spawnKeyboardTick();
    }

    @Override
    public void tick() {
        setLocation(Main.xMouse, Main.yMouse);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 65) {
            setAnimationIndex(getAnimationIndex() - 1);
        } else if(e.getKeyCode() == 68) {
            setAnimationIndex(getAnimationIndex() + 1);
        }
    }
}
