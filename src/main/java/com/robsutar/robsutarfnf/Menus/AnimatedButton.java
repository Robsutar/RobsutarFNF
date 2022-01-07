package com.robsutar.robsutarfnf.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.GameObjects.GameObject;
import com.robsutar.robsutarfnf.Handler;
import com.robsutar.robsutarfnf.Threads.MouseInteractive;
import com.robsutar.robsutarfnf.Window.Anchor.Anchor;

import java.awt.image.BufferedImage;

public abstract class AnimatedButton extends AnimatedObject implements MouseInteractive {
    public AnimatedButton(Anchor anchor, Atlas atlas) {
        super(anchor,atlas);
    }

    protected abstract void action();

    @Override
    public void mouseClicked() {
        if (isInto(Handler.mousePosition)){
            action();
        }
    }
}
