package com.robsutar.robsutarfnf.Engine.Window.Anchor;

import com.robsutar.robsutarfnf.Engine.Window.Window;

public class AnchorMiddleBottom extends AnchorMiddle{
    @Override
    public int getY() {
        return (int) (Window.hgt()*0.9);
    }
}
