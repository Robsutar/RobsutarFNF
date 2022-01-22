package com.robsutar.robsutarfnf.Fnf.Phase;

import com.robsutar.robsutarfnf.Engine.Audio.Music;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Fnf.GameObjects.Player;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PlayerCreator.PlayerCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.TapBpm.TapBpm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PhaseHandler {
    public String mapTitle;
    public String mapAuthor;
    public float approximatingRate;
    public Music music;
    public List<Atlas> atlas = new ArrayList<>();
    public List<Player> players = new ArrayList<>();

    public JPanel panel = new JPanel();

    private JPanel tabs = new JPanel();

    private PlayerCreatorTab playerCreatorTab;

    private TapBpm tapBpm;

    private List<PhaseCreatorTab> tabList = new ArrayList<>();

    public PhaseHandler(){
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.gray);

        tabs.setBorder(new EmptyBorder(10,10,10,10));
        tabs.setBackground(Color.lightGray);

        playerCreatorTab= new PlayerCreatorTab(this);
        tabList.add(playerCreatorTab);

        tapBpm = new TapBpm(this);
        tabList.add(tapBpm);

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

        Handler.getPanel().add(panel,BorderLayout.SOUTH);
        Handler.getPanel().add(tabs,BorderLayout.NORTH);
    }

    private void closeTabs(){

        for (PhaseCreatorTab p : tabList){
            p.close();
        }
    }

    public Atlas loadAnimatedObject(){
        return new Atlas(FileManager.loadExplorerFile(new FileNameExtensionFilter("XML file (.xml)","xml")));
    }
}
