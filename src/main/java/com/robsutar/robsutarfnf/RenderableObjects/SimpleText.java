package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Graphics.StringDesigner;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public class SimpleText extends RenderableObject implements StringDesigner {
    protected String text;
    protected int age = 0;
    protected int index = 0;
    public SimpleText(int x, int y, String text) {
        super(x, y, null);
        this.text=text;
        priority=4;
    }

    @Override
    public void tick() {
        age++;
        if (age%20==0){
            if (index+1<=getChars().length){
                index++;
            }
        }
        super.tick();
    }

    protected char[] getChars() {
        return text.toCharArray();
    }

    @Override
    public void renderer(Graphics2D g2d) {
        FontMetrics metrics = g2d.getFontMetrics();
        setWidth(metrics.stringWidth(formatText(text)));
        setHeight((metrics.getHeight()/2-metrics.getAscent())*2);
        super.renderer(g2d);
    }
    @Override
    protected void onRenderer(Graphics2D g2d) {
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getOpacity()));
        g2d.translate(x,y);
        g2d.scale(getScale(),getScale());
        g2d.translate(-x,-y);
        drawString(g2d,text,x,y);
    }

    public void setText(String text) {this.text=text;}
}
