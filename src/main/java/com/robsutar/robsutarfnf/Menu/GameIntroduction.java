package com.robsutar.robsutarfnf.Menu;

import com.robsutar.robsutarfnf.Interface.BpmTicable;
import com.robsutar.robsutarfnf.Interface.Renderable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.MainHandler;

import java.awt.*;

public class GameIntroduction implements BpmTicable, Renderable {
    private int bpmAge;
    private int stringLength = 0;
    private String string= "Robsutar";
    private float opacity = 0;
    public GameIntroduction(){
        spawnBpm();
        spawnRender();
    }

    @Override
    public void bpmTick() {
        bpmAge++;
        if (opacity+0.05f<=1) {
            opacity += 0.05f;
        }
        if (bpmAge%15==0){
            if (stringLength+1<=string.length()) {
                stringLength++;
            }
            if (stringLength+1<=string.length()) {
                stringLength++;
            }
        }
        if (bpmAge==50){

        }
    }

    @Override
    public void renderer(Graphics2D g2d, byte priority) {
        if (priority== MainHandler.maxRenderPriority){
            char[] chars = string.toCharArray();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));
            g2d.setFont(g2d.getFont().deriveFont(128f));
            FontMetrics metrics = g2d.getFontMetrics();
            String writtenString = "";
            System.out.println(stringLength);
            int x = Main.WIDTH / 2;
            for(int i = 0; i < stringLength;i++) {
                char c=chars[i];
                g2d.drawString(String.valueOf(c), x - (metrics.stringWidth(string))/ 2+ metrics.stringWidth(writtenString), Main.HEIGHT / 2);
                writtenString = writtenString+ c;
            }
        }
    }
}
