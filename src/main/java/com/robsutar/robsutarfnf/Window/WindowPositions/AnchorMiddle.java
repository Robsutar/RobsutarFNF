package com.robsutar.robsutarfnf.Window.WindowPositions;

import com.robsutar.robsutarfnf.Window.Window;

public class AnchorMiddle extends Anchor {
    @Override
    public int getX() {
        return Window.wdt()/2;
    }

    @Override
    public int getY() {
        return Window.hgt()/2;
    }
}
