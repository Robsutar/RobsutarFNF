package com.robsutar.robsutarfnf.Fnf.Menus;

import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Threads.MouseInteractive;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

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
