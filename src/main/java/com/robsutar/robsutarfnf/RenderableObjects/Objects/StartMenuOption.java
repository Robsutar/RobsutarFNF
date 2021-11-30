package com.robsutar.robsutarfnf.RenderableObjects.Objects;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.RenderableObjects.StaticBox;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StartMenuOption extends StaticBox {
    public StartMenuOption(int x, int y) {
        super(x, y, Assets.AssetsImages.START_MENU_OPTION);
    }

    @Override
    public void onMousePressed(MouseEvent e) {

    }

    @Override
    public void onMouseReleased(MouseEvent e) {
    }
}
