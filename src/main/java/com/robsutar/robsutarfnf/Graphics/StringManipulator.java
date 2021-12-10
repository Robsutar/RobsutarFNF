package com.robsutar.robsutarfnf.Graphics;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;

public class StringManipulator {
    public static void drawCenteredString(Graphics2D g, String text, int x, int y,float opacity){
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        drawCenteredString(g,text,x,y);
    }

    public static void drawCenteredString(Graphics2D g, String text, int x, int y,int width, int height){
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        // Determine the X coordinate for the text
        x+=(width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        y += ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Draw the String
        g.drawString(text, x, y);
    }
    public static void drawCenteredString(Graphics2D g, String text, int x, int y) {
        g.setColor(Color.cyan);
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        // Determine the X coordinate for the text
        x -= metrics.stringWidth(text) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        y -= metrics.getHeight()/2;
        // Draw the String
        g.drawString(text, x, y);
    }
}
