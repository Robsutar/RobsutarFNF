package com.robsutar.robsutarfnf.Engine.Menus;

import com.robsutar.robsutarfnf.Engine.Renderable.GameObject;
import com.robsutar.robsutarfnf.Engine.Settings.GameSettings;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import java.awt.*;

public class BoxVisual extends GameObject {
    public BoxVisual(Anchor anchor) {
        super(anchor);
    }
    public void renderDrawRect(Graphics2D g2d){
        g2d.setColor(GameSettings.FILL_COLOR);
        g2d.fillRoundRect(0,0,width,height,GameSettings.THICKNESS,GameSettings.THICKNESS);
        g2d.setColor(GameSettings.BORDER_COLOR);
        g2d.drawRoundRect(0,0,width,height,GameSettings.THICKNESS,GameSettings.THICKNESS);
    }

    @Override
    public void renderDrawImage(Graphics2D g2d) {
        renderDrawRect(g2d);
        super.renderDrawImage(g2d);
    }
}
