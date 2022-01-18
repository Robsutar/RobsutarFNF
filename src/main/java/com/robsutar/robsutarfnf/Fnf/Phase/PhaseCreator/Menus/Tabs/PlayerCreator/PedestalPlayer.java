package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PlayerCreator;

import com.robsutar.robsutarfnf.Engine.Threads.KeyboardInteractive;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.GameObjects.Player;

import java.awt.event.KeyEvent;

public class PedestalPlayer extends Player implements KeyboardInteractive {
    public PedestalPlayer(Atlas atlas, String arrowUp, String arrowDown, String arrowLeft, String arrowRight, String idle) {
        super(atlas, arrowUp, arrowDown, arrowLeft, arrowRight, idle);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_W||e.getKeyCode()==KeyEvent.VK_UP){
            playUp();
        } else if(e.getKeyCode()==KeyEvent.VK_S||e.getKeyCode()==KeyEvent.VK_DOWN){
            playDown();
        } else if(e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT){
            playLeft();
        } else if(e.getKeyCode()==KeyEvent.VK_D||e.getKeyCode()==KeyEvent.VK_RIGHT){
            playRight();
        } else if (e.getKeyCode()==KeyEvent.VK_SPACE){
            playIdle();
        }
    }
}
