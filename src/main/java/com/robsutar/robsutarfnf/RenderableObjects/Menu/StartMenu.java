package com.robsutar.robsutarfnf.RenderableObjects.Menu;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Interfaces.MouseInteractive;
import com.robsutar.robsutarfnf.RenderableObjects.Position;

public class StartMenu extends AnimatedObject implements MouseInteractive {
    public StartMenu(Position pos) {
        super(pos, Assets.AssetsXml.GF_DANCE);
        spawn();
    }
}
