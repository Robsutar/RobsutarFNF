package com.robsutar.robsutarfnf.Frame;

import com.robsutar.robsutarfnf.Handlers.Handlers;
import com.robsutar.robsutarfnf.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements ActionListener {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    private static final int DELAY = 20;
    boolean running = false;

    Timer timer;
    private final Handlers handlers;

    GamePanel(Handlers handlers){
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.handlers = handlers;
        startGame();
    }

    public void startGame(){
        timer = new Timer(DELAY,this);
        timer.start();
        running = true;
    }
    public void paintComponent(Graphics g ){
        super.paintComponent(g);
        Main.renderer(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running){
            repaint();
            Main.tick();
        }
    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e ){
            if (e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){

            } else if (e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){

            } else if (e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){

            } else if (e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){

            } else;
        }
    }
}
