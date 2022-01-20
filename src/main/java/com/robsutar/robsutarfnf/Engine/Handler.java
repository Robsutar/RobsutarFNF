package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Renderable.init.VolumeViewer;
import com.robsutar.robsutarfnf.Engine.Graphics.Camera;
import com.robsutar.robsutarfnf.Engine.Settings.GameSettings;
import com.robsutar.robsutarfnf.Engine.Threads.*;
import com.robsutar.robsutarfnf.Engine.Window.GamePanel;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Handler {

    private static ArrayList<ArrayList<Renderable>> renderables = fillList();
    private static List<Ticable> ticables = new ArrayList<>();
    private static List<BpmTicable> bpmTicables = new ArrayList<>();
    private static List<AnimationTicable> animationTicables = new ArrayList<>();
    private static List<MouseInteractive> mouseInteractives = new ArrayList<>();
    private static List<KeyboardInteractive> keyboardInteractives = new ArrayList<>();
    private static List<FloatControl> audios = new ArrayList<>();

    public static final Camera camera = new Camera();

    public static Point mousePosition = GamePanel.mouse;

    public static Font font = Assets.HEAVY_FONT;
    public static FontMetrics metrics;

    public static int bpmAge = 0;
    public static float volume=40;
    public static float fontSize=32;

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

    public static void addObject(KeyboardInteractive object) {keyboardInteractives.add(object);}
    public static void removeObject(KeyboardInteractive object) {keyboardInteractives.remove(object);}

    public static void addObject(FloatControl object) {audios.add(object);}
    public static void removeObject(FloatControl object) {audios.remove(object);}

    public static void addObject(Component component){getPanel().add(component);}
    public static void removeObject(Component component){getPanel().remove(component);}

    public static GamePanel getPanel(){return WindowGame.panel;}

    public static WindowGame getWindow(){return WindowGame.frame;}

    private static ArrayList<ArrayList<Renderable>> fillList(){
        ArrayList<ArrayList<Renderable>> rnds = new ArrayList<>();
        for (int i = 0;i<=Renderable.MAX_PRIORITY;i++){
            rnds.add(new ArrayList<>());
        }
        return rnds;
    }

    public static void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);

        font = new Font("Dialog", Font.PLAIN, (int) fontSize);;
        resetGraphics(g2d);
        metrics=g2d.getFontMetrics();

        if (GamePanel.mouse!=null) {
            mousePosition = GamePanel.mouse;
            mousePosition.x -= Camera.getCamera().getX();
            mousePosition.y -= Camera.getCamera().getY();
            mousePosition = Camera.getCamera().getScaledPoint(mousePosition);
        }

        ArrayList<ArrayList<Renderable>> renderables = new ArrayList<>(Handler.renderables);

        for (int i = 0; i <renderables.toArray().length;i++){
            ArrayList<Renderable> rList = new ArrayList<>(renderables.get(i));
            for (Renderable r:rList){

                resetGraphics(g2d);
                if (r.affectedByCamera()){
                    camera.render(g2d);
                }

                r.render(g2d);
            }
        }
        resetGraphics(g2d);
    }

    private static void resetGraphics(Graphics2D g2d){
        g2d.setFont(font);
        g2d.setTransform(new AffineTransform());
        g2d.setColor(WindowGame.panel.getBackground());
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
        g2d.setStroke(new BasicStroke(GameSettings.THICKNESS));
    }

    public static void setBpm(float bpm){
        GamePanel.setBpm(bpm);
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
        if (bpmAge>16){
            bpmAge=1;
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
    public static void mouseDragged(MouseEvent e, int xDistance, int yDistance) {
        List<MouseInteractive> mouseInteractives = new ArrayList<>(Handler.mouseInteractives);
        for (MouseInteractive o:mouseInteractives){
            o.mouseDragged(xDistance,yDistance);
        }
    }
    public static void keyPressed(KeyEvent e) {
        List<KeyboardInteractive> keyboardInteractives = new ArrayList<>(Handler.keyboardInteractives);
        for (KeyboardInteractive o:keyboardInteractives){
            o.keyPressed(e);
        }
    }

    public static void keyTyped(KeyEvent e) {
        List<KeyboardInteractive> keyboardInteractives = new ArrayList<>(Handler.keyboardInteractives);
        for (KeyboardInteractive o:keyboardInteractives){
            o.keyTyped(e);
        }
    }

    public static float getValidVolume(float max85){
        return max85-80;
    }

    public static void setVolume(float max85){
        if (max85>85f){
            max85=85f;
        } else if(max85<0f){
            max85=0;
        }
        volume=max85;
        if (volume%5==0) {
            for (FloatControl fc : audios) {
                fc.setValue(getValidVolume(volume));
            }
            VolumeViewer.request();
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
