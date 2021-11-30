package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Objects.StartMenu;
import com.robsutar.robsutarfnf.RenderableObjects.Objects.StartMenuOption;

public class StartMenuHandler extends Handler{
    public StartMenuHandler(){
        addObject(new StartMenuOption(Main.getWindowDim().width/2,Main.getWindowDim().height/2, Assets.AssetsImages.START_MENU_OPTION));
        addObject(new StartMenu());
    }
}
