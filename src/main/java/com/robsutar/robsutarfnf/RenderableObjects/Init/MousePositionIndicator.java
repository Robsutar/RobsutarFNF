package com.robsutar.robsutarfnf.RenderableObjects.Init;

import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.MainHandler;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MousePositionIndicator extends RenderableObject {
    public MousePositionIndicator() {
        super(Main.xMouse,Main.yMouse,null);
        setPriority(MainHandler.maxRenderPriority);
        spawn();
    }

    @Override
    public void tick() {

    }

    @Override
    public void renderer(Graphics2D g2d, byte priority) {
        if (priority==getPriority()){
            g2d.drawString(Main.xMouse+" "+Main.yMouse,Main.xMouse,Main.yMouse);
        }
    }
}
