package com.robsutar.robsutarfnf.Fnf.Phase;

import com.robsutar.robsutarfnf.Engine.Audio.Music;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Interfaces.KeyboardInteractive;
import com.robsutar.robsutarfnf.Engine.Interfaces.Ticable;
import com.robsutar.robsutarfnf.Engine.SystemPrinter;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.GameObjects.Player;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.MusicBar.MusicBar;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.MusicBar.SliderPhase;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseConfiguration.PhaseConfiguration;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PlayerCreator.PlayerCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.TapBpm.TapBpm;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.PhaseJson;
import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PhaseHandler implements KeyboardInteractive, Ticable {
    public String phaseTitle;
    public String mapAuthor="";
    public String musicAuthor="";
    public Music music;
    public Music p1Voice;
    public Music p2Voice;
    public float bpm=90;

    public String selectedObject = "arrowDown";

    public int sliderPercent;

    public List<Atlas> atlas = new ArrayList<>();
    public float approximatingRate;
    public List<Player> players = new ArrayList<>();

    public JPanel panel = new JPanel();

    private JPanel tabs = new JPanel();

    public JPanel left = new JPanel();

    private PlayerCreatorTab playerCreatorTab;
    private TapBpm tapBpm;
    private PhaseConfiguration phaseConfiguration;
    private MusicBar musicBar;

    private List<PhaseCreatorTab> tabList = new ArrayList<>();

    public PhaseHandler(File jsonFile){
        PhaseJson.readPhaseConfigs(jsonFile,this);
    }

    public PhaseHandler(){
    }

    public PhaseHandler(String mapTitle, File music, File p1Voice, File p2Voice) {
        this.phaseTitle=mapTitle;replaceMusic(music);replaceP1Voice(p1Voice);replaceP2Voice(p2Voice);
        System.out.println(music.getPath());
    }

    public void playAudios(){music.start();/*p1Voice.start();p2Voice.start();*/}
    public void stopAudios(){music.stop();p1Voice.stop();p2Voice.stop();}

    public void playOrStopAudios(){music.pauseOrStart();}

    public void open(){
        addPanels();
        initialize();
        if (phaseTitle==null){
            phaseConfiguration.open();
        } else {
            spawnAll();
        }
    }

    public void close(){
        killAll();
        removePanels();
    }

    public void setSliderPercent(int value){this.sliderPercent=value;music.setPosition(sliderPercent,100000);}

    public void replaceMusic(File fileAudio) {
        File file = FileManager.writeFile(fileAudio, new File(getPhaseFolder()+"\\sounds\\"+ fileAudio.getName()));
        Music audio = new Music(file);
        if(music != null) {
            FileManager.deleteFile(music.file);
        }
        music = audio;
    }
    public void replaceP1Voice(File fileAudio) {
        File file = FileManager.writeFile(fileAudio, new File(getPhaseFolder()+"\\sounds\\" + fileAudio.getName()));
        Music audio = new Music(file);
        if(p1Voice != null) {
            FileManager.deleteFile(p1Voice.file);
        }
        p1Voice = audio;
    }
    public void replaceP2Voice(File fileAudio) {
        File file = FileManager.writeFile(fileAudio, new File(getPhaseFolder()+"\\sounds\\" + fileAudio.getName()));
        Music audio = new Music(file);
        if(p2Voice != null) {
            FileManager.deleteFile(p2Voice.file);
        }
        p2Voice = audio;
    }

    private void initialize() {
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.gray);

        tabs.setBorder(new EmptyBorder(10,10,10,10));
        tabs.setBackground(Color.lightGray);

        //TABS
        playerCreatorTab= new PlayerCreatorTab(this);
        tabList.add(playerCreatorTab);

        tapBpm = new TapBpm(this);
        tabList.add(tapBpm);

        phaseConfiguration = new PhaseConfiguration(this);
        tabList.add(phaseConfiguration);

        musicBar = new MusicBar(this);
        tabList.add(musicBar);

        for (PhaseCreatorTab p:tabList){
            JButton b = new JButton(p.getName());
            b.setFocusable(false);
            b.addActionListener(e -> {
                closeTabs();
                p.open();
                panel.revalidate();
                panel.repaint();
            });
            tabs.add(b);
        }
        tabs.setLayout(new GridLayout(0,tabList.toArray().length));
    }

    private void addPanels(){
        Handler.getPanel().add(panel,BorderLayout.SOUTH);
        Handler.getPanel().add(tabs,BorderLayout.NORTH);
        Handler.getPanel().add(left,BorderLayout.WEST);
    }

    private void removePanels(){
        Handler.getPanel().remove(panel);
        Handler.getPanel().remove(tabs);
    }
    private void closeTabs(){
        for (PhaseCreatorTab p : tabList){
            p.close();
        }
    }

    public Atlas loadAnimatedObject(){
        return new Atlas(FileManager.loadExplorerFile(new FileNameExtensionFilter("XML file (.xml)","xml")));
    }

    public String getPhaseFolder(){return FileManager.phasesPath+ phaseTitle +"\\";}

    private void savePhaseFile(){
        FileManager.writeFile(PhaseJson.writePhaseConfigs(this),FileManager.loadFile(getPhaseFolder()+ phaseTitle +" system.json"));
    }

    public void onHandlerSave(){
        for (PhaseCreatorTab pc : tabList){
            pc.onHandlerSave();
        }
    }

    public void save(){
        onHandlerSave();

        SystemPrinter.print(SystemPrinter.PURPLE+"Saving phase: "+ SystemPrinter.BLUE +phaseTitle+
                SystemPrinter.JUMP_LINE+SystemPrinter.BLUE+"Map author: "+mapAuthor+
                SystemPrinter.JUMP_LINE+SystemPrinter.GREEN+"Music author: "+musicAuthor+
                SystemPrinter.JUMP_LINE+SystemPrinter.PURPLE+"Music path: "+ music.getName()+
                SystemPrinter.JUMP_LINE+SystemPrinter.RED+"Player1 voice: "+p1Voice.getName()+
                SystemPrinter.JUMP_LINE+SystemPrinter.YELLOW+"Player2 voice: "+ p2Voice.getName()+
                SystemPrinter.JUMP_LINE+SystemPrinter.CYAN+"Bpm: "+bpm+
                SystemPrinter.JUMP_LINE+SystemPrinter.GREEN_BOLD+"Animated Objects: "+atlas);

        savePhaseFile();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()){
            if (e.getKeyCode()==KeyEvent.VK_S){
                save();
            }
        } else if (e.getKeyCode()==KeyEvent.VK_SPACE){
            playOrStopAudios();
        }
    }

    @Override
    public void tick() {
        if (music.audio.isActive()){
            musicBar.setValue(music.getActualPosition((long) music.getBeatLength(bpm)));
        }
    }
}
