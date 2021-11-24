package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Menus.StartMenu;
import com.robsutar.robsutarfnf.RenderableObjects.Position;

public class MenuHandler extends Handlers{
    public  MenuHandler(){
        AnimatedObject animatedObject = new AnimatedObject(Main.phasesPath+"lianna/lianna-Config.json");
        StartMenu box = new StartMenu(Position.PositionType.MIDDLE,animatedObject);
        addRenderableObject(box);
    }
}
