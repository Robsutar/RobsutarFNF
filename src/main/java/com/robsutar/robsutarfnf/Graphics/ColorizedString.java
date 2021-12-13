package com.robsutar.robsutarfnf.Graphics;

import com.robsutar.robsutarfnf.MainHandler;

import java.awt.*;
import java.util.List;

public class ColorizedString {
    private final String[] strings;
    private final Color[] colors;
    private final String fullString;
    public ColorizedString(String str){
        String[] byColor = str.split("&");
        Color[] colors = new Color[byColor.length];
        String fullString="";

        for (int i = 0; i < byColor.length;i++){
            String s = byColor[i];
            if (s.length()>0) {
                Color color = Color.white;
                switch (s.charAt(0)){
                    case '0': color = Color.black;break;
                    case '1': color = Color.orange;break;
                    case '2': color = Color.yellow;break;
                    case '3': color = Color.red;break;
                    case '4': color = Color.green;break;
                    case '5': color = Color.pink;break;
                    case '6': color = Color.gray;break;
                    case '7': color = Color.cyan;break;
                    case '8': color = Color.blue;break;
                    case '9': color = Color.white;break;
                }
                colors[i] = color;
                String subString = byColor[i].substring(1);
                byColor[i]=subString;
                fullString=fullString+subString;
            }
        }
        strings=byColor;
        this.colors=colors;
        this.fullString=fullString;
    }

    public String[] getStrings() {
        return strings;
    }

    public Color[] getColors() {
        return colors;
    }

    public String getFullString() {
        return fullString;
    }
}
