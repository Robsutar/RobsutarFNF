package com.robsutar.robsutarfnf.Interface;

import com.robsutar.robsutarfnf.Main;

import java.awt.event.KeyEvent;

public interface KeyboardInteractive {
    default void spawnKeyboardTick(){
        Main.handler.addObject(this);
    }
    default void killKeyboardTick(){
        Main.handler.removeObject(this);
    }
    default void keyPressed(KeyEvent e){

    }
}
