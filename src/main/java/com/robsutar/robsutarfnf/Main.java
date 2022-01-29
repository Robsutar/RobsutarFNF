package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Engine.ClassReader;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.Forms;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsAnswer;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsFile;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsTextField;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseFolderCreator;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;


public class Main {
    public static void main(String[] args){
        startGame();

        //PhaseFolderCreator pcreator = new PhaseFolderCreator();
        //pcreator.open();

        PhaseHandler handler = new PhaseHandler(FileManager.loadFile(FileManager.phasesPath+"Rwby\\Rwby system.json"));
        //PhaseHandler handler = new PhaseHandler();
        handler.open();

        WindowGame.resize(WindowGame.windowDim,false);
    }
    public static void startGame(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new Assets(null);
        WindowGame.frame=new WindowGame();
    }
}
