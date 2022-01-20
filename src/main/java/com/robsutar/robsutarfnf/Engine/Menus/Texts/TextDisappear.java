package com.robsutar.robsutarfnf.Engine.Menus.Texts;

import com.robsutar.robsutarfnf.Engine.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

public class TextDisappear extends TextTitleSubtitle {
    int age;int maxAge = 300;int tickLength = 17;
    public TextDisappear(String text, String subtitle) {
        super(Anchor.ANCHOR_TOP_RIGHT, text, subtitle);
    }

    @Override
    public void setTextImage() {
        super.setTextImage();
        setLocation((width/2),height/2+100);
    }

    @Override
    public void tick() {
        super.tick();
        if (age==maxAge-tickLength) {
            animation.addFrame(new KeyFrame(tickLength, (int) (width*1.2), 0, 0, 0, 0));
        } else if (age>=maxAge){
            killAll();
        }
        age++;
    }

    @Override
    public void spawnAll() {
        super.spawnAll();
        animation.addFrame(new KeyFrame(tickLength, (int) (-width*1.2),0,0,0,0));
    }

    @Override
    public void killAll() {
        super.killAll();
    }
}
