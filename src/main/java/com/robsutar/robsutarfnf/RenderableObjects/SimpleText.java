package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Graphics.StringDesigner;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.Types.PriorityTypes;
import com.robsutar.robsutarfnf.Vector2d;

import java.awt.*;

public class SimpleText extends SimpleRenderable implements StringDesigner, Ticable {
    protected String text;
    public SimpleText(int x, int y, String text) {
        setLocation(x,y);
        this.text=text;
    }

    protected char[] getChars() {
        return text.toCharArray();
    }

    @Override
    public void renderer(Graphics2D g2d) {
        super.renderer(g2d);
        FontMetrics metrics = g2d.getFontMetrics();
        setWidth(metrics.stringWidth(formatText(text)));
        setHeight((metrics.getHeight()/2-metrics.getAscent())*2);
        super.renderer(g2d);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getOpacity()));
        g2d.translate(x,y);
        g2d.scale(getScale(),getScale());
        g2d.translate(-x,-y);
        drawString(g2d,text,x,y);
    }

    public void setText(String text) {this.text=text;}
}
