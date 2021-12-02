package com.robsutar.robsutarfnf.RenderableObjects.Menu;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Interfaces.MouseInteractive;
import com.robsutar.robsutarfnf.Interfaces.Ticable;
import com.robsutar.robsutarfnf.RenderableObjects.Position;

import java.awt.event.MouseEvent;

public class StartMenu extends AnimatedObject implements MouseInteractive, Ticable {
    public StartMenu(Position pos) {
        super(pos, Assets.AssetsXml.GF_DANCE);
        bpmSpawn();
        renderableSpawn();
        mouseISpawn();
        ticableSpawn();
    }

    @Override
    public void tick() {
        if (isInto(x,y,getWidth(),getHeight())){
            setScale(1.3);
        } else {setScale(1);}
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
}
