package com.robsutar.robsutarfnf.Menus.TitleMenu;

import com.robsutar.robsutarfnf.Graphics.Camera;
import com.robsutar.robsutarfnf.Handler;
import com.robsutar.robsutarfnf.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Threads.MouseInteractive;
import com.robsutar.robsutarfnf.Threads.Ticable;
import com.robsutar.robsutarfnf.Window.Anchor.AnchorBox;
import com.robsutar.robsutarfnf.Window.Anchor.AnchorTypes;

import java.util.ArrayList;
import java.util.List;

public class TitleMenu implements Ticable, MouseInteractive {
    private final GfTitle gf = new GfTitle(AnchorTypes.ANCHOR_MIDDLE);
    private final List<TitleOptions> titleOptions = new ArrayList<>();
    private boolean clicked = false;

    public TitleMenu(){
        titleOptions.add(new TitleOptions(new AnchorBox(gf)));
        titleOptions.add(new TitleOptions(new AnchorBox(gf)));
        titleOptions.add(new TitleOptions(new AnchorBox(gf)));

        if (!titleOptions.isEmpty()) {
            int titleHeight = (int) (titleOptions.get(0).height*1.4);
            int fullHeight = titleHeight*(titleOptions.toArray().length-1);
            for (int i = 0; i <titleOptions.toArray().length;i++){
                TitleOptions t = titleOptions.get(i);
                t.setLocation(600,-fullHeight/2+titleHeight*(i));
                t.animation.addFrame(new KeyFrame(1,0,0,(-i-1)/2.0,0,-i-1));
                t.animation.finishAll();
            }
        }
    }

    @Override
    public void spawnAll() {
        Ticable.super.spawnAll();
        gf.spawnAll();
        for(TitleOptions t:titleOptions){
            t.spawnAll();
        }
    }

    @Override
    public void killAll() {
        Ticable.super.killAll();
        gf.killAll();
        for(TitleOptions t:titleOptions){
            t.killAll();
        }
    }

    protected void action() {
        clicked=!clicked;
        KeyFrame cameraAnimation = new KeyFrame(25,-300,0,0.2,0,0);
        KeyFrame gfAnimation = new KeyFrame(15,0,0,-0.1,5,0);
        if (clicked) {
            Camera.getCamera().animation.finishAll();
            Camera.getCamera().animation.addFrame(cameraAnimation);
            gf.animation.finishAll();
            gf.animation.addFrame(gfAnimation);
            gf.animation.addFrame(gfAnimation.reverse());
            for (int i = 0; i <titleOptions.toArray().length;i++){
                TitleOptions t = titleOptions.get(i);
                t.animation.addFrame(new KeyFrame(20+5*(i+1),0,0,(i+1)/2.0,0,i+1));
            }
        } else {
            Camera.getCamera().animation.finishAll();
            Camera.getCamera().animation.addFrame(cameraAnimation.reverse());
            gf.animation.finishAll();
            gf.animation.addFrame(gfAnimation.reverse());
            gf.animation.addFrame(gfAnimation);
            for (int i = 0; i <titleOptions.toArray().length;i++){
                TitleOptions t = titleOptions.get(i);
                t.animation.addFrame(new KeyFrame(20+5*(i+1),0,0,(-i-1)/2.0,0,-i-1));
            }
        }
    }

    @Override
    public void mouseReleased() {
        if (gf.isInto(Handler.mousePosition)){
            action();
        }
    }
}
