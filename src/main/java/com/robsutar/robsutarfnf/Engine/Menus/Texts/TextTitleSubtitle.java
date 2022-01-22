package com.robsutar.robsutarfnf.Engine.Menus.Texts;

import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.BoxVisual;
import com.robsutar.robsutarfnf.Engine.Settings.GameSettings;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextTitleSubtitle extends BoxVisual {

    String text;
    List<String> lines = new ArrayList<>();

    int fontWidth;
    int fontHeight;
    int border = GameSettings.THICKNESS*2;
    int ascent;

    public TextTitleSubtitle(Anchor anchor, String text, String subtitle) {
        super(anchor);
        this.text=text;

        if (subtitle!=null){
            lines.addAll(Arrays.asList(subtitle.split("\n")));
        }
        setPriority(TEXT_BOX_PRIORITY);
    }

    protected void setTextImage(){
        FontMetrics metrics = Handler.metrics;
        width = metrics.stringWidth(text);
        fontHeight = metrics.getHeight();
        ascent=metrics.getAscent();
        height=fontHeight;
        for(String s: lines){
            height+=fontHeight;
            if (metrics.stringWidth(s)>width){
                width=metrics.stringWidth(s);
            }
        }
        fontWidth = width;

        width+=border;height+=border;

        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = (Graphics2D) img.getGraphics();

        g.setFont(metrics.getFont());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = this.width-this.fontWidth;
        int y = border/4+ascent;

        g.setColor(GameSettings.TEXT_COLOR);
        g.drawString(text,width/2,y);
        g.setColor(GameSettings.SUBTITLE_COLOR);

        for (int i = 0; i < lines.toArray().length; i ++){
            String s = lines.get(i);
            g.drawString(s,width/2,y+fontHeight*(i+1));
        }
        g.dispose();
        image=img;
    }

    @Override
    public void spawnAll() {
        if (image==null) {
            setTextImage();
        }
        super.spawnAll();
    }
}
