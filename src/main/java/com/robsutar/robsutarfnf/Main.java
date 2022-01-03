package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Window.Window;

public class Main {
    public static void main(String[] args){
        Window.frame =new Window();
        new Assets(null);

        MegaDrive d = new MegaDrive(Window.wdt()/2,Window.hgt()/2,Assets.GF_TITLE);
        d.spawnAll();
    }
}
