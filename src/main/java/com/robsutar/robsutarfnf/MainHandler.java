package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Audio.Music;
import com.robsutar.robsutarfnf.Comparators.RenderableComparator;
import com.robsutar.robsutarfnf.Interface.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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

    private final List<Ticable> ticables = new ArrayList<>();
    private final List<Renderable> renderables = new ArrayList<>();
    private final List<AnimationTicable> animationTicables = new ArrayList<>();
    private final List<MouseInteractive> mouseInteractives = new ArrayList<>();
    private final List<BpmTicable> bpmTicables = new ArrayList<>();

    RenderableComparator comparator = new RenderableComparator();

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
    }

    public void addObject(Ticable o){ticables.add(o);}
    public void addObject(Renderable o){renderables.add(o);}
    public void addObject(AnimationTicable o){animationTicables.add(o);}
    public void addObject(BpmTicable o){bpmTicables.add(o);}
    public void addObject(MouseInteractive o){mouseInteractives.add(o);}

    public void removeObject(Ticable o) {ticables.remove(o);}
    public void removeObject(Renderable o) {renderables.remove(o);}
    public void removeObject(AnimationTicable o) {animationTicables.remove(o);}
    public void removeObject(BpmTicable o) {bpmTicables.remove(o);}
    public void removeObject(MouseInteractive o) {mouseInteractives.remove(o);}

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
        g2d.setFont(font.deriveFont(fontSize));

        List<Renderable> renderables = new ArrayList<>(this.renderables);
        renderables.sort(comparator);
        for (int z = 0; z<renderables.toArray().length;z++){
            if (!renderables.isEmpty()) {
                Collections.rotate(renderables, 1);
                g2d.setColor(color);
                g2d.scale(scale, scale);
                g2d.rotate(Math.toRadians(rotation));
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
                g2d.setStroke(new BasicStroke(2));
                renderables.get(0).renderer(g2d);
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
    }
    public void animationTick(){
        if (!animationTicables.isEmpty()) {
            for (int z = 0; z< animationTicables.toArray().length; z++){
                animationTicables.get(0).animationTick();
                Collections.rotate(animationTicables,1);
            }
        }
    }

    public void bpmTick(){
        if (!bpmTicables.isEmpty()){
            for (int z = 0; z< bpmTicables.toArray().length; z++){
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
