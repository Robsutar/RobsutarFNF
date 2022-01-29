package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.TapBpm;

import com.robsutar.robsutarfnf.Engine.Graphics.RainbowColor;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Menus.Texts.EditableText;
import com.robsutar.robsutarfnf.Engine.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Engine.Renderable.GameObject;
import com.robsutar.robsutarfnf.Engine.Interfaces.BpmTicable;
import com.robsutar.robsutarfnf.Engine.Interfaces.KeyboardInteractive;
import com.robsutar.robsutarfnf.Engine.Interfaces.Ticable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TapBpm implements PhaseCreatorTab,BpmTicable, Ticable, KeyboardInteractive {
    private float bpm;
    private int bAge = 0;
    private float lastBpm = 0;
    private long deltaNanoTap = 0;
    private long lastNanoTap = 0;
    private long lastCtrlTap = 0;
    private List<Long> range = new ArrayList<>();
    private boolean ctrlPressed=false;
    private final PhaseHandler handler;
    private JPanel panel = new JPanel();

    private EditableText text = new EditableText(Anchor.ANCHOR_MIDDLE, String.valueOf(bpm), 0, 100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder s = new StringBuilder(text.textField.getText());
            float f;
            for (int i = 0; i <s.length();i++){
                char c = s.charAt(i);
                if (!Character.isDigit(c)&&c!='.'){
                    s.deleteCharAt(i);
                    i--;
                }
            }
            f = (float)(java.lang.Double.parseDouble(String.valueOf(s)));
            text.textField.setText(String.valueOf(f));
            text.textField.setEnabled(false);
            text.textField.setEnabled(true);
            range = new ArrayList<>();
            bpm=f;
        }
    });

    private IlluminatedBox[] boxes = new IlluminatedBox[4];

    public TapBpm(PhaseHandler phaseHandler){
        this.handler = phaseHandler;

        bpm=handler.bpm;

        List<JLabel> keyTips = new ArrayList<>();

        keyTips.add(new JLabel("CTRL to double"));
        keyTips.add(new JLabel("SPACE to reset count"));
        keyTips.add(new JLabel("press T on the beat"));
        keyTips.add(new JLabel("Arrow LEFT and Right to change offset"));

        for (JLabel l : keyTips){
            panel.add(l);
        }

        panel.setLayout(new GridLayout(1,keyTips.toArray().length));

        Handler.setBpm(bpm);
        for (int i = 0;i<boxes.length;i++) {
            boxes[i]=new IlluminatedBox(bpm);
            int x = (boxes[i].width*i)-2*(boxes[i].width)+boxes[i].width/2;
            boxes[i].setLocation(x,0);
        }
    }

    @Override
    public void tick() {
        if (lastCtrlTap+500<System.currentTimeMillis()){
            ctrlPressed=false;
        }

        if (!range.isEmpty()) {
            while (range.toArray().length >128){
                range.remove(0);
            }
            long media = 0;
            for (long l : range) {
                media += l;
            }
            media /= range.toArray().length;
            float bpm = (float) (media*Math.pow(10,-9));
            bpm=60/bpm;
            this.bpm=bpm;
        }
    }

    @Override
    public void bpmTick(int age) {
        if (lastBpm!=bpm){
            text.textField.setText(String.valueOf(bpm));
        }
        lastBpm=bpm;
        if (age%16==0||(ctrlPressed&&age%8==0)){
            if (bAge==0){
                boxes[0].spawnAll();
            } else if (bAge==1){
                boxes[1].spawnAll();
            } else if (bAge==2){
                boxes[2].spawnAll();
            } else if (bAge==3) {
                boxes[3].spawnAll();
                bAge=-1;
            }
            bAge++;
        }
        Handler.setBpm(bpm);
    }

    @Override
    public void open() {
        spawnAll();
        text.spawnAll();
        handler.panel.add(panel,BorderLayout.CENTER);
    }

    @Override
    public void close() {
        handler.bpm=bpm;
        killAll();
        text.killAll();
        for (IlluminatedBox b:boxes) {
            b.killAll();
        }
        handler.panel.remove(panel);
    }

    @Override
    public String getName() {
        return "Tap Bpm";
    }

    @Override
    public void onHandlerSave() {
        handler.bpm=bpm;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_T){
            if (lastNanoTap ==0){lastNanoTap =System.nanoTime();return;}
            deltaNanoTap = System.nanoTime()-lastNanoTap;
            lastNanoTap=System.nanoTime();
            if (deltaNanoTap>3000000000L&&!range.isEmpty()){
                deltaNanoTap = range.get(range.toArray().length-1);
            } else {
                range.add(deltaNanoTap);
            }
        } else if (e.getKeyCode()==KeyEvent.VK_SPACE){
            lastNanoTap=0;
            range=new ArrayList<>();
        } else if(e.getKeyCode()==KeyEvent.VK_CONTROL){
            ctrlPressed=true;
            lastCtrlTap=System.currentTimeMillis();
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            Handler.bpmAge++;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            Handler.bpmAge--;
        }
    }

    private class IlluminatedBox extends GameObject implements BpmTicable {
        private float bpm;

        private IlluminatedBox(float bpm){
            super(Anchor.ANCHOR_MIDDLE);
            setBounds(100,50);
            this.bpm=bpm;
        }

        @Override
        public void spawnAll() {
            killAll();
            super.spawnAll();
            animation.finishAll();
            setOpacity(1);
            animation.addFrame(new KeyFrame((int) (5000/bpm),0,0,0,0,-1));
        }

        @Override
        public void bpmTick(int age) {
            if (getOpacity()<=0){
                killAll();
            }
        }

        @Override
        public void renderDrawImage(Graphics2D g2d) {
            g2d.setColor(Color.black);
            g2d.fillRect(-5,-5,width+10,height+10);
            g2d.setColor(RainbowColor.rainbowColor(0));
            g2d.fillRect(0,0,width,height);
        }
    }
}
