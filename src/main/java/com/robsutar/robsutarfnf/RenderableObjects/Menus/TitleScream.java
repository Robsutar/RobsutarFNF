package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Interfaces.MouseInteractive;

import java.awt.event.MouseEvent;
import java.util.Random;

public class TitleScream extends AnimatedObject implements MouseInteractive {
    private boolean atZoom=false;
    public TitleScream(int x, int y) {
        super(x, y, Assets.AssetsXml.GF_DANCE_TITLE);
        moveByCenter(x,y);
    }

    @Override
    public void spawn() {
        super.spawn();
        mouseISpawn();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        atZoom=!atZoom;
        if (atZoom){
            getVector().setTargetScale(0.5);
            getVector().setX(5);
        } else {
            getVector().setTargetScale(0);
            getVector().setX(-4);
        }
    }
}
