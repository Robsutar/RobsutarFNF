package com.robsutar.robsutarfnf.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements ActionListener {

    int tempx = 0;

    private int fps = 60;

    private float bpm = 90;

    public GamePanel() {

        this.setPreferredSize(Window.windowDim);
        this.setBackground(Color.BLACK);
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
                tick();
            }
        }, 0, 10, TimeUnit.MILLISECONDS);

        ScheduledExecutorService bpmTick = Executors.newSingleThreadScheduledExecutor();
        bpmTick.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    bpmTick();
                }
            }, 0, (long) ((1000000000*60d)/(bpm*16)), TimeUnit.NANOSECONDS);
    }

    public void tick(){
        tempx++;
    }

    private void bpmTick() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.rotate(Math.toRadians(tempx),Window.width/2.0,Window.height/2.0);

        g2d.fillRect(Window.width/2,Window.height/2,50,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
