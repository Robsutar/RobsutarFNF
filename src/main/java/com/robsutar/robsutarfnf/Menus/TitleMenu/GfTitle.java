package com.robsutar.robsutarfnf.Menus.TitleMenu;

import com.robsutar.robsutarfnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Graphics.Camera;
import com.robsutar.robsutarfnf.Menus.AnimatedButton;
import com.robsutar.robsutarfnf.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Window.WindowPositions.Anchor;

public class GfTitle extends AnimatedButton  {
    private boolean clicked = false;

    public GfTitle(Anchor anchor) {
        super(anchor, Assets.GF_TITLE);
    }

    @Override
    protected void action() {
        clicked=!clicked;
        KeyFrame cameraAnimation = new KeyFrame(25,-300,0,0.3,0,0);
        KeyFrame gfAnimation = new KeyFrame(15,0,0,-0.1,7,0);
        System.out.println(clicked);
        if (clicked) {
            Camera.getCamera().animation.finishAll();
            Camera.getCamera().animation.addFrame(cameraAnimation);
            animation.finishAll();
            animation.addFrame(gfAnimation);
            animation.addFrame(gfAnimation.reverse());

        } else {
            Camera.getCamera().animation.finishAll();
            Camera.getCamera().animation.addFrame(cameraAnimation.reverse());
            animation.addFrame(gfAnimation.reverse());
            animation.addFrame(gfAnimation);
        }
    }
}
