package com.robsutar.robsutarfnf.GameObjects;

import com.robsutar.robsutarfnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Threads.AnimationTicable;
import com.robsutar.robsutarfnf.Threads.BpmTicable;
import com.robsutar.robsutarfnf.Window.Anchor.Anchor;

import java.awt.*;
public class AnimatedObject extends GameObject implements AnimationTicable {
    private final Atlas atlas;
    private int animationIndex = 0;

    public AnimatedObject(Anchor anchor, Atlas atlas) {
        super(anchor);
        this.atlas=atlas;
        setImage(atlas.getImage(animationIndex),false);
        onAnimationIndexUpdate(animationIndex);
    }

    private void setAnimationIndex(int index){
        if (index <=0){
            onAnimationIndexUpdate(0);
        } else if (!(index <atlas.getNames().toArray().length)){
            onAnimationIndexUpdate(atlas.getNames().toArray().length-1);
        } else {
            onAnimationIndexUpdate(index);
        }
    }

    public void onAnimationIndexUpdate(int index){
        this.animationIndex = index;
        width=atlas.getWidth(animationIndex);
        height=atlas.getHeight(animationIndex);
    }

    @Override
    public void animationTick() {
        atlas.rotate(animationIndex);
        setImage(atlas.getImage(animationIndex),false);
    }

    @Override
    public void renderDrawImage(Graphics2D g2d) {
        atlas.renderReadjust(g2d,animationIndex);
        super.renderDrawImage(g2d);
    }
}
