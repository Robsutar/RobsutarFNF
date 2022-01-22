package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PlayerCreator;

import com.robsutar.robsutarfnf.Engine.ExtendedRectangle;
import com.robsutar.robsutarfnf.Engine.Menus.Texts.TextDisappear;
import com.robsutar.robsutarfnf.Engine.Threads.KeyboardInteractive;
import com.robsutar.robsutarfnf.Engine.Threads.MouseInteractive;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.GameObjects.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PedestalPlayer extends Player implements KeyboardInteractive, MouseInteractive {
    private final Player background;
    private int actualX,actualY;

    public PedestalPlayer(Atlas atlas, String arrowUp, String arrowDown, String arrowLeft, String arrowRight, String idle) {
        super(atlas, arrowUp, arrowDown, arrowLeft, arrowRight, idle);
        background = new Player(atlas, arrowUp, arrowDown, arrowLeft, arrowRight, idle);
        construct();
    }

    private void construct(){
        background.setOpacity(0.2f);
        setPriority(background.getPriority()+1);
        background.playBack();
    }

    @Override
    public void onAnimationIndexUpdate(int index) {
        super.onAnimationIndexUpdate(index);
        background.onAnimationIndexUpdate(index);
        background.playBack();
    }

    @Override
    public void spawnAll() {
        super.spawnAll();
        background.spawnAll();
    }

    @Override
    public void killAll() {
        super.killAll();
        background.killAll();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()){
            if (e.isShiftDown()) {
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    atlas.writeReadjust(background.atlas.getReadjust());
                    atlas.writeArrows(atlas.getAnimationName(arrowUp), atlas.getAnimationName(arrowDown),
                            atlas.getAnimationName(arrowLeft),atlas.getAnimationName(arrowRight), atlas.getAnimationName(arrowIdle));
                    atlas.writeFile();

                    TextDisappear saved = new TextDisappear("Saved!",null);
                    saved.spawnAll();
                }
            }
        }else if (e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_UP){
            playUp();
        } else if(e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_DOWN){
            playDown();
        } else if(e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT){
            playLeft();
        } else if(e.getKeyCode()==KeyEvent.VK_D||e.getKeyCode()==KeyEvent.VK_RIGHT){
            playRight();
        } else if (e.getKeyCode()==KeyEvent.VK_SPACE){
            playIdle();
        } else if (e.getKeyCode()==KeyEvent.VK_L){
            /*
            SimpleText saved = new SimpleText((int)background.getCenterX(),(int)background.getHeight(),"&#Sa&#ve&#d!");
            saved.disappear = true;
            saved.spawn();

             */

            ExtendedRectangle b = background.atlas.getReadjust(getAnimationIndex());

            b.setLocation((int)b.getX()-actualX,(int)b.getY()-actualY);

            background.atlas.getReadjust(getAnimationIndex()).setLocation(b.getLocation());

            playNext();
        }
    }

    @Override
    public void mouseDragged(int xDistance, int yDistance) {
        int distX = (int)background.getX()-xDistance;
        int distY = (int)background.getY()-yDistance;

        setLocation(distX,distY);

        actualX = xDistance;
        actualY = yDistance;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawLine(0,WindowGame.hgt()/2,WindowGame.wdt(),WindowGame.hgt()/2);
        g2d.drawLine(WindowGame.wdt()/2,0,WindowGame.wdt()/2,WindowGame.hgt());
        super.render(g2d);
    }
}
