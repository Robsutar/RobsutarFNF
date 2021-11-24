package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Camera;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class StartMenu extends Box{

    private List<Camera.CameraState> states= new ArrayList<>();

    private boolean approximate = false;

    public StartMenu(PositionType type,AnimatedObject animatedObject) {
        super(type,animatedObject);
        for (int i = 0; i < 10;i++){
            states.add(new Camera.CameraState(-(i*20+i),0,0,1+i/25.0));
        }
    }

    @Override
    public void pressed(MouseEvent e) {
        setScale(getScale()+0.1);

        Main.camera = new Camera(states, Main.getWindowDim().width, Main.getWindowDim().height, 1, approximate);
        approximate = !approximate;
    }

    @Override
    public void released(MouseEvent e) {
    }

    @Override
    protected void tick() {
        if (isInto()){
            setScale(0.1);
        } else {
            setScale(0);
        }
    }

    @Override
    protected void renderer(Graphics2D g2d) {
        super.renderer(g2d);
    }
}
