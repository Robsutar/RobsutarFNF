package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Graphics.Camera;
import com.robsutar.robsutarfnf.Threads.BpmTicable;
import com.robsutar.robsutarfnf.Threads.MouseInteractive;
import com.robsutar.robsutarfnf.Threads.Renderable;
import com.robsutar.robsutarfnf.Threads.Ticable;
import com.robsutar.robsutarfnf.Window.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Handler {

    private static final ArrayList<ArrayList<Renderable>> renderables = fillList();
    private static final List<Ticable> ticables = new ArrayList<>();
    private static final List<BpmTicable> bpmTicables = new ArrayList<>();
    private static final List<MouseInteractive> mouseInteractives = new ArrayList<>();

    public static final Camera camera = new Camera();

    public static void addObject(Renderable object) {renderables.get(object.getPriority()).add(object);}
    public static void removeObject(Renderable object) {renderables.get(object.getPriority()).remove(object);}

    public static void addObject(Ticable object) {ticables.add(object);}
    public static void removeObject(Ticable object) {ticables.remove(object);}

    public static void addObject(BpmTicable object) {bpmTicables.add(object);}
    public static void removeObject(BpmTicable object) {bpmTicables.remove(object);}

    public static void addObject(MouseInteractive object) {mouseInteractives.add(object);}
    public static void removeObject(MouseInteractive object) {mouseInteractives.remove(object);}

    private static ArrayList<ArrayList<Renderable>> fillList(){
        ArrayList<ArrayList<Renderable>> rnds = new ArrayList<>();
        for (int i = 0;i<=Renderable.MAX_PRIORITY;i++){
            rnds.add(new ArrayList<>());
        }
        return rnds;
    }

    public static Point mousePosition = GamePanel.mouse;

    public static void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHints(rh);

        AffineTransform at = new AffineTransform();
        Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f);
        BasicStroke stroke = new BasicStroke(5);
        Color color = Color.white;

        ArrayList<ArrayList<Renderable>> renderables = new ArrayList<>(Handler.renderables);

        if (GamePanel.mouse!=null) {
            mousePosition = GamePanel.mouse;
            mousePosition.x -= Camera.getCamera().getX();
            mousePosition.y -= Camera.getCamera().getY();
            mousePosition = Camera.getCamera().getScaledPoint(mousePosition);
        }

        for (ArrayList<Renderable> rList:renderables){
            for (Renderable r:rList){

                g2d.setTransform(at);
                g2d.setColor(color);
                g2d.setComposite(comp);
                g2d.setStroke(stroke);

                if (r.affectedByCamera()){
                    camera.render(g2d);
                }

                r.render(g2d);
            }
        }
    }

    public static void tick(){
        camera.tick();

        List<Ticable> ticables = new ArrayList<>(Handler.ticables);
        for(Ticable o:ticables){
            o.tick();
        }
    }
    public static void bpmTick(){
        List<BpmTicable> bpmTicables = new ArrayList<>(Handler.bpmTicables);
        for (BpmTicable o:bpmTicables){
            o.bpmTick();
        }
    }
    public static void mouseClicked(MouseEvent e) {
        List<MouseInteractive> mouseInteractives = new ArrayList<>(Handler.mouseInteractives);
        for (MouseInteractive o:mouseInteractives){
            o.mouseClicked();
        }
    }
    public static void mousePressed(MouseEvent e) {
        List<MouseInteractive> mouseInteractives = new ArrayList<>(Handler.mouseInteractives);
        for (MouseInteractive o:mouseInteractives){
            o.mousePressed();
        }
    }
    public static void mouseReleased(MouseEvent e) {
        List<MouseInteractive> mouseInteractives = new ArrayList<>(Handler.mouseInteractives);
        for (MouseInteractive o:mouseInteractives){
            o.mouseReleased();
        }
    }
}
