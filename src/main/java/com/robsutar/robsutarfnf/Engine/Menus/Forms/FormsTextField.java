package com.robsutar.robsutarfnf.Engine.Menus.Forms;

import javax.swing.*;

public class FormsTextField extends FormsAnswer{

    private final JTextField textField = new JTextField();

    public FormsTextField(String labelText, String textFieldText){
        super(labelText);
        textField.setText(textFieldText);

        addComponentsToPanel();
    }

    public JTextField getTextField(){
        return this.textField;
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
