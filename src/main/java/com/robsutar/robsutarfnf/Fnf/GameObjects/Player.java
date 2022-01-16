package com.robsutar.robsutarfnf.Fnf.GameObjects;

import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.AnchorTypes;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;

public class Player extends AnimatedObject {
    protected final String arrowUp;
    protected final String arrowDown;
    protected final String arrowLeft;
    protected final String arrowRight;
    public Player(Atlas atlas,String arrowUp, String arrowDown,String arrowLeft, String arrowRight) {
        super(AnchorTypes.ANCHOR_MIDDLE, atlas);
        this.arrowUp=arrowUp;this.arrowDown=arrowDown;this.arrowLeft=arrowLeft;this.arrowRight=arrowRight;
    }
}
