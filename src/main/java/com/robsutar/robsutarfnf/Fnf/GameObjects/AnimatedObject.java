package com.robsutar.robsutarfnf.Fnf.GameObjects;

import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Engine.Renderable.GameObject;
import com.robsutar.robsutarfnf.Engine.Threads.AnimationTicable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import java.awt.*;
public class AnimatedObject extends GameObject implements AnimationTicable {
    public final Atlas atlas;
    private int animationIndex = 0;

    public AnimatedObject(Anchor anchor, Atlas atlas) {
        super(anchor);
        this.atlas=atlas;
        setImage(atlas.getImage(animationIndex),false);
        onAnimationIndexUpdate(animationIndex);
    }

    protected void playIdle(){
        onAnimationIndexUpdate(0);
    }

    protected void setAnimationIndex(int index){
        if (index <0||index>=atlas.getNames().toArray().length){
            playIdle();
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
