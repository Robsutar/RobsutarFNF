package com.robsutar.robsutarfnf.Fnf.GameObjects;

import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;

public class Player extends AnimatedObject{
    protected int arrowUp;
    protected int arrowDown;
    protected int arrowLeft;
    protected int arrowRight;
    protected int arrowIdle;
    public Player(Atlas atlas,String arrowUp, String arrowDown,String arrowLeft, String arrowRight,String arrowIdle) {
        super(Anchor.ANCHOR_MIDDLE, atlas);
        setAnimations(arrowUp,arrowDown,arrowLeft,arrowRight, arrowIdle);
    }

    public void setAnimations(String arrowUp, String arrowDown,String arrowLeft, String arrowRight,String idle){
        this.arrowUp=atlas.getAnimationIndex(arrowUp);this.arrowDown=atlas.getAnimationIndex(arrowDown);
        this.arrowLeft=atlas.getAnimationIndex(arrowLeft);this.arrowRight=atlas.getAnimationIndex(arrowRight);
        this.arrowIdle =atlas.getAnimationIndex(idle);
    }

    public void playUp(){setAnimationIndex(arrowUp);}
    public void playDown(){setAnimationIndex(arrowDown);}
    public void playLeft(){setAnimationIndex(arrowLeft);}
    public void playRight(){
        setAnimationIndex(arrowRight);
    }

    @Override
    public void playIdle() {
        onAnimationIndexUpdate(arrowIdle);
    }
}
