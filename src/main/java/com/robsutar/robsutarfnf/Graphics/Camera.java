package com.robsutar.robsutarfnf.Graphics;

import com.robsutar.robsutarfnf.GameObjects.SimpleRenderable;
import com.robsutar.robsutarfnf.Handler;
import com.robsutar.robsutarfnf.Window.Window;

import java.awt.*;

public class Camera extends SimpleRenderable {

    public void tick(){
        animation.tick();
    }

    @Override
    public void renderTranslateMiddle(Graphics2D g2d) {
        g2d.translate(x,y);
    }

    @Override
    public void render(Graphics2D g2d) {
        setDimension(Window.windowDim);
        super.render(g2d);
    }

    public static Camera getCamera(){
        return Handler.camera;
    }
}
