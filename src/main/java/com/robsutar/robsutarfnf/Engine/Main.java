package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.PhaseConfigs;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;


public class Main {
    public static void main(String[] args){
        startGame();

        new PhaseHandler();

        WindowGame.resize(WindowGame.windowDim,false);
    }
    public static void startGame(){
        //lookAndFeel visual
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new Assets(null);
        WindowGame.frame=new WindowGame();
    }
}
