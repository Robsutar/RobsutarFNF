package com.robsutar.robsutarfnf.Engine.Menus.Forms;

import javax.swing.*;
import java.awt.*;

public class FormsTextField extends FormsAnswer{

    private final JTextField textField = new JTextField(20);

    public FormsTextField(String labelText, String textFieldText){
        super(labelText);
        textField.setText(textFieldText);

        addComponentsToPanel();
    }

    public JTextField getTextField(){
        return this.textField;
    }

    @Override
    protected void addComponentsToPanel(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(getLabel(),BorderLayout.LINE_END);

        panel.setLayout(new BorderLayout());
        panel.add(labelPanel,BorderLayout.CENTER);
        panel.add(getComponent(),BorderLayout.LINE_END);
    }

    @Override
    protected String getAnswer() {
        if (textField.getText().length()>0){
            return textField.getText();
        }
        return null;
    }

    @Override
    protected JComponent getComponent() {
        return getTextField();
    }
}
