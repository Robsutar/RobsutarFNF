package com.robsutar.robsutarfnf.RenderableObjects.Init;

import com.robsutar.robsutarfnf.Graphics.ColorizedString;
import com.robsutar.robsutarfnf.Graphics.StringManipulator;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.util.Random;

public class TextInformation extends RenderableObject {
    private final ColorizedString colorizedString;
    public TextInformation(String str) {
        super(Main.WIDTH/2,Main.HEIGHT/2,null);
        colorizedString=new ColorizedString(str);
        vector.setVector(0,2);
    }

    public void drawString(Graphics2D g2d){
        StringManipulator.drawCenteredString(g2d,colorizedString,this);
    }
    @Override
    protected void onRenderer(Graphics2D g2d) {
        drawString(g2d);
    }
}
