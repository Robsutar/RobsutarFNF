package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Window.Window;

public class Main {
    public static void main(String[] args){
        Window.frame =new Window();
        new Assets(null);

        Handler.camera.animation.addFrame(new KeyFrame(100,0,0,360,0));
        Handler.camera.animation.addFrame(new KeyFrame(100,-0,-0,-360,0));

        MegaDrive d = new MegaDrive(Window.wdt()/2,Window.hgt()/2);
        d.setImage(Assets.BACKGROUND,true);
        d.spawnAll();
    }
}
