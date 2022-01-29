package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.MusicBar;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.MusicBar.SliderBar.SliderObject;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MusicBar implements PhaseCreatorTab {
    protected final PhaseHandler handler;

    private JPanel panel;

    private JPanel buttons;

    private JSlider slider;

    private SliderPhase sliderPhase;

    public MusicBar(PhaseHandler handler){
        this.handler = handler;
        sliderPhase = new SliderPhase(this);
    }

    public void setValue(long value){
        if (!slider.getValueIsAdjusting()) {
            slider.setValue((int) value);
        }
    }

    @Override
    public void open() {
        if (handler.music==null){handler.panel.add(panel); return;}

        panel = new JPanel();
        buttons = new JPanel();

        panel.setLayout(new BorderLayout());

        slider = new JSlider(0, (int) handler.music.getBeatLength(handler.bpm),0);
        slider.setFocusable(false);

        slider.addChangeListener(e -> {
            if (slider.getValueIsAdjusting()) {
                handler.setSliderPercent(slider.getValue());
            }
        });

        buttons.setLayout(new GridLayout(4 ,1));

        arrowButton arrowUp = new arrowButton("arrowUp");
        arrowButton arrowDown = new arrowButton("arrowDown");
        arrowButton arrowLeft = new arrowButton("arrowLeft");
        arrowButton arrowRight = new arrowButton("arrowRight");

        buttons.add(arrowUp);
        buttons.add(arrowDown);
        buttons.add(arrowLeft);
        buttons.add(arrowRight);

        panel.add(buttons,BorderLayout.NORTH);
        panel.add(sliderPhase,BorderLayout.NORTH);
        panel.add(slider,BorderLayout.SOUTH);

        handler.panel.add(panel);
        handler.left.add(buttons);
        sliderPhase.open();
    }

    @Override
    public void close() {
        if (panel!=null){
            handler.panel.remove(panel);
            handler.left.remove(buttons);
            sliderPhase.close();
        }
    }

    @Override
    public String getName() {
        return "Music Bar";
    }

    @Override
    public void onHandlerSave() {

    }

    private class arrowButton extends JButton{
        private final String name;

        private arrowButton(String name){
            this.name = name;

            setFocusable(false);

            if (Objects.equals(name, SliderObject.arrowUp)){
                setIcon(new ImageIcon(Assets.ARROW_UP));
            } else if (Objects.equals(name, SliderObject.arrowDown)){
                setIcon(new ImageIcon(Assets.ARROW_DOWN));
            } else if (Objects.equals(name, SliderObject.arrowLeft)){
                setIcon(new ImageIcon(Assets.ARROW_LEFT));
            } else if (Objects.equals(name, SliderObject.arrowRight)){
                setIcon(new ImageIcon(Assets.ARROW_RIGHT));
            }

            addActionListener(e -> handler.selectedObject= name);
        }
    }
}
