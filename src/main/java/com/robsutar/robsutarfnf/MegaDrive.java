package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.GameObjects.GameObject;

import java.awt.*;

public class MegaDrive extends AnimatedObject {
    public MegaDrive(int centerX, int centerY, Atlas atlas) {
        super(centerX, centerY,atlas);
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
    }
}
