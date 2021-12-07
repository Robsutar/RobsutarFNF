package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Interfaces.MouseInteractive;

import java.awt.event.MouseEvent;

public class TitleScream extends AnimatedObject implements MouseInteractive {
    public TitleScream(int x, int y) {
        super(x, y, Assets.AssetsXml.GF_DANCE_TITLE);
        moveByCenter(x,y);
        spawn();
        mouseISpawn();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //getVector().setTargetRotation(40);
        getVector().setTargetScale(3);
    }
}
