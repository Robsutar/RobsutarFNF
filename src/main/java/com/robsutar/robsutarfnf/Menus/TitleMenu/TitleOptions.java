package com.robsutar.robsutarfnf.Menus.TitleMenu;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Handler;
import com.robsutar.robsutarfnf.Menus.SimpleButton;
import com.robsutar.robsutarfnf.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Window.Anchor.Anchor;

import java.awt.image.BufferedImage;

public class TitleOptions extends SimpleButton {
    protected boolean mouseAt = true;
    public TitleOptions(Anchor anchor) {
        super(anchor, Assets.MENU_OPTION);
    }

    @Override
    protected void action() {

    }

    @Override
    public void tick() {
        super.tick();
        if (isInto(Handler.mousePosition)){
            if (!mouseAt) {
                animation.addFrame(new KeyFrame(20, 50, 0, 0.05, 0, 0));
            }
            mouseAt = true;
        } else {
            if (mouseAt){
                animation.finishAll();
                animation.addFrame(new KeyFrame(20, 50, 0, 0.05, 0, 0).reverse());
            }
            mouseAt = false;
        }
    }
}
