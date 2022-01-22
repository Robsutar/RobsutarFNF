package com.robsutar.robsutarfnf.Engine.Window.Anchor;

public class Anchor {

    public static final Anchor ANCHOR_NONE = new Anchor();
    public static final Anchor ANCHOR_MIDDLE = new AnchorMiddle();
    public static final Anchor ANCHOR_MIDDLE_BOTTOM = new AnchorMiddleBottom();
    public static final Anchor ANCHOR_TOP_RIGHT = new AnchorTopRight();

    public int getX(){
        return 0;
    }
    public int getY(){
        return 0;
    }
}
