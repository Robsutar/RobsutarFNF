package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.Forms;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsAnswer;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsTextField;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        startGame();

        //PhaseHandler handler =new PhaseHandler();

        List<FormsAnswer> fa = new ArrayList<>();
        fa.add(new FormsTextField("Map title: ",""));
        fa.add(new FormsTextField("Map author: ",""));
        fa.add(new FormsTextField("Music author: ",""));

        Forms forms = new Forms(fa, Handler.getPanel());

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
