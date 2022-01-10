package com.robsutar.robsutarfnf.Engine.Graphics;

import com.robsutar.robsutarfnf.Engine.Renderable.SimpleRenderable;
import com.robsutar.robsutarfnf.Engine.Handler;

import java.awt.*;

public class Camera extends SimpleRenderable {

    public void tick(){
        animation.tick();
    }

    @Override
    public void renderTranslateMiddle(Graphics2D g2d) {
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
    }

    public static Camera getCamera(){
        return Handler.camera;
    }
}
