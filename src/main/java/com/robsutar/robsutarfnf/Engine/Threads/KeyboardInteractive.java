package com.robsutar.robsutarfnf.Engine.Threads;

import com.robsutar.robsutarfnf.Engine.Handler;

import java.awt.event.KeyEvent;

public interface KeyboardInteractive extends FullSpawn {
    default void spawnKeyboardInteractive(){
        Handler.addObject(this);}
    default void killKeyboardInteractive(){
        Handler.removeObject(this);
    }

    default void keyPressed(KeyEvent e){

    }

    default void keyTyped(KeyEvent e){

    }
}
