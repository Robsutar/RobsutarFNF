package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.Interfaces.*;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainHandler {
    List<Renderable> renderables = new ArrayList<>();
    List<BpmTicable> bpmTicables = new ArrayList<>();
    List<MouseInteractive> mouseInteractives = new ArrayList<>();
    List<Ticable> ticables = new ArrayList<>();
    List<WASDInteractive> wasd = new ArrayList<>();

    public void addObject(Renderable object){
        renderables.add(object);
    }
    public void removeObject(Renderable object){
        renderables.remove(object);
    }

    public void addObject(BpmTicable object){
        bpmTicables.add(object);
    }
    public void removeObject(BpmTicable object){
        bpmTicables.remove(object);
    }

    public void addObject(MouseInteractive object){
        mouseInteractives.add(object);
    }
    public void removeObject(MouseInteractive object){
        mouseInteractives.remove(object);
    }

    public void addObject(Ticable object){
        ticables.add(object);
    }
    public void removeObject(Ticable object){
        ticables.remove(object);
    }

    public void addObject(WASDInteractive object){
        wasd.add(object);
    }
    public void removeObject(WASDInteractive object){
        wasd.remove(object);
    }

    public void renderer(Graphics2D g){
        for (Renderable r:renderables){
            g.setColor(Color.white);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            g.setFont(Main.staticAssets.FONT);
            r.render(g);
        }
    }
    public void bpmTick(){
        for (BpmTicable r:bpmTicables){
            r.bpmTick();
        }
    }
    public void tick(){
        for (Ticable r:ticables){
            r.tick();
        }
    }
    public void mousePressed(MouseEvent e){
        for (MouseInteractive r:mouseInteractives){
            r.mousePressed(e);
        }
    }
    public void mouseReleased(MouseEvent e){
        for (MouseInteractive r:mouseInteractives){
            r.mouseReleased(e);
        }
    }
    public void keyPressed(KeyEvent e){
        for (WASDInteractive r:wasd){
            if (e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
                r.wPressed();
            } else if (e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
                r.aPressed();
            } else if (e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
                r.sPressed();
            } else if (e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
                r.dPressed();
            } else;
        }
    }
}
