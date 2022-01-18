package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.AnchorTypes;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PlayerCreator.PlayerCreator;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;


public class Main {
    public static void main(String[] args){
        startGame();

        PhaseHandler handler =new PhaseHandler();

        //new PlayerCreator(Assets.TEMPORARY_ROBOT,Handler.getPanel());

        WindowGame.resize(WindowGame.windowDim,false);
    }
    public static void startGame(){
        //lookAndFeel visual
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        WindowGame.frame=new WindowGame();
        new Assets(null);
    }
}
