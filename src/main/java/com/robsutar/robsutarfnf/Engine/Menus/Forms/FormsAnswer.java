package com.robsutar.robsutarfnf.Engine.Menus.Forms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class FormsAnswer {
    protected final JLabel label;
    protected final JPanel panel;
    protected boolean required;

    public FormsAnswer(String labelText){
        label = new JLabel(labelText);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
    }
    protected abstract void addComponentsToPanel();

    public void setRequired(boolean required) {
        this.required = required;
    }

    public JLabel getLabel() {
        return label;
    }

    public JPanel getPanel() {
        return panel;
    }

    protected abstract Object getAnswer();

    protected void highlight(){
        label.setForeground(Color.red);
    }
    protected void unHighlight(){
        label.setForeground(Color.black);
    }

    protected abstract JComponent getComponent();

    public boolean canPass(){
        if (required){
            return getAnswer() != null;
        }
        return true;
    }
}
