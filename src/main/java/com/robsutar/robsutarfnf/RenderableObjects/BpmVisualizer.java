package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Graphics.RainbowColor;
import com.robsutar.robsutarfnf.Interface.BpmTicable;
import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BpmVisualizer implements BpmTicable {
    private int age = 0;
    private int index = 0;
    private int x,y;
    public BpmVisualizer() {
        this.x=Main.WIDTH/2-200;this.y= Main.HEIGHT-(Main.HEIGHT/3);
    }

    @Override
    public void bpmTick() {
        age++;
        if (age%16==0){
            index++;
            System.out.println(age/16);
            if (index>3){
                index=0;
            }
            new visualizer(x+100*index,y);
        }
    }

    public class visualizer implements Renderable, BpmTicable {
        private int x,y;
        private byte priority = 3;
        private float  opacity = 1;
        public visualizer(int x, int y){
            this.x=x;this.y=y;
            spawnBpm();
            spawnRender();
        }

        @Override
        public void bpmTick() {
            opacity -=0.05;
        }

        @Override
        public void renderer(Graphics2D g2d, byte priority) {
            if (priority ==this.priority){
                onRenderer(g2d);
            }
        }
        public void onRenderer(Graphics2D g2d){
            if (opacity<0){
                killBpm();
                killRender();
                return;
            }
            g2d.setStroke(new BasicStroke(3));
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));

            g2d.setColor(RainbowColor.rainbowColor(15));
            g2d.fillRect(x,y,100,50);
            g2d.setColor(Color.black);
            g2d.drawRect(x,y,100,50);
        }
    }
}
