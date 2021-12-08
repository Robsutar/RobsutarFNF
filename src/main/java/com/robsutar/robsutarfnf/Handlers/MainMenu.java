package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.Interfaces.Renderable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Menus.TitleScream;

public class MainMenu {
    public MainMenu(){
        TitleScream title = new TitleScream(0,0);
        title.moveByCenter(Main.WIDTH/2,Main.HEIGHT/2);
        title.spawn();
    }
}
