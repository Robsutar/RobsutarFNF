package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Graphics.StringDesigner;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Vector2d;

import java.awt.*;

public class SimpleText extends SimpleRenderable implements StringDesigner, Ticable {
    protected String text;

    Vector2d vector = new Vector2d();

    public SimpleText(int x, int y, String text) {
        setLocation(x,y);
        this.text=text;
    }

    @Override
    public void spawn() {
        super.spawn();
        spawnTick();
    }

    @Override
    public void kill() {
        super.kill();
        killTick();
    }

    protected char[] getChars() {
        return text.toCharArray();
    }

    @Override
    public void tick() {
        setOpacity(getOpacity()-0.01f);

        if (disappear) {
            if(getOpacity() <= 0) {
                kill();
            }
        }
    }

    @Override
    public void renderer(Graphics2D g2d) {
        super.renderer(g2d);

        FontMetrics metrics = g2d.getFontMetrics();
        setWidth(metrics.stringWidth(formatText(text)));
        setHeight((metrics.getHeight()/2-metrics.getAscent())*2);
        super.renderer(g2d);
        drawString(g2d,text,x,y);
    }

    public void setText(String text) {this.text=text;}
}
