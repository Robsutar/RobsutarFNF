package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.Frame.Camera;
import com.robsutar.robsutarfnf.Frame.GameFrame;
import com.robsutar.robsutarfnf.Interfaces.BpmTicable;
import com.robsutar.robsutarfnf.Interfaces.MouseInteractive;
import com.robsutar.robsutarfnf.Interfaces.Ticable;
import com.robsutar.robsutarfnf.RenderableObjects.Position;
import com.robsutar.robsutarfnf.RenderableObjects.Renderable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainHandler {
    List<Renderable> renderables = new ArrayList<>();
    List<BpmTicable> bpmTicables = new ArrayList<>();
    List<MouseInteractive> mouseInteractives = new ArrayList<>();
    List<Ticable> ticables = new ArrayList<>();
    public Camera mainCamera = new Camera();

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

    public void renderer(Graphics2D g2d){
        g2d.rotate(Math.toRadians(mainCamera.getRotation()), GameFrame.width()/2.0,GameFrame.height()/2.0);
        g2d.translate(mainCamera.getX(), mainCamera.getY());
        g2d.scale(mainCamera.getScale(),mainCamera.getScale());
        for (Renderable r:renderables){
            r.renderer(g2d);
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
}
