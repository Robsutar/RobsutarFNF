package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.GameObjects.GameObject;
import com.robsutar.robsutarfnf.Graphics.Camera;
import com.robsutar.robsutarfnf.Movement.KeyFrame;
import com.robsutar.robsutarfnf.Window.Window;

public class Main {
    public static void main(String[] args){
        Window.frame =new Window();
        new Assets(null);

        Camera.getCamera().animation.addFrame(new KeyFrame(100,500,0,0.3,0,0));
        Camera.getCamera().animation.setBoomerang(true);

        MegaDrive d = new MegaDrive(Window.wdt()/2,Window.hgt()/2,Assets.GF_TITLE);
        GameObject o = new GameObject(Window.wdt()/2,Window.hgt()/2);
        d.animation.addFrame(new KeyFrame(1000,0,0,0,0,-0.3f));
        d.animation.setBoomerang(true);
        o.setImage(Assets.BACKGROUND,true);
        o.spawnAll();
        d.spawnAll();
    }
}
