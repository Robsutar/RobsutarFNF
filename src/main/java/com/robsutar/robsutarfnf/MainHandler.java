package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Interface.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainHandler implements DefaultGraphics {

    private long tim = System.currentTimeMillis();

    public static byte maxRenderPriority = 3;

    private List<Ticable> ticables = new ArrayList<>();
    private List<Renderable> renderables = new ArrayList<>();
    private List<BpmTicable> bpmTicables = new ArrayList<>();
    private List<MouseInteractive> mouseInteractives = new ArrayList<>();

    public MainHandler(){
        
    }

    public void addObject(Ticable o){ticables.add(o);}
    public void addObject(Renderable o){renderables.add(o);}
    public void addObject(BpmTicable o){bpmTicables.add(o);}
    public void addObject(MouseInteractive o){mouseInteractives.add(o);}

    public void removeObject(Ticable o) {ticables.remove(o);}
    public void removeObject(Renderable o) {renderables.remove(o);}
    public void removeObject(BpmTicable o) {bpmTicables.remove(o);}
    public void removeObject(MouseInteractive o) {mouseInteractives.remove(o);}

    public void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.scale(scale,scale);
        g2d.rotate(rotation);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacity));
        for (byte i = 0;i<=maxRenderPriority;i++) {
            for (Renderable o : renderables
            ) {
                o.renderer(g2d,i);
            }
        }
    }
    public void tick(){
        for (Ticable o:ticables
        ) {
            o.tick();
        }
        while(System.currentTimeMillis() - tim > 1000.0/(Main.bpm/60.0)/15) {
            tim += 1000.0/(Main.bpm/60.0)/15;
            bpmTick();
        }
    }
    public void bpmTick(){
        for (BpmTicable o:bpmTicables
        ) {
            o.bpmTick();
        }
    }

    public void mousePressed(MouseEvent e){
        for (MouseInteractive o:mouseInteractives
        ) {
            o.mousePressed();
        }
    }

    public void mouseReleased(MouseEvent e) {
        for (MouseInteractive o:mouseInteractives
        ) {
            o.mouseReleased();
        }
    }

    public void keyPressed(KeyEvent e) {

    }
}
