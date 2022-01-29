package com.robsutar.robsutarfnf.Fnf.Menus.TitleMenu;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Fnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Engine.Interfaces.BpmTicable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

public class GfTitle extends AnimatedObject implements BpmTicable {
    private boolean mouseAt=false;

    public GfTitle(Anchor anchor) {
        super(anchor, Assets.GF_TITLE);
        priority = PLAYER_PRIORITY+1;
    }

    @Override
    public void bpmTick(int age) {
        if (age==0){
            if (isInto(Handler.mousePosition)) {
                KeyFrame kf = new KeyFrame(5, 0, 0, 0.1, 0, 0);
                animation.addFrame(kf);
                animation.addFrame(kf.reverse());
            }
        } else if (age==8){
            KeyFrame kf = new KeyFrame(5, 0, 0, 0.03, 0, 0);
            animation.addFrame(kf);
            animation.addFrame(kf.reverse());
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (isInto(Handler.mousePosition)){
            if (!mouseAt) {
                animation.addFrame(new KeyFrame(20, 0, 0, 0.05, 0, 0));
            }
            mouseAt = true;
        } else {
            if (mouseAt){
                animation.finishAll();
                animation.addFrame(new KeyFrame(20, 0, 0, 0.05, 0, 0).reverse());
            }
            mouseAt = false;
        }
    }
}
