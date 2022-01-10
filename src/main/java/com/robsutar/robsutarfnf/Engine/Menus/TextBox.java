package com.robsutar.robsutarfnf.Engine.Menus;

import com.robsutar.robsutarfnf.Engine.Box;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Renderable.SimpleRenderable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TextBox extends SimpleRenderable {
    private Color color;
    public String text;
    protected float fontSize = Handler.fontSize;
    private String textIntoRect;
    private double distanceToBorder = 0.8;
    private int maxTextWidth;

    public TextBox(Box anchor,String text, Color textColor){
        this.text=text;
        this.color=textColor;
        setBounds(anchor.width,anchor.height);
    }

    private BufferedImage textToImage(String text,int width, int height){
        if (height>this.height*distanceToBorder){
            height= (int) (this.height*distanceToBorder);
        }
        BufferedImage img = new BufferedImage(1,1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = Handler.font.deriveFont(fontSize);
        g2d.setFont(font);
        g2d.dispose();

        img = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        g2d.setColor(color);

        FontMetrics metrics = g2d.getFontMetrics();
        if (textIntoRect ==null){
            textIntoRect = textIntoRect(text,metrics);
        }
        int h = metrics.getHeight();
        String[] lines = textIntoRect.split("\n");
        for (int i = 0; i <lines.length;i++){
            String s = lines[i];
            int space = (width- metrics.stringWidth(s))/2;
            g2d.drawString(s,space,h*(i+1)-metrics.getAscent()/2);
        }

        g2d.dispose();
        return img;
    }

    private String textIntoRect(String text, FontMetrics metrics){
        String[] words = text.split(" ");
        if (words.length==0){return  text;}

        List<String> lines = new ArrayList<>();
        String actualLine = "";
        String tempString = "";

        for (int i = 0;i<words.length;i++){
            tempString+=words[i]+" ";
            int width = metrics.stringWidth(tempString);
            if (width>= this.width*distanceToBorder){
                tempString = words[i]+" ";
                lines.add(actualLine);
                if (i+1 == words.length){
                    lines.add(tempString);
                }
            } else {
                if (this.maxTextWidth<width){
                    this.maxTextWidth=width;
                }
                actualLine = tempString;
                if (i+1 == words.length){
                    lines.add(actualLine);
                }
            }
        }
        String outString = "";

        for (String s:lines){
            outString+=s+"\n";
        }
        return outString;
    }

    @Override
    public void renderDrawImage(Graphics2D g2d) {
        if (image!=null) {
            int x = (width-image.getWidth())/2+width/2;
            int y = (height-image.getHeight())/2+height/2;
            g2d.drawImage(image,x,y,null);
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
        if (textIntoRect==null){

            textIntoRect = textIntoRect(text,g2d.getFontMetrics());
            image = textToImage(textIntoRect,maxTextWidth,g2d.getFontMetrics().getHeight()*(textIntoRect.split("\n").length));
        }
    }
}
