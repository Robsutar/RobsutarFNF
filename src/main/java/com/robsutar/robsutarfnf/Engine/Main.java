package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Window.Anchor.AnchorTypes;
import com.robsutar.robsutarfnf.Fnf.Menus.TitleMenu.TitleMenu;
import com.robsutar.robsutarfnf.Engine.Window.Window;
import com.robsutar.robsutarfnf.Fnf.Menus.TitleMenu.TitleOptions.TitleOptions;

public class Main {
    public static void main(String[] args){
        new Assets(null);
        Window.frame =new Window();

        TitleMenu titleMenu = new TitleMenu();
        titleMenu.spawnAll();
    }
}
