package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Assets;

public class TitleScream extends AnimatedObject {
    public TitleScream(int x, int y) {
        super(x, y, Assets.AssetsXml.GF_DANCE_TITLE);
        moveByCenter(x,y);
    }
}
