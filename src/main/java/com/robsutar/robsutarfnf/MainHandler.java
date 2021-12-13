package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Graphics.StringManipulator;
import com.robsutar.robsutarfnf.Interface.*;
import com.robsutar.robsutarfnf.RenderableObjects.Init.TextInformation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
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
        if (!renderables.isEmpty()) {
            for (byte i = 0; i <= maxRenderPriority; i++) {
                for (int z = 0; z<renderables.toArray().length;z++){
                    renderables.get(0).renderer(g2d, i);
                    Collections.rotate(renderables,1);
                }
            }
        }
    }
    public void tick(){
        if (!ticables.isEmpty()) {
            for (int z = 0; z<ticables.toArray().length;z++){
                ticables.get(0).tick();
                Collections.rotate(ticables,1);
            }
        }
        while(System.currentTimeMillis() - tim > 1000.0/(Main.bpm/60.0)/15) {
            tim += 1000.0/(Main.bpm/60.0)/15;
            bpmTick();
        }
    }
    public void bpmTick(){
        if (!bpmTicables.isEmpty()) {
            for (int z = 0; z<bpmTicables.toArray().length;z++){
                bpmTicables.get(0).bpmTick();
                Collections.rotate(bpmTicables,1);
            }
        }
    }

    public void mousePressed(MouseEvent e){
        if (!mouseInteractives.isEmpty()) {
            for (int z = 0; z<mouseInteractives.toArray().length;z++){
                mouseInteractives.get(0).mousePressed();
                Collections.rotate(mouseInteractives,1);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (!mouseInteractives.isEmpty()) {
            for (int z = 0; z<mouseInteractives.toArray().length;z++){
                mouseInteractives.get(0).mouseReleased();
                Collections.rotate(mouseInteractives,1);
            }
        }
    }

    public void keyPressed(KeyEvent e) {

    }
}
