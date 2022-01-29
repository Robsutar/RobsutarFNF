package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PlayerCreator;

import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerCreator implements PhaseCreatorTab {
    private Atlas atlas;

    private String arrowUp;
    private String arrowDown;
    private String arrowLeft;
    private String arrowRight;
    private String arrowIdle;

    //Arrows select
    JPanel arrows = new JPanel();

    ArrowsPanel AUp;
    ArrowsPanel ADown ;
    ArrowsPanel ARight ;
    ArrowsPanel ALeft ;
    ArrowsPanel AIdle ;

    JPanel panel = new JPanel();
    private final JPanel handler;

    PedestalPlayer player;

    public PlayerCreator(Atlas atlas,JPanel handler){
        this.handler=handler;
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.setLayout(new BorderLayout());

        //Center empty space to show player
        JPanel playerPlace = new JPanel();
        panel.add(playerPlace,BorderLayout.CENTER);

        recreate(atlas);
    }

    public void recreate(Atlas a){
        if (a==null){
            return;
        }
        this.atlas = a;

        arrows.removeAll();
        panel.removeAll();

        arrows.setEnabled(false);
        arrows.setEnabled(true);

        AUp = new ArrowsPanel("Up");
        ADown = new ArrowsPanel("Down");
        ARight = new ArrowsPanel("Right");
        ALeft = new ArrowsPanel("Left");
        AIdle = new ArrowsPanel("Idle");

        //Arrows select
        arrows.setLayout(new GridLayout(1,4));

        arrows.add(AUp.panel);
        arrows.add(ADown.panel);
        arrows.add(ARight.panel);
        arrows.add(ALeft.panel);
        arrows.add(AIdle.panel);

        panel.add(arrows,BorderLayout.SOUTH);

        //auto select
        for(String s : atlas.getNames()){
            if (s.contains("UP")||s.contains("up")||s.contains("Up")){
                arrowUp=s;
                AUp.menu.setText(s);
            } else if (s.contains("DOWN")||s.contains("down")||s.contains("Down")){
                arrowDown=s;
                ADown.menu.setText(s);
            } else if (s.contains("LEFT")||s.contains("left")||s.contains("Left")){
                arrowLeft=s;
                ALeft.menu.setText(s);
            } else if (s.contains("RIGHT")||s.contains("right")||s.contains("Right")){
                arrowRight=s;
                ARight.menu.setText(s);
            } else if (s.contains("IDLE")||s.contains("idle")||s.contains("Idle")){
                arrowIdle =s;
                AIdle.menu.setText(s);
            }
        }

        //player
        if (atlas.isPlayer()) {
            arrowUp=atlas.getArrow("Up");
            arrowDown=atlas.getArrow("Down");
            arrowLeft=atlas.getArrow("Left");
            arrowRight=atlas.getArrow("Right");
            arrowIdle=atlas.getArrow("Idle");
        }
        else {
            for(String s : atlas.getNames()){
                if (s.contains("UP")||s.contains("up")||s.contains("Up")){
                    arrowUp=s;
                } else if (s.contains("DOWN")||s.contains("down")||s.contains("Down")){
                    arrowDown=s;
                } else if (s.contains("LEFT")||s.contains("left")||s.contains("Left")){
                    arrowLeft=s;
                } else if (s.contains("RIGHT")||s.contains("right")||s.contains("Right")){
                    arrowRight=s;
                } else if (s.contains("IDLE")||s.contains("idle")||s.contains("Idle")){
                    arrowIdle =s;
                }
            }
        }
        player = new PedestalPlayer(atlas, arrowUp, arrowDown, arrowLeft, arrowRight, arrowIdle);
        setArrowsBoxText();
    }

    private void setArrowsBoxText(){
        AUp.menu.setText(arrowUp);
        ADown.menu.setText(arrowDown);
        ALeft.menu.setText(arrowLeft);
        ARight.menu.setText(arrowRight);
        AIdle.menu.setText(arrowIdle);
    }

    @Override
    public void open() {
        handler.add(panel,BorderLayout.CENTER);
        handler.revalidate();
        handler.repaint();
        if (player==null){return;}
        player.spawnAll();
        player.playIdle();
    }

    @Override
    public void close() {
        handler.remove(panel);
        if (player==null){return;}
        player.killAll();
    }

    @Override
    public String getName() {
        return "Player Creator";
    }

    @Override
    public void onHandlerSave() {

    }

    private void updatePlayerAnimations(){
        player.setAnimations(arrowUp,arrowDown,arrowLeft,arrowRight, arrowIdle);
    }

    private class ArrowsPanel{
        JPanel panel = new JPanel();
        List<JMenuItem> animationNames = getAnimations();
        String arrow = null;
        final String typeArrow;
        JMenu menu = new JMenu("select");

        private List<JMenuItem> getAnimations() {
            List<JMenuItem> buttons = new ArrayList<>();
            for(String s : atlas.getNames()){
                JMenuItem b = new JMenuItem(s);
                b.addActionListener(e -> {
                    arrow=s;
                    menu.setText(getArrow());

                    if (Objects.equals(typeArrow, "Up")){
                        arrowUp=getArrow();
                        updatePlayerAnimations();
                        player.playUp();
                    } else if(Objects.equals(typeArrow, "Down")){
                        arrowDown=getArrow();
                        updatePlayerAnimations();
                        player.playDown();
                    } else if(Objects.equals(typeArrow, "Left")){
                        arrowLeft=getArrow();
                        updatePlayerAnimations();
                        player.playLeft();
                    } else if(Objects.equals(typeArrow, "Right")){
                        arrowRight=getArrow();
                        updatePlayerAnimations();
                        player.playRight();
                    } else if(Objects.equals(typeArrow, "Idle")){
                        arrowIdle =getArrow();
                        updatePlayerAnimations();
                        player.playIdle();
                    }
                });
                buttons.add(b);
            }
            return buttons;
        }

        public String getArrow() {
            return arrow;
        }

        private ArrowsPanel(String arrow){
            this.typeArrow=arrow;
            panel.setSize(100,50);
            panel.setLayout(new BorderLayout());

            JLabel label = new JLabel("Arrow "+arrow);
            panel.add(label,BorderLayout.SOUTH);

            //popup menu
            JMenuBar bar = new JMenuBar();

            for (JMenuItem b : animationNames){
                menu.add(b);
            }

            bar.add(menu);
            panel.add(bar,BorderLayout.NORTH);
        }
    }
}
