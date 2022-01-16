package com.robsutar.robsutarfnf.Engine.Menus.Texts;

import com.robsutar.robsutarfnf.Engine.Box;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Threads.FullSpawn;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditableText extends Box implements FullSpawn  {
    public JTextField textField;
    public EditableText(Anchor anchor, String text, int x, int y, ActionListener action){
        setLocation(x,y);
        if (action==null){
            action = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setEnabled(false);
                    textField.setEnabled(true);
                }
            };
        }
        this.anchor=anchor;
        textField = new JTextField(text);
        textField.setOpaque(true);
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(Handler.font);
        height= (int) (Handler.metrics.getHeight()*1.3);
        width = Handler.metrics.stringWidth(" " + text + " ")*2;
        textField.setBounds(x + anchor.getX() - width / 2, y + anchor.getY() - height / 2 - Handler.metrics.getAscent(), width, height);
        textField.addActionListener(action);
    }

    @Override
    public void spawnAll() {
        FullSpawn.super.spawnAll();
        Handler.addObject(textField);
    }

    @Override
    public void killAll() {
        FullSpawn.super.killAll();
        Handler.removeObject(textField);
    }
}
