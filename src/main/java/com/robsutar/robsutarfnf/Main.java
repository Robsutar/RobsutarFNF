package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Engine.ClassReader;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.Forms;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsAnswer;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsFile;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsTextField;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        startGame();

        //PhaseHandler handler =new PhaseHandler();

        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ta´zada");
            }
        };

        List<FormsAnswer> fa = new ArrayList<>();

        FormsTextField ff = new FormsTextField("File netecte",null);
        ff.setRequired(true);

        fa.add(new FormsTextField("Map title: ",""));
        fa.add(new FormsTextField("Map author: ",""));
        fa.add(new FormsTextField("Music author: ",""));
        fa.add(new FormsTextField("coiso title: ",""));
        fa.add(new FormsTextField("coiso author: ",""));
        fa.add(new FormsTextField("ar author: ",""));
        fa.add(new FormsFile("select music: ",new FileNameExtensionFilter("WAV files","wav")));
        fa.add(new FormsFile("select: ",new FileNameExtensionFilter("WAV files","wav")));
        fa.add(new FormsFile("select: ",new FileNameExtensionFilter("WAV files","wav")));
        fa.add(ff);

        Forms forms = new Forms("PhaseHandler",Handler.getWindow(),300,500,fa,act);
        forms.open();

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
