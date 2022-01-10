package com.robsutar.robsutarfnf.Engine.Renderable.init;

import com.robsutar.robsutarfnf.Engine.Renderable.GameObject;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.AnchorTypes;

import java.awt.*;

public class VolumeViewer extends GameObject {
    public static long lastRequest = 0;
    public VolumeViewer() {
        super(AnchorTypes.ANCHOR_MIDDLE_BOTTOM);
        setBounds(85*2,50);
        setPriority(MAX_PRIORITY);
        setScale(0);
        spawnAll();
        animation.addFrame(new KeyFrame(15,0,0,1,0,0));
    }

    public static void request(){
        if (lastRequest+1000<System.currentTimeMillis()) {
            new VolumeViewer();
        }
        lastRequest = System.currentTimeMillis();
    }

    @Override
    public boolean affectedByCamera() {
        return false;
    }

    @Override
    public void renderDrawImage(Graphics2D g2d) {
        super.renderDrawImage(g2d);
        g2d.setColor(Color.black);
        g2d.fillRect(-5,-5,width+10,height+10);
        g2d.setColor(Color.white);
        g2d.fillRect(0,0, (int) Handler.volume*2,height);
    }

    @Override
    public void render(Graphics2D g2d) {
        if (lastRequest+1000<System.currentTimeMillis()) {
            animation.addFrame(new KeyFrame(15,0,0,-1,0,0));
        }
        if (getScale()>0){
            super.render(g2d);
        } else {
            killAll();
            lastRequest=0;
        }
    }
}
