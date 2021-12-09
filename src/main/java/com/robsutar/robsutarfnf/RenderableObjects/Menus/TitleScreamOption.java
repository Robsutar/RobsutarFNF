package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.image.BufferedImage;

public class TitleScreamOption extends RenderableObject {
    public TitleScreamOption(int x, int y, BufferedImage img,TitleScream title) {
        super(x, y);
        setActualImage(img);
    }

    @Override
    public void spawn() {
        super.spawn();
        mouseISpawn();
    }
}
