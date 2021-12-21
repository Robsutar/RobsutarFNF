package com.robsutar.robsutarfnf.Menu;

import com.robsutar.robsutarfnf.Interface.BpmTicable;
import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.SimpleRenderable;

import java.awt.*;

public class WindowCubids implements BpmTicable {
    private int boxSize = 50;
    private int width = Main.WIDTH/boxSize;
    private int height = Main.HEIGHT/boxSize;

    private int xIndex,yIndex;

    public WindowCubids(){
        spawnBpm();

        new singleBox(Main.WIDTH/2,Main.HEIGHT/2,boxSize);
    }

    @Override
    public void bpmTick() {
        xIndex++;
        yIndex++;
    }
    public class singleBox extends SimpleRenderable implements BpmTicable {
        private boolean scaling = true;
        public singleBox(int x,int y,int boxSize){
            this.x=x;this.y=y;
            width=boxSize;height=boxSize;
            setPriority(11);
            setOpacity(0);
            setScale(0);
            spawn();
            spawnBpm();
        }

        @Override
        public void bpmTick() {
            if (scaling){
                setScale(getScale()+0.01);
                setOpacity(getOpacity()+0.01f);
                if (getScale()>=1){
                    scaling=false;
                }
            }
        }

        @Override
        public void renderer(Graphics2D g2d) {
            super.renderer(g2d);
            g2d.setColor(Color.CYAN);
            g2d.fillRect(x,y,width,height);
        }
    }
}
