package com.robsutar.robsutarfnf.RenderableObjects.Objects;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;

public class StartMenu extends AnimatedObject {
    public StartMenu() {
        super(Main.getWindowDim().width/2, Main.getWindowDim().height/2, Assets.AssetsXml.GF_DANCE);
    }

    @Override
    protected void onTick() {

    }
}
