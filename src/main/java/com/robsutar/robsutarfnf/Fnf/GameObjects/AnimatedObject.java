package com.robsutar.robsutarfnf.Fnf.GameObjects;

import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Engine.Renderable.GameObject;
import com.robsutar.robsutarfnf.Engine.Threads.AnimationTicable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import java.awt.*;
public class AnimatedObject extends GameObject implements AnimationTicable {
    public final Atlas atlas;
    private int animationIndex = 0;
    private int imageIndex = 0;

    public AnimatedObject(Anchor anchor, Atlas atlas) {
        super(anchor);
        this.atlas=atlas;
        width=atlas.getWidth(animationIndex);
        height=atlas.getHeight(animationIndex);
        setImage(atlas.getImage(animationIndex,imageIndex),false);
    }

    protected void playIdle(){
        setAnimationIndex(0);
    }

    public void setAnimationIndex(int index){
        if (index <0||index>=atlas.getNames().toArray().length){
            playIdle();
        } else {
            onAnimationIndexUpdate(index);
        }
    }

    public void playNext(){
        int index = animationIndex+1;
        if (index>=atlas.getNames().toArray().length){
            setAnimationIndex(0);
        } else {
            setAnimationIndex(index);
        }
    }
    public void playBack(){
        int index = animationIndex-1;
        if (index<0){
            setAnimationIndex(atlas.getNames().toArray().length-1);
        } else {
            setAnimationIndex(index);
        }
    }

    public void onAnimationIndexUpdate(int index){
        this.animationIndex = index;
        this.imageIndex=0;
        width=atlas.getWidth(animationIndex);
        height=atlas.getHeight(animationIndex);
        this.image=atlas.getImage(animationIndex,imageIndex);
    }

    public int getAnimationIndex() {
        return animationIndex;
    }

    public void setImageIndex(int index){
        if (index <0||index>=atlas.getImages().get(animationIndex).toArray().length){
            imageIndex=0;
        } else {
            imageIndex=index;
        }
    }

    @Override
    public void animationTick() {
        setImageIndex(imageIndex+1);
        setImage(atlas.getImage(animationIndex,imageIndex),false);
    }

    @Override
    public void renderDrawImage(Graphics2D g2d) {
        atlas.renderReadjust(g2d,animationIndex,imageIndex);
        super.renderDrawImage(g2d);
    }
}
