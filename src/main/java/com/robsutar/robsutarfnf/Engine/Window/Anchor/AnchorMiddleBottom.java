package com.robsutar.robsutarfnf.Engine.Window.Anchor;

import com.robsutar.robsutarfnf.Engine.Window.WindowGame;

public class AnchorMiddleBottom extends AnchorMiddle{
    @Override
    public int getY() {
        return (int) (WindowGame.hgt()*0.9);
    }
}
