package com.robsutar.robsutarfnf.RenderableObjects.Objects;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedBox;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;
import com.robsutar.robsutarfnf.RenderableObjects.Box;

public class StartMenu extends AnimatedBox {
    public StartMenu() {
        super(Main.getWindowDim().width/2, Main.getWindowDim().height/2, Assets.AssetsXml.GF_DANCE);
    }

    @Override
    protected void onTick() {
        super.onTick();
    }
}
