package com.robsutar.robsutarfnf.Menus;

import com.robsutar.robsutarfnf.GameObjects.GameObject;
import com.robsutar.robsutarfnf.Handler;
import com.robsutar.robsutarfnf.Threads.MouseInteractive;
import com.robsutar.robsutarfnf.Window.Anchor.Anchor;

import java.awt.image.BufferedImage;

public abstract class SimpleButton extends GameObject implements MouseInteractive {
    public SimpleButton(Anchor anchor, BufferedImage img) {
        super(anchor);
        setImage(img,true);
    }

    protected abstract void action();

    @Override
    public void mouseClicked() {
        if (isInto(Handler.mousePosition)){
            action();
        }
    }
}
