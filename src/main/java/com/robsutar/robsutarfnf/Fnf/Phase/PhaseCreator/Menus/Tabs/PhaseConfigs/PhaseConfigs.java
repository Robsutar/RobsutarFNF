package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseConfigs;

import com.robsutar.robsutarfnf.Engine.Audio.Music;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhaseConfigs {
    private final PhaseHandler handler;

    JPanel panel = new JPanel();

    List<Option> options = new ArrayList<>();

    List<JPanel> panels = new ArrayList<>();

    //map title
    TextOption oMapTitle = new TextOption("Map title: ");

    //map author
    TextOption oMapAuthor = new TextOption("Map author(s): ");

    //map music
    FileOption oMapMusic = new FileOption("Map music: ",new FileNameExtensionFilter("WAV file (.wav)","wav"));

    //animatedObjects List
    AnimatedObjectsOption oAtlas = new AnimatedObjectsOption("Animated: ",new FileNameExtensionFilter("XML file (.xml)","xml"));

    public PhaseConfigs(PhaseHandler phaseHandler) {
        handler=phaseHandler;

        //finish button:
        JPanel continuePanel = new JPanel();
        Button continueButton = new Button("CONTINUE!");
        continuePanel.add(continueButton);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finish();
            }
        });

        //add options in list
        options.add(oMapTitle);
        options.add(oMapAuthor);
        options.add(oMapMusic);
        options.add(oAtlas);

        //add jPanels in list
        for (Option o : options){
            panels.add(o.getPanel());
        }
        panels.add(continuePanel);
        for (JPanel p:panels){
            panel.add(p);
        }

        panel.setLayout(new GridLayout(panels.toArray().length,0));

        Handler.getPanel().add(panel);
    }

    private void finish() {
        for (Option o :options){
            if (o.getAnswer()==null){
                o.highlight();
                return;
            } else {
                o.normalize();
            }
        }

        List<Atlas> animObjects = new ArrayList<>();

        for (File o: oAtlas.getAnswer()){
            Atlas an = new Atlas(o);
            animObjects.add(an);
        }

        handler.mapTitle = oMapTitle.getAnswer();
        handler.mapAuthor = oMapAuthor.getAnswer();
        handler.music = new Music(FileManager.loadWav((File) oMapMusic.getAnswer()),90);
        handler.atlas.addAll(animObjects);
    }
    protected abstract class Option{
        protected JPanel panel = new JPanel();
        abstract void highlight();
        abstract Object getAnswer();
        public JPanel getPanel(){return panel;}

        public abstract void normalize();
    }

    protected class TextOption extends Option {
        JTextField box;
        JLabel text;

        protected TextOption(String label){
            text = new JLabel(label);
            int columns = 15;
            box = new JTextField(columns);
            panel.add(text);
            panel.add(box);
        }

        @Override
        protected String getAnswer(){
            if (!(box.getText().length() >0)){
                return null;
            }
            return box.getText();
        }

        @Override
        public void normalize() {
            text.setForeground(Color.black);
        }

        @Override
        public void highlight() {
            text.setForeground(Color.red);
        }
    }
    protected class FileOption extends Option {
        JButton box = new JButton("select");
        File file;

        protected FileOption(String label,FileNameExtensionFilter filter){
            JLabel text = new JLabel(label);
            panel.add(text);
            panel.add(box);
            box.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File f = FileManager.loadExplorerFile(filter);
                    if (f != null) {
                        setFile(f);
                    }
                }
            });
        }
        protected void setFile(File file){
            box.setText(file.getName());
            this.file=file;
        }

        @Override
        protected Object getAnswer(){
            return file;
        }

        @Override
        public void normalize() {
            box.setForeground(Color.black);
        }

        @Override
        public void highlight() {
            box.setForeground(Color.red);
        }
    }
    protected class AnimatedObjectsOption extends FileOption {
        List<File> atlasFiles = new ArrayList<>();
        protected AnimatedObjectsOption(String label, FileNameExtensionFilter filter) {
            super(label, filter);
        }

        @Override
        protected void setFile(File file) {
            atlasFiles.add(file);
            box.setText("Amount: "+atlasFiles.toArray().length);
        }

        @Override
        protected List<File> getAnswer() {
            if (atlasFiles.toArray().length==0){
                return null;
            }
            return atlasFiles;
        }
    }
}
