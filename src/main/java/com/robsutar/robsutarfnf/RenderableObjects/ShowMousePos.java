package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Graphics.StringManipulator;
import com.robsutar.robsutarfnf.Interfaces.Renderable;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public class ShowMousePos implements Renderable {
    public ShowMousePos(){
        renderSpawn();
    }
    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.cyan);
        StringManipulator.drawCenteredString(g2d, Main.getxMouse() + " " + Main.getyMouse(), Main.getxMouse(), Main.getyMouse(),0.5f);
    }
}
