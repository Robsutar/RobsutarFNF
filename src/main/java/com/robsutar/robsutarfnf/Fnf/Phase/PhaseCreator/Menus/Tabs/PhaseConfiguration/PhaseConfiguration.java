package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseConfiguration;

import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.Forms;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsAnswer;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsFile;
import com.robsutar.robsutarfnf.Engine.Menus.Forms.FormsTextField;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.PhaseJson;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhaseConfiguration implements PhaseCreatorTab {
    private PhaseHandler handler;

    private List<FormsAnswer> options;

    private Forms forms;

    FormsTextField phaseTitle ;
    FormsTextField mapAuthor ;
    FormsTextField musicAuthor;

    FormsFile music;
    FormsFile p1Voice;
    FormsFile p2Voice;

    public PhaseConfiguration(PhaseHandler handler){
        this.handler=handler;
    }

    @Override
    public void open() {
        options = new ArrayList<>();

        phaseTitle = new FormsTextField("Map title: ","");
        mapAuthor = new FormsTextField("Map Author: ",handler.mapAuthor);
        musicAuthor = new FormsTextField("Music Author: ",handler.musicAuthor);

        music = new FormsFile("Music: ",new FileNameExtensionFilter("WAV files","wav"));
        p1Voice = new FormsFile("Player1 Voice: ",new FileNameExtensionFilter("WAV files","wav"));
        p2Voice = new FormsFile("Player2 Voice: ",new FileNameExtensionFilter("WAV files","wav"));

        if (handler.phaseTitle==null){options.add(phaseTitle);phaseTitle.setRequired(true);}
        options.add(mapAuthor);mapAuthor.setRequired(handler.mapAuthor.length()<1);
        options.add(musicAuthor);musicAuthor.setRequired(handler.musicAuthor.length()<1);
        options.add(music);music.setRequired(handler.music==null);
        options.add(p1Voice);p1Voice.setRequired(handler.p1Voice==null);
        options.add(p2Voice);p2Voice.setRequired(handler.p2Voice==null);


        if (handler.music!=null){music.setAnswer(handler.music.file);}
        if (handler.p1Voice!=null){p1Voice.setAnswer(handler.p1Voice.file);}
        if (handler.p2Voice!=null){p2Voice.setAnswer(handler.p2Voice.file);}

        forms = new Forms("Phase Configuration", Handler.getWindow(), 300, 350, options, e -> setVariables());
        if (handler.phaseTitle==null){
            forms.cancel.setText("Load");forms.cancel.setForeground(Color.BLUE);
            forms.cancel.addActionListener(e ->{
                File f = FileManager.loadExplorerFile(new FileNameExtensionFilter("Json Files","json"));
                handler.close();
                handler = new PhaseHandler(f);
                close();
                handler.open();
            });
        } else {
            forms.cancel.addActionListener(e ->{
                close();
            });
        }

        forms.open();
    }

    private void setVariables() {
        if (phaseTitle.getAnswer()!=null){
            handler.phaseTitle=phaseTitle.getAnswer();}
        if (mapAuthor.getAnswer()!=null){handler.mapAuthor=mapAuthor.getAnswer();}
        if (musicAuthor.getAnswer()!=null){handler.musicAuthor=musicAuthor.getAnswer();}

        if (music.getAnswer()!=null){handler.replaceMusic(music.getAnswer());}
        if (p1Voice.getAnswer()!=null){handler.replaceP1Voice(p1Voice.getAnswer());}
        if (p2Voice.getAnswer()!=null){handler.replaceP2Voice(p2Voice.getAnswer());}
    }

    @Override
    public void close() {
        if (forms!=null){
            forms.close();
        }
    }

    @Override
    public String getName() {
        return "Phase Configuration";
    }

    @Override
    public void onHandlerSave() {

    }
}
