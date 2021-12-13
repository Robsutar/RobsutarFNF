package com.robsutar.robsutarfnf.Graphics;

import java.awt.*;
import java.util.Locale;

public class StringManipulator {
    public static void drawCenteredString(Graphics2D g2d, String text, Rectangle rect) {
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g2d.drawString(text,x,y);
    }
    public static void drawCenteredString(Graphics2D g2d, ColorizedString colorString,Rectangle rect) {
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        int x = rect.x + (rect.width - metrics.stringWidth(colorString.getFullString())) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        String lastString = "";
        for (int i = 0;i< colorString.getStrings().length;i++){
            g2d.setColor(colorString.getColors()[i]);
            g2d.drawString(colorString.getStrings()[i],x+metrics.stringWidth(lastString),y);
            lastString= lastString+colorString.getStrings()[i];
        }
    }
}
