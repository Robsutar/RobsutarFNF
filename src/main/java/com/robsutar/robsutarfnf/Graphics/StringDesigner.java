package com.robsutar.robsutarfnf.Graphics;

import java.awt.*;
import java.util.Random;

public interface StringDesigner {
    default String formatText(String text){
        int z = 0;
        StringBuilder fullText =new StringBuilder(text);
        while (z<fullText.length()){
            if (fullText.charAt(z)=='&') {
                fullText.deleteCharAt(z);
                if(z >= fullText.length()) {
                    break;
                }
                if(Character.isDigit(fullText.charAt(z))||fullText.charAt(z)=='#') {
                    fullText.deleteCharAt(z);
                }
            }
            z++;
        }
        return fullText.toString();
    }

    default void drawString(Graphics2D g2d, String text, int xMiddle, int yMiddle){
        char[] chars = text.toCharArray();

        FontMetrics metrics = g2d.getFontMetrics();

        String writtenString = "";

        String fullText = formatText(text);

        boolean checkColor = false;

        for (int i = 0; i < chars.length;i++){
            char c =chars[i];
            if (c=='&'){
                checkColor=true;
            } else {
                if (checkColor){
                    checkColor=false;
                    switch (c){
                        case '0':g2d.setColor(Color.white);continue;
                        case '1':g2d.setColor(Color.red);continue;
                        case '2':g2d.setColor(Color.orange);continue;
                        case '3':g2d.setColor(Color.yellow);continue;
                        case '4':g2d.setColor(Color.green);continue;
                        case '5':g2d.setColor(Color.cyan);continue;
                        case '6':g2d.setColor(Color.blue);continue;
                        case '7':g2d.setColor(Color.magenta);continue;
                        case '8':g2d.setColor(Color.pink);continue;
                        case '9':g2d.setColor(Color.black);continue;
                        case '#':
                            g2d.setColor(RainbowColor.rainbowColor(i*10));
                            continue;
                    }
                }
                int x = xMiddle+metrics.stringWidth(writtenString)-metrics.stringWidth(fullText)/2;
                int y = yMiddle-(metrics.getHeight()/2-metrics.getAscent());

                g2d.drawString(String.valueOf(c),x,y);
                writtenString = writtenString + c;
            }
        }
    }
}
