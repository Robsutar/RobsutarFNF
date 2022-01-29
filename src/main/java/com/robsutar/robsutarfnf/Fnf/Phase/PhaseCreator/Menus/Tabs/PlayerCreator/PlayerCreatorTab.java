package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PlayerCreator;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerCreatorTab implements PhaseCreatorTab {
    private final PhaseHandler handler;
    private JPanel panel = new JPanel();
    private PlayerCreator playerCreator = new PlayerCreator(null,panel);
    private List<JMenuItem> atlasListButtons = new ArrayList<>();

    JMenu atlasList = new JMenu("Animated");
    JMenuBar atlasListBar = new JMenuBar();

    public PlayerCreatorTab(PhaseHandler handler){
        this.handler=handler;

        handler.atlas.add(Assets.TEMPORARY_ROBOT);

        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout());

        panel.add(playerCreator.panel);

        updateButtonsList();

        atlasListBar.add(atlasList);

        panel.add(atlasListBar,BorderLayout.WEST);

        newPlayerCreator(null);
    }

    public void updateButtonsList(){
        atlasListButtons = new ArrayList<>();
        for (int i = 0;i<handler.atlas.toArray().length;i++){
            Atlas a = handler.atlas.get(i);

            JMenuItem b = new JMenuItem(a.getName());
            b.setFocusable(false);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    newPlayerCreator(a);
                    enableAllButtons(b);
                }
            });
            atlasListButtons.add(b);
        }

        atlasList.removeAll();

        for (JMenuItem b:atlasListButtons)
        {
            atlasList.add(b);
        }

        JMenuItem addAnimatedObject = new JMenuItem("Add more");
        addAnimatedObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Atlas a = handler.loadAnimatedObject();
                if (a!=null){
                    handler.atlas.add(a);
                    updateButtonsList();
                }
            }
        });

        atlasList.add(addAnimatedObject);
    }

    public void enableAllButtons(JMenuItem bElse){
        for (JMenuItem b:atlasListButtons){
            b.setEnabled(b != bElse);
        }
    }

    public void newPlayerCreator(Atlas a){
        playerCreator.close();
        playerCreator.recreate(a);
        playerCreator.open();
    }

    @Override
    public void open() {
        handler.panel.add(panel);
        playerCreator.open();
    }

    @Override
    public void close() {
        handler.panel.remove(panel);
        playerCreator.close();
    }

    @Override
    public String getName() {
        return "Player Maker";
    }

    @Override
    public void onHandlerSave() {

    }
}
