package com.robsutar.robsutarfnf.Engine.Window;

import com.robsutar.robsutarfnf.Engine.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel implements KeyListener, MouseListener, MouseWheelListener {

    public int fps = 60;
    private static float bpm = 60;

    public static Point mouse = new Point(WindowGame.wdt()/2, WindowGame.hgt()/2);

    private static Thread renderer;
    private static Thread bpmTick;
    private static Thread animationTick;
    private static ScheduledExecutorService tick;

    public GamePanel() {

        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(null);

        renderer = new Thread(new Runnable() {
            @Override
            public void run() {
                long now = 0;
                long total = 0;
                while (true) {
                    long fpsTime = (long) ((1000.0 / fps) * 1000000.0);
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

        bpmTick = new Thread(new Runnable() {
            @Override
            public void run() {
                long now = 0;
                long total = 0;
                while (true) {
                    long bpmTime = (long) ((1000000000*60d)/(bpm*16));
                    now = System.nanoTime();
                    Handler.bpmTick();
                    try {
                        total = System.nanoTime() - now;
                        if(total > bpmTime) {
                            continue;
                        }
                        Thread.sleep((bpmTime - (System.nanoTime() - now)) / 1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        bpmTick.start();

        animationTick = new Thread(new Runnable() {
            @Override
            public void run() {

                long now = 0;
                long total = 0;
                while (true) {
                    long bpmTime = (long) ((1000000000*60d)/(bpm*15));
                    now = System.nanoTime();
                    Handler.animationTick();
                    try {
                        total = System.nanoTime() - now;
                        if(total > bpmTime) {
                            continue;
                        }
                        Thread.sleep((bpmTime - (System.nanoTime() - now)) / 1000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        animationTick.start();

        tick = Executors.newSingleThreadScheduledExecutor();
        tick.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Handler.tick();
            }
        }, 0, 10, TimeUnit.MILLISECONDS);


        addKeyListener(this);
        addMouseListener(this);
        addMouseWheelListener(this);
    }

    public static void setBpm(float bpm) {
        GamePanel.bpm = bpm;
    }

    public void addComponent(Component component){this.add(component);}

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
        Handler.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        Handler.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (WindowGame.isFullscreen()){
                WindowGame.frame.bigScreen();
            } else {
                WindowGame.frame.fullScreen();
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

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation()<0){
            Handler.setVolume(Handler.volume-e.getWheelRotation());
        } else {
            Handler.setVolume(Handler.volume-e.getWheelRotation());
        }
    }

}
