package com.robsutar.robsutarfnf.Engine.Menus.Forms;

import javax.swing.*;
import java.awt.*;

public abstract class FormsAnswer {
    protected final JLabel label;
    protected final JPanel panel;

    public FormsAnswer(String labelText){
        label = new JLabel(labelText);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
    }
    protected void addComponentsToPanel(){
        panel.add(getLabel(),BorderLayout.WEST);
        panel.add(getComponent(),BorderLayout.EAST);
    }

    public JLabel getLabel() {
        return label;
    }

    public JPanel getPanel() {
        return panel;
    }

    protected abstract Object getAnswer();

    protected abstract JComponent getComponent();
}
