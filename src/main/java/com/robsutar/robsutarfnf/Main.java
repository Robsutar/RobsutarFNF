package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Menus.TitleMenu.TitleMenu;
import com.robsutar.robsutarfnf.Window.Window;

public class Main {
    public static void main(String[] args){
        Window.frame =new Window();
        new Assets(null);

        TitleMenu tMenu=new TitleMenu();
        tMenu.spawnAll();
    }
}
