package com.robsutar.robsutarfnf.Engine.Menus.Texts;

import com.robsutar.robsutarfnf.Engine.Box;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Threads.FullSpawn;
import com.robsutar.robsutarfnf.Engine.Threads.Ticable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditableText extends Box implements Ticable {
    public JTextField textField;
    String text ;
    public EditableText(Anchor anchor, String text, int x, int y, ActionListener action){
        this.text=text;
        setLocation(x,y);
        if (action==null){
            action = e -> {
                textField.setEnabled(false);
                textField.setEnabled(true);
            };
        }
        this.anchor=anchor;
        textField = new JTextField(text);
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(Handler.font);
        textField.addActionListener(action);
    }

    @Override
    public void tick() {
        textField.setBounds(x + anchor.getX() - width / 2, y + anchor.getY() - height / 2 - Handler.metrics.getAscent(), width, height);
    }

    @Override
    public void spawnAll() {
        height= (int) (Handler.metrics.getHeight()*1.3);
        width = Handler.metrics.stringWidth(" " + text + " ")*2;
        textField.setBounds(x + anchor.getX() - width / 2, y + anchor.getY() - height / 2 - Handler.metrics.getAscent(), width, height);
        Ticable.super.spawnAll();
        Handler.addObject(textField);
    }

    @Override
    public void killAll() {
        Ticable.super.killAll();
        Handler.removeObject(textField);
    }
}
