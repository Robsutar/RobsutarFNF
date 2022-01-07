package com.robsutar.robsutarfnf.Window;

import com.robsutar.robsutarfnf.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements KeyListener, MouseListener {

    public int fps = 60;
    private float bpm = 100;

    public static Point mouse = new Point(Window.wdt()/2,Window.hgt()/2);

    public GamePanel() {

        this.setFocusable(true);

        Thread renderer = new Thread(new Runnable() {
            @Override
            public void run() {
                long fpsTime = (long) ((1000.0 / fps) * 1000000.0);
                long now = 0;
                long total = 0;
                while (true) {
                    now = System.nanoTime();
                    repaint();
                    try {
                        total = System.nanoTime() - now;
                        if(total > fpsTime) {
                            continue;
                        }
                        Thread.sleep((fpsTime - (System.nanoTime() - now)) / 1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        renderer.start();

        ScheduledExecutorService tick = Executors.newSingleThreadScheduledExecutor();
        tick.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Handler.tick();
            }
        }, 0, 10, TimeUnit.MILLISECONDS);

        ScheduledExecutorService bpmTick = Executors.newSingleThreadScheduledExecutor();
        bpmTick.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Handler.bpmTick();
            }
        }, 0, (long) ((1000000000*60d)/(bpm*16)), TimeUnit.NANOSECONDS);

        ScheduledExecutorService animationTick = Executors.newSingleThreadScheduledExecutor();
        bpmTick.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Handler.animationTick();
            }
        }, 0, (long) ((1000000000*60d)/(bpm*15)), TimeUnit.NANOSECONDS);

        addKeyListener(this);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getMousePosition()!=null){
            mouse=getMousePosition();
        }

        Handler.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Window.isFullscreen()){
                Window.frame.bigScreen();
            } else {
                Window.frame.fullScreen();
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
        Handler.mouseClicked(e);
    }
    public void mousePressed(MouseEvent e) {
        Handler.mousePressed(e);
    }
    public void mouseReleased(MouseEvent e) {
        Handler.mouseReleased(e);
    }
}
