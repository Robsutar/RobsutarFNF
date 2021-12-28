package com.robsutar.robsutarfnf.Frame;

import com.robsutar.robsutarfnf.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private static final int DELAY =2;
    private long tim=System.currentTimeMillis();

    boolean running = false;
    boolean mouseOnScreen = false;
    boolean dragging = false;

    int startDragX,startDragY;

    Timer timer;

    GamePanel(){
        this.setPreferredSize(new Dimension(Main.WIDTH,Main.HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(this);
        addMouseMotionListener(this);
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
        startDragX = e.getX();startDragY = e.getY();
        dragging = true;
        Main.handler.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startDragX=0;startDragY=0;
        dragging = false;
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

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = e.getPoint();
        Main.handler.mouseDragged(e,startDragX-p.x,startDragY-p.y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e ){
            Main.handler.keyPressed(e);
        }
    }
}