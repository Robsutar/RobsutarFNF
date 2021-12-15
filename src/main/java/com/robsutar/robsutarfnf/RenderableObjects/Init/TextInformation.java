package com.robsutar.robsutarfnf.RenderableObjects.Init;

import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.MainHandler;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextInformation extends RenderableObject {
    private int age = 0;
    private String biggestLine = "";

    private final List<String> lines = new ArrayList<>();

    private final List<List<Character>> charList = new ArrayList<>();
    private final List<List<Color>> colorList = new ArrayList<>();

    public TextInformation(String[] str, BufferedImage img) {
        super(Main.WIDTH/2,Main.HEIGHT/2,img);
        setPriority(MainHandler.maxRenderPriority);
        List<String> splittedLines = Arrays.asList(str);
        if (!splittedLines.isEmpty()){
            for (int z = 0; z < splittedLines.toArray().length;z++){
                String s = splittedLines.get(z);
                StringBuilder finalLine = new StringBuilder();
                Color color = Color.white;

                if (s.length()>biggestLine.length()){
                    biggestLine=s;
                }

                char[] charinLines = s.toCharArray();
                boolean hasColor = false;

                List<Color> cs = new ArrayList<>();
                List<Character> chra = new ArrayList<>();
                for (char c : charinLines) {
                    if(c == '&') {
                        hasColor = true;
                    } else {
                        if(hasColor) {
                            hasColor = false;
                            switch (c) {
                                case '0':
                                    color = Color.black;
                                    break;
                                case '1':
                                    color = Color.orange;
                                    break;
                                case '2':
                                    color = Color.yellow;
                                    break;
                                case '3':
                                    color = Color.red;
                                    break;
                                case '4':
                                    color = Color.green;
                                    break;
                                case '5':
                                    color = Color.pink;
                                    break;
                                case '6':
                                    color = Color.gray;
                                    break;
                                case '7':
                                    color = Color.cyan;
                                    break;
                                case '8':
                                    color = Color.blue;
                                    break;
                                case '9':
                                    color = Color.white;
                                    break;
                            }
                        } else {
                            cs.add(color);
                            chra.add(c);
                            finalLine.append(c);
                        }
                    }
                }
                charList.add(chra);
                colorList.add(cs);
                lines.add(finalLine.toString());
            }
        }
        System.out.println(biggestLine);
    }

    @Override
    protected void onTick() {
        age++;
        setLocation(Main.xMouse,Main.yMouse);
        if (age>200){
            //setOpacity(getOpacity()-0.01f);
        }
    }

    @Override
    protected void onRenderer(Graphics2D g2d) {
        super.onRenderer(g2d);
        if (!(lines.isEmpty()||charList.isEmpty())){
            FontMetrics metrics = g2d.getFontMetrics();
            int y = (int) (getY()+(-metrics.getHeight()) / 2) + metrics.getAscent();

            g2d.setColor(Color.red);
            g2d.fillRect((int) (getX()- metrics.stringWidth(biggestLine)/2),(int)getY()-(metrics.getHeight()*lines.toArray().length)/2,
                    metrics.stringWidth(biggestLine),(int) getY()+(metrics.getHeight()*lines.toArray().length)/2 );

            List<String> lines = this.lines;
            List<List<Character>> charList = this.charList;
            List<List<Color>> colorList = this.colorList;
            for (int i = 0; i < lines.toArray().length;i++){
                String writtenString = "";
                for (int z = 0; z < charList.get(0).toArray().length;z++) {
                    int x = (int) (getX()+(metrics.stringWidth(writtenString)-metrics.stringWidth(lines.get(0))/2));
                    /*
                    g2d.setColor(Color.red);
                    g2d.fillRect(x,y- metrics.getHeight()/2-metrics.getAscent()/2,metrics.charWidth(charList.get(0).get(0)), metrics.getHeight());

                     */
                    g2d.setColor(colorList.get(0).get(0));
                    g2d.drawString(String.valueOf(charList.get(0).get(0)), x, y);
                    writtenString= writtenString+charList.get(0).get(0);
                    Collections.rotate(charList.get(0),-1);
                    Collections.rotate(colorList.get(0),-1);
                }
                Collections.rotate(lines,-1);
                Collections.rotate(charList,-1);
                Collections.rotate(colorList,-1);
                y+= metrics.getHeight();
            }
        }
    }
}
