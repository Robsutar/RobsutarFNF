package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Graphics.Camera;
import com.robsutar.robsutarfnf.Threads.*;
import com.robsutar.robsutarfnf.Window.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class Handler {

    private static ArrayList<ArrayList<Renderable>> renderables = fillList();
    private static List<Ticable> ticables = new ArrayList<>();
    private static List<BpmTicable> bpmTicables = new ArrayList<>();
    private static List<AnimationTicable> animationTicables = new ArrayList<>();
    private static List<MouseInteractive> mouseInteractives = new ArrayList<>();

    public static final Camera camera = new Camera();
    public static void addObject(Renderable object) {renderables.get(object.getPriority()).add(object);}

    public static void removeObject(Renderable object) {renderables.get(object.getPriority()).remove(object);}
    public static void addObject(Ticable object) {ticables.add(object);}

    public static void removeObject(Ticable object) {ticables.remove(object);}
    public static void addObject(BpmTicable object) {bpmTicables.add(object);}

    public static void removeObject(BpmTicable object) {bpmTicables.remove(object);}
    public static void addObject(AnimationTicable object) {animationTicables.add(object);}

    public static void removeObject(AnimationTicable object) {animationTicables.remove(object);}
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

    private static int bpmAge = 0;
    private static int animationAge = 0;

    public static void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);

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
        if (bpmAge>=16){
            bpmAge=0;
        }
        for (BpmTicable o:bpmTicables){
            o.bpmTick(bpmAge);
        }
        bpmAge++;
    }
    public static void animationTick() {
        List<AnimationTicable> animationTicables = new ArrayList<>(Handler.animationTicables);
        for (AnimationTicable o:animationTicables){
            o.animationTick();
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

    public static void killEveryObject(){
        renderables= new ArrayList<>();
        ticables= new ArrayList<>();
        bpmTicables= new ArrayList<>();
        animationTicables= new ArrayList<>();
        mouseInteractives= new ArrayList<>();
    }
}
