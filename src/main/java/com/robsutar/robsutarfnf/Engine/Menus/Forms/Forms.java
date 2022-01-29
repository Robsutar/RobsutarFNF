package com.robsutar.robsutarfnf.Engine.Menus.Forms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Forms extends JDialog {

    JPanel panel = new JPanel();

    public JButton ok = new JButton("ok");

    public JButton cancel = new JButton("cancel");

    private List<FormsAnswer> forms;

    public Forms(String formsTitle, JFrame handler, int width, int height, List<FormsAnswer> forms, ActionListener act){
        super(handler,true);
        setSize(width,height);
        setTitle(formsTitle);
        setConfigs();

        ok.addActionListener(e -> {
            if (formsCheckout()){
                act.actionPerformed(e);
                close();
            }
        });

        addForms(forms);
        addButtons();
        add(panel,BorderLayout.NORTH);
    }

    private void addButtons() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,2));
        p.add(ok);
        p.add(cancel);
        panel.add(p);
    }

    private boolean formsCheckout(){
        for(FormsAnswer f:forms){
            if (!f.canPass()){
                f.highlight();
                return false;
            }
            f.unHighlight();
        }
        return true;
    }

    private void addForms(List<FormsAnswer> forms){
        this.forms=forms;
        for (FormsAnswer f:forms){
            panel.add(f.getPanel());
        }
        panel.setLayout(new GridLayout(forms.toArray().length+2/* +2 because of the buttons*/,1));
    }

    private void setConfigs(){
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panel.setBorder(new EmptyBorder(15,15,15,15));
    }

    public void open(){
        this.setVisible(true);
    }
    public void close(){
        this.dispose();
    }
}
