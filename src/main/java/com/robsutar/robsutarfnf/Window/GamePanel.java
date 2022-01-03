package com.robsutar.robsutarfnf.Window;

import com.robsutar.robsutarfnf.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements KeyListener {

    public int fps = 60;
    private float bpm = 90;

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

        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
}
