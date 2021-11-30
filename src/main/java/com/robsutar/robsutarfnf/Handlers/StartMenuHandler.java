package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Objects.StartMenu;
import com.robsutar.robsutarfnf.RenderableObjects.Objects.StartMenuOption;

public class StartMenuHandler extends Handler{
    public StartMenuHandler(){
        addObject(new StartMenu());
    }
}
