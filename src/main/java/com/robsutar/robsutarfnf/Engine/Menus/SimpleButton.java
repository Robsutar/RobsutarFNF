package com.robsutar.robsutarfnf.Engine.Menus;

import com.robsutar.robsutarfnf.Engine.Renderable.GameObject;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Threads.MouseInteractive;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

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
