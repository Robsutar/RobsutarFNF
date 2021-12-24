package com.robsutar.robsutarfnf.RenderableObjects;

import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.MainHandler;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

import java.awt.*;

public class TextBox extends GameObject {
    private Color color;
    private Color wordColor;
    private String word;
    private String subtitle;

    private int count;
    private boolean direction = false;

    public TextBox(int width,int height,String word,String subtitle,Color color) {
        super(Main.WIDTH/2, Main.HEIGHT-height);
        this.width=width;
        this.height=height;
        this.color=color;
        this.word=word;
        this.subtitle=subtitle;
        this.wordColor = new Color(color.getRed()/5,color.getGreen()/5,color.getBlue()/5);
        this.priority= PriorityTypes.TEXT_BOX;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWordColor(Color wordColor) {
        this.wordColor = wordColor;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public void tick() {

        if (count>=100){
            direction=true;
        } else if (count<=0){
            direction=false;
        }

        if (direction){
            setOpacity(getOpacity()+0.0006f);
            count-=1;
        } else {
            setOpacity(getOpacity()-0.0006f);
            count+=1;
        }
    }

    @Override
    public void renderer(Graphics2D g2d) {
        super.renderer(g2d);

        FontMetrics metrics = g2d.getFontMetrics();
        int thickness=5;

        g2d.setColor(color);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,getOpacity()));
        g2d.fillRoundRect((int)getCenterX(),(int)getCenterY(),width,height,height,height);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
        g2d.setColor(wordColor);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRoundRect((int)getCenterX(),(int)getCenterY(),width,height,height,height);
        int x = (int)getX()-metrics.stringWidth(word)/2;
        int y = (int)getY()-metrics.getHeight()/2+metrics.getAscent();
        if (subtitle!=null){
            y-= metrics.getHeight()/4;
        }
        g2d.drawString(word,x,y);
        if (subtitle!=null){
            Font font2 = g2d.getFont().deriveFont(MainHandler.fontSize/1.6f);
            FontMetrics metrics2 = g2d.getFontMetrics(font2);
            g2d.setFont(font2);
            x = (int)getX()-metrics2.stringWidth(subtitle)/2;
            y = (int)getY()-metrics2.getHeight()/2+metrics2.getAscent();
            y += metrics.getHeight()/2.5;
            g2d.drawString(subtitle,x,y);
        }
    }
}
