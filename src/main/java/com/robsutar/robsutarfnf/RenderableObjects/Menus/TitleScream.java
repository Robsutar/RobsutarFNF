package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Interfaces.MouseInteractive;
import com.robsutar.robsutarfnf.Main;

import java.awt.event.MouseEvent;

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
    public void tick() {
        super.tick();
        setTargetPos(Main.getxMouse(),Main.getyMouse());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
}
