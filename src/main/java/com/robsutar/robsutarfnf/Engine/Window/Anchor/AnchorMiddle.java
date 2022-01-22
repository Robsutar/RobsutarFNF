package com.robsutar.robsutarfnf.Engine.Window.Anchor;

import com.robsutar.robsutarfnf.Engine.Window.WindowGame;

public class AnchorMiddle extends Anchor {
    @Override
    public int getX() {
        return WindowGame.wdt()/2;
    }

    @Override
    public int getY() {
        return WindowGame.hgt()/2;
    }
}
