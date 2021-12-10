package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.Graphics.StringManipulator;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TitleScreamOption extends RenderableObject {
    String text;
    private int opacity = 0;
    public boolean oculte = false;
    public TitleScreamOption(int x, int y, BufferedImage img, String text) {
        super(x, y);
        this.text=text;
        mouseInteractive=true;
        setActualImage(img);
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void tick() {
        super.tick();
        if (oculte&&opacity!=0){
            opacity-=1;
        } else if (!oculte&&opacity!=25){
            opacity+=1;
        }
        if (isInto(getX(),getY(),getWidth(),getHeight())){
            getVector().setScale(0.2);
        } else {
            getVector().setScale(0);
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        if (alive) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity / 25.0F));
            super.render(g2d);
            StringManipulator.drawCenteredString(g2d, text, getX(), getY(), getWidth(), getHeight());
        }
    }

    @Override
    protected void onMousePressed() {
        if (!oculte){
            System.out.println("TITLE OPTION ACTION");
        }
    }
}
