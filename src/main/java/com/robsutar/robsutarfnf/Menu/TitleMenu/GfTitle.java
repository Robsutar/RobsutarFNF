package com.robsutar.robsutarfnf.Menu.TitleMenu;

import com.robsutar.robsutarfnf.AnimationBuilder.KeyFrame;
import com.robsutar.robsutarfnf.Interface.KeyboardInteractive;
import com.robsutar.robsutarfnf.Interface.MouseInteractive;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

public class GfTitle extends AnimatedObject  implements MouseInteractive, KeyboardInteractive {

    private boolean onZoom = false;

    private KeyFrame kframe = new KeyFrame(10,0.3,0,0,0);

    public GfTitle() {
        super(Main.WIDTH/2,Main.HEIGHT/2, Main.mainAssets.GF_DANCE_TITLE);
        setPriority(PriorityTypes.PLAYER);
    }

    @Override
    public void spawn() {
        super.spawn();
        spawnKeyboardTick();
        spawnMouseInteractive();
    }
    @Override
    public void kill() {
        super.kill();
        killKeyboardTick();
        killMouseInteractive();
    }

    @Override
    public void mouseReleased() {
        if (onZoom){
            Main.handler.camera.animation.playAnimation(kframe.reverse());
        } else {
            Main.handler.camera.animation.playAnimation(kframe);
        }
        onZoom=!onZoom;
    }
}
