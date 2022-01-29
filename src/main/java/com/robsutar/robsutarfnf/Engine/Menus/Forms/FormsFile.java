package com.robsutar.robsutarfnf.Engine.Menus.Forms;

import com.robsutar.robsutarfnf.Engine.Files.FileManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FormsFile extends FormsAnswer{
    private final JButton button = new JButton();
    public File file;

    public FormsFile(String labelText, FileNameExtensionFilter filter){
        super(labelText);
        button.setText("select file...");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file = FileManager.loadExplorerFile(filter);
                if (file!=null) {
                    button.setText(file.getName());
                }
            }
        });

        addComponentsToPanel();
    }

    @Override
    protected void addComponentsToPanel() {
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        east.setLayout(new BorderLayout());
        west.setLayout(new BorderLayout());

        east.add(getComponent(),BorderLayout.WEST);
        west.add(getLabel(),BorderLayout.EAST);

        panel.setLayout(new GridLayout(1,2));
        panel.add(west);
        panel.add(east);
    }

    public JButton getButton(){
        return this.button;
    }

    @Override
    public File getAnswer() {
        return file;
    }

    @Override
    protected JComponent getComponent() {
        return getButton();
    }

    @Override
    public void setAnswer(Object answer) {
        if (answer instanceof File){
            this.file= (File) answer;
            button.setText(file.getName());
        }
    }
}
