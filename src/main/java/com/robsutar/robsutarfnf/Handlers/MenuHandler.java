package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.RenderableObjects.Menus.StartMenu;

public class MenuHandler extends Handlers{
    public  MenuHandler(){
        StartMenu box = new StartMenu(50,50,100,100);
        addRenderableObject(box);
    }
    @Override
    protected void tick() {
    }
}
