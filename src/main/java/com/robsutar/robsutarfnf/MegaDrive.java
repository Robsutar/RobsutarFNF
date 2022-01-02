package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.GameObjects.GameObject;

import java.awt.*;

public class MegaDrive extends GameObject {
    public MegaDrive(int centerX, int centerY) {
        super(centerX, centerY, 50, 50);
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
        g2d.fillRect(x,y,width,height);
    }
}
