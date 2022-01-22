package com.robsutar.robsutarfnf.Engine.Menus.Forms;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Forms extends JPanel {

    private final List<FormsAnswer> options;
    private final  JPanel handler;

    public Forms(List<FormsAnswer> options, JPanel jPanel){
        this.options = options;
        this.handler=jPanel;
        putForms();
        open();
    }

    private void putForms(){
        this.removeAll();
        for (FormsAnswer f:options){
            this.add(f.getPanel());
        }
        this.setLayout(new GridLayout(options.toArray().length,0));
    }

    public void open() {
        handler.add(this);
    }

    public void close(){
        handler.remove(this);
    }
}
