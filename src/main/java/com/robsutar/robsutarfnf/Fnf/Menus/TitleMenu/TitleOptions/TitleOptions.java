package com.robsutar.robsutarfnf.Fnf.Menus.TitleMenu.TitleOptions;

import com.robsutar.robsutarfnf.Engine.Assets;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.SimpleButton;
import com.robsutar.robsutarfnf.Engine.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import java.awt.*;

public class TitleOptions extends SimpleButton {
    protected boolean mouseAt = true;

    public TitleOptions(Anchor anchor) {
        super(anchor, Assets.MENU_OPTION);
        setPriority(PLAYER_PRIORITY);
    }

    @Override
    protected void action() {
        KeyFrame kf = new KeyFrame(7,0,0,0.05,0,0);
        animation.finishAll();
        animation.addFrame(kf);
        animation.addFrame(kf.reverse());
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

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
    }
}
