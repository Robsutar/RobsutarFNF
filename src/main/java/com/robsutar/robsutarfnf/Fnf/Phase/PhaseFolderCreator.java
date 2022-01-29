package com.robsutar.robsutarfnf.Fnf.Phase;

import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.Forms;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsAnswer;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsFile;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsTextField;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PhaseFolderCreator {
    private String mapTitle;
    private File music;
    private File p1Voice;
    private File p2Voice;
    private Forms forms;
    public PhaseFolderCreator(){
        List<FormsAnswer> options = new ArrayList<>();
        FormsTextField phaseTitle = new FormsTextField("Phase title (folder name): ","");
        FormsFile phaseMusic = new FormsFile("Phase music: ",new FileNameExtensionFilter("WAV files","wav"));
        FormsFile phaseP1Voices = new FormsFile("Phase player1 voices: ",new FileNameExtensionFilter("WAV files","wav"));
        FormsFile phaseP2Voices = new FormsFile("Phase player2 voices: ",new FileNameExtensionFilter("WAV files","wav"));

        phaseTitle.setRequired(true);options.add(phaseTitle);
        phaseMusic.setRequired(true);options.add(phaseMusic);
        phaseP1Voices.setRequired(true);options.add(phaseP1Voices);
        phaseP2Voices.setRequired(true);options.add(phaseP2Voices);

        forms = new Forms("Creating phase...", Handler.getWindow(), 400, 270, options, e -> {
            music = phaseMusic.getAnswer();
            mapTitle = phaseTitle.getAnswer();
            p1Voice = phaseP1Voices.getAnswer();
            p2Voice = phaseP2Voices.getAnswer();
            FileManager.writeFile(music,FileManager.loadFile(FileManager.phasesPath + mapTitle + "\\sounds\\" + music.getName()));
            FileManager.writeFile(p1Voice,FileManager.loadFile(FileManager.phasesPath + mapTitle + "\\sounds\\" + p1Voice.getName()));
            FileManager.writeFile(p2Voice,FileManager.loadFile(FileManager.phasesPath + mapTitle + "\\sounds\\" + p2Voice.getName()));
            PhaseHandler handler =new PhaseHandler(mapTitle,music,p1Voice,p2Voice);
            handler.open();
        });
    }

    public void open(){
        forms.open();
    }
    public void close(){
        forms.close();
    }
}
