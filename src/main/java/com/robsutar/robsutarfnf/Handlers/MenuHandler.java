package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Menus.StartMenu;

public class MenuHandler extends Handlers{
    public  MenuHandler(){
        AnimatedObject animatedObject = new AnimatedObject(Main.phasesPath+"lianna/lianna-Config.json");
        StartMenu box = new StartMenu(50,50,100,100, animatedObject);
        addRenderableObject(box);
    }
    @Override
    protected void tick() {
    }

    @Override
    protected void bpm() {
    }
}
