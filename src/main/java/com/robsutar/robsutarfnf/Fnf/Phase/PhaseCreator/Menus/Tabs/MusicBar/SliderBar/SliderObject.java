package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.MusicBar.SliderBar;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Engine.Box;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public abstract class SliderObject{
    protected BufferedImage img;
    public boolean selected  = false;
    protected int width = 50, height = 50;

    public static final String arrowUp= "arrowUp";
    public static final String arrowDown= "arrowDown";
    public static final String arrowLeft= "arrowLeft";
    public static final String arrowRight= "arrowRight";

    public SliderObject(){
        img = Box.scaleImage(getImage(),width,height);
    }

    private void renderDrawSelected(Graphics2D g2d, int x, int y){
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.2f));
        g2d.setColor(Color.CYAN);
        g2d.fillRect(x-width/2,y-height/2,width,height);
        g2d.setColor(Color.black);
        g2d.drawRect(x-width/2,y-height/2,width,height);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    }

    public String getType(){
        return null;
    }

    private void renderDrawImage(Graphics2D g2d,int x,int y){
        if (img!=null){
            g2d.drawImage(img,x- img.getWidth()/2,y-img.getHeight()/2,null);
        }
    }

    public void render(Graphics2D g2d, int x, int y) {
        renderDrawImage(g2d,x,y);
        if (selected){renderDrawSelected(g2d,x,y);}
    }

    protected abstract BufferedImage getImage();

    public static SliderObject getObject(String name){
        if (Objects.equals(name, arrowUp)){
            return new ArrowUp();
        } else if (Objects.equals(name, arrowDown)){
            return new ArrowDown();
        } else if (Objects.equals(name, arrowLeft)){
            return new ArrowLeft();
        } else if (Objects.equals(name, arrowRight)){
            return new ArrowRight();
        }
        return null;
    }

    public static abstract class Arrow extends SliderObject {
    }

    public static class ArrowUp extends Arrow{
        @Override
        protected BufferedImage getImage() {
            return Assets.ARROW_UP;
        }

        @Override
        public String getType() {return "arrowUp";}
    }
    public static class ArrowDown extends Arrow{
        @Override
        protected BufferedImage getImage() {
            return Assets.ARROW_DOWN;
        }

        @Override
        public String getType() {return "arrowDown";}
    }
    public static class ArrowLeft extends Arrow{
        @Override
        protected BufferedImage getImage() {
            return Assets.ARROW_LEFT;
        }

        @Override
        public String getType() {return "arrowLeft";}
    }
    public static class ArrowRight extends Arrow{
        @Override
        protected BufferedImage getImage() {
            return Assets.ARROW_RIGHT;
        }

        @Override
        public String getType() {return "arrowRight";}
    }
}
