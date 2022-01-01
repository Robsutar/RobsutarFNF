package com.robsutar.robsutarfnf.RenderableObjects.Init;

import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.GameObject;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

import java.awt.*;

public class MousePositionIndicator implements Renderable {
    public MousePositionIndicator() {
        spawnRender();
    }

    @Override
    public int getPriority() {
        return PriorityTypes.MOUSE_INDICATOR;
    }

    @Override
    public void renderer(Graphics2D g2d) {
        g2d.drawString(Main.xMouse+" "+Main.yMouse,Main.xMouse,Main.yMouse);
    }
}
