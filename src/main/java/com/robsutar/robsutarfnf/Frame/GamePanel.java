package com.robsutar.robsutarfnf.Frame;
import com.robsutar.robsutarfnf.Camera;
import com.robsutar.robsutarfnf.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements ActionListener, MouseListener {
    private static final int DELAY =2;
    boolean running = false;
    boolean mouseOnScreen = false;
    long tim=System.currentTimeMillis();

    Timer timer;

    GamePanel(){
        this.setPreferredSize(Main.getWindowDim());
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
            tim += 10; //here the same
            Main.tick();
        }
        Main.renderer(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            if(mouseOnScreen) {
                Point b = this.getMousePosition();
                if (b!=null&&Main.camState!=null) {
                    Camera.CameraState st = Main.camState;
                    int xMs = (int) ((b.getX())/st.getScale());
                    int yMs = (int) ((b.getY())/st.getScale());

                    Main.xMouse = xMs;
                    Main.yMouse = yMs;
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
        Main.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Main.mouseReleased(e);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseOnScreen=true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseOnScreen=false;
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e ){
            if (e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
                Main.state = 4;
            } else if (e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
                Main.state = 2;
            } else if (e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
                Main.state = 0;
            } else if (e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
                Main.state = 3;
            } else;
        }
    }
}
