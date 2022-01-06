package com.robsutar.robsutarfnf.Menus.TitleMenu;

import com.robsutar.robsutarfnf.Threads.Ticable;
import com.robsutar.robsutarfnf.Window.Window;
import com.robsutar.robsutarfnf.Window.WindowPositions.AnchorTypes;

public class TitleMenu implements Ticable {
    private final GfTitle gf = new GfTitle(AnchorTypes.ANCHOR_MIDDLE);
    public TitleMenu(){

    }

    @Override
    public void spawnAll() {
        Ticable.super.spawnAll();
        gf.spawnAll();
    }

    @Override
    public void killAll() {
        Ticable.super.killAll();
        gf.killAll();
    }
}
