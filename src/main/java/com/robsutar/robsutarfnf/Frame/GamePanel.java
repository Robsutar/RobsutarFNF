package com.robsutar.robsutarfnf.Frame;

import com.robsutar.robsutarfnf.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, MouseListener {
    private static final int DELAY =2;
    private long tim=System.currentTimeMillis();

    boolean running = false;
    boolean mouseOnScreen = false;

    Timer timer;

    GamePanel(){
        this.setPreferredSize(new Dimension(Main.WIDTH,Main.HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(this);
        startGame();
    }

    public void startGame(){
        timer = new Timer(DELAY,this);
        timer.start();
        running = true;
    }

    @Override
    public void paintComponent(Graphics g ){
        super.paintComponent(g);
        while(System.currentTimeMillis() - tim > 10) { //10 = 100 ticks per second ** 1 = 1000 ticks per second
            tim += 10;
            Main.handler.tick();
        }
        Main.handler.renderer(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            if(mouseOnScreen) {
                Point b = this.getMousePosition();
                if (b!=null) {
                    Main.xMouse = (int)b.getX();
                    Main.yMouse = (int)b.getY();
                }
            }
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseOnScreen=true;
        Main.handler.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Main.handler.mouseReleased(e);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseOnScreen=true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseOnScreen=false;
    }

    public static class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e ){
            Main.handler.keyPressed(e);
        }
    }
}