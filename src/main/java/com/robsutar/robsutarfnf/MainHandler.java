package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Audio.Music;
import com.robsutar.robsutarfnf.Interface.*;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainHandler implements DefaultGraphics {

    private long tim = System.currentTimeMillis();

    public static int maxRenderPriority = 3;

    public static float fontSize = 54;

    private static Music actualMusic;

    public static double bpm = 150;

    private Font font;

    private final ArrayList<ArrayList<Renderable>> renderables;

    private final List<Ticable> ticables = new ArrayList<>();
    private final List<AnimationTicable> animationTicables = new ArrayList<>();
    private final List<MouseInteractive> mouseInteractives = new ArrayList<>();
    private final List<BpmTicable> bpmTicables = new ArrayList<>();
    private final List<KeyboardInteractive> keyboardInteractives = new ArrayList<>();

    private ScheduledExecutorService bpmRunnable;
    private ScheduledExecutorService tickRunnable;
    private ScheduledExecutorService animationTickRunnable;

    public MainHandler(){
        String path = Assets.assetsPath +"font.ttf";
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
        } catch (IOException |FontFormatException e) {
            Assets.failedLoad(path);
        }
        startTick();
        startBpm();
        startAnimationTick();

        ArrayList<ArrayList<Renderable>> rndrList = new ArrayList<>();
        int i = 0;
        while (i<=PriorityTypes.MAX){
            rndrList.add(new ArrayList<>());
            i++;
        }
        renderables = rndrList;
    }

    public void addObject(Ticable o){ticables.add(o);}
    public void addObject(Renderable o){renderables.get(o.getPriority()).add(o);}
    public void addObject(AnimationTicable o){animationTicables.add(o);}
    public void addObject(BpmTicable o){bpmTicables.add(o);}
    public void addObject(MouseInteractive o){mouseInteractives.add(o);}
    public void addObject(KeyboardInteractive o){keyboardInteractives.add(o);}

    public void removeObject(Ticable o) {ticables.remove(o);}
    public void removeObject(Renderable o) {renderables.get(o.getPriority()).remove(o);}
    public void removeObject(AnimationTicable o) {animationTicables.remove(o);}
    public void removeObject(BpmTicable o) {bpmTicables.remove(o);}
    public void removeObject(MouseInteractive o) {mouseInteractives.remove(o);}
    public void removeObject(KeyboardInteractive o){keyboardInteractives.remove(o);}

    public void startTick(){
        if (tickRunnable!=null){
            this.tickRunnable.shutdown();
        }
        this.tickRunnable=Executors.newSingleThreadScheduledExecutor();
        this.tickRunnable.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                tick();
            }
        }, 0, 20, TimeUnit.MILLISECONDS);
    }
    public void startBpm(){
        if (bpmRunnable!=null){
            this.bpmRunnable.shutdown();
        }

        this.bpmRunnable=Executors.newSingleThreadScheduledExecutor();
        this.bpmRunnable.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                bpmTick();
            }
        }, 0, (long) ((1000000000*60d)/(bpm*16)), TimeUnit.NANOSECONDS);
    }
    public void startAnimationTick(){
        if (animationTickRunnable!=null){
            this.animationTickRunnable.shutdown();
        }
        this.animationTickRunnable=Executors.newSingleThreadScheduledExecutor();
        this.animationTickRunnable.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                animationTick();
            }
        }, 0, (long) ((1000000000*60d)/(bpm*15)), TimeUnit.NANOSECONDS);
    }

    public void setActualMusic(Music music){
        actualMusic=music;
        bpm = actualMusic.getBpm();
        startBpm();
        startAnimationTick();
        music.start();
    }

    public void renderer(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform at = g2d.getTransform();

        g2d.setFont(font.deriveFont(fontSize));

        ArrayList<ArrayList<Renderable>> renderables = new ArrayList<>(this.renderables);

        for (int x = 0; x<renderables.toArray().length;x++){
            for (int y = 0; y<renderables.get(x).toArray().length;y++){
                renderables.get(x).get(y).renderer(g2d);

                g2d.setColor(color);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.setStroke(new BasicStroke(2));

                g2d.setTransform(at);
            }
        }

        /*
        renderables.sort(comparator);
        for (int z = 0; z<renderables.toArray().length;z++){
            if (!renderables.isEmpty()) {

                renderables.get(0).renderer(g2d);

                Collections.rotate(renderables, 1);

                g2d.setColor(color);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.setStroke(new BasicStroke(2));

                g2d.setTransform(at);
            }
        }

         */
    }
    public void tick(){
        for (int z = 0; z<ticables.toArray().length;z++){
            if (!ticables.isEmpty()) {
                ticables.get(0).tick();
                Collections.rotate(ticables, 1);
            }
        }
    }
    public void animationTick(){

        for (int z = 0; z<animationTicables.toArray().length;z++){
            if (!animationTicables.isEmpty()) {
                animationTicables.get(0).animationTick();
                Collections.rotate(animationTicables, 1);
            }
        }
    }

    public void bpmTick(){
        for (int z = 0; z<bpmTicables.toArray().length;z++){
            if (!bpmTicables.isEmpty()) {
                bpmTicables.get(0).bpmTick();
                Collections.rotate(bpmTicables, 1);
            }
        }
    }

    public void mousePressed(MouseEvent e){
        for (int z = 0; z<mouseInteractives.toArray().length;z++){
            if (!mouseInteractives.isEmpty()) {
                mouseInteractives.get(0).mousePressed();
                Collections.rotate(mouseInteractives, 1);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        for (int z = 0; z<mouseInteractives.toArray().length;z++){
            if (!mouseInteractives.isEmpty()) {
                mouseInteractives.get(0).mouseReleased();
                Collections.rotate(mouseInteractives, 1);
            }
        }
    }

    public void mouseDragged(MouseEvent e, int xDistance , int yDistance) {
        for (int z = 0; z<mouseInteractives.toArray().length;z++){
            if (!mouseInteractives.isEmpty()) {
                mouseInteractives.get(0).mouseDragged(xDistance,yDistance);
                Collections.rotate(mouseInteractives, 1);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        for (int z = 0; z<keyboardInteractives.toArray().length;z++){
            if (!keyboardInteractives.isEmpty()) {
                keyboardInteractives.get(0).keyPressed(e);
                Collections.rotate(keyboardInteractives, 1);
            }
        }
    }
}
