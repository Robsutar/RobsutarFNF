package com.robsutar.robsutarfnf.RenderableObjects.Objects;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedBox;

import java.awt.event.MouseEvent;

public class StartMenu extends AnimatedBox {

    private boolean approximated = false;

    public StartMenu() {
        super(Main.getWindowDim().width/2, Main.getWindowDim().height/2, Assets.AssetsXml.GF_DANCE);
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        approximated = !approximated;
        if (approximated){
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
    }
}
