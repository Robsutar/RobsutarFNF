package com.robsutar.robsutarfnf.Engine.Window.Anchor;

import com.robsutar.robsutarfnf.Engine.Window.WindowGame;

public class AnchorTopRight extends Anchor{
    @Override
    public int getX() {
        return WindowGame.wdt();
    }

    @Override
    public int getY() {
        return 0;
    }
}
