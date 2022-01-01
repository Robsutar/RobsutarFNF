package com.robsutar.robsutarfnf.Menu.TitleMenu;

import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.GameObject;
import com.robsutar.robsutarfnf.RenderableObjects.SimpleRenderable;
import com.robsutar.robsutarfnf.Types.PriorityTypes;

public class TitleMenu {
    private GfTitle gf = new GfTitle();
    private GameObject background = new GameObject(Main.WIDTH/2,Main.HEIGHT/2);

    public TitleMenu(){
        background.setImage(Main.mainAssets.WALLPAPER,true);
        background.setPriority(PriorityTypes.BACKGROUND);
    }

    public void spawn(){
        gf.spawn();
        background.spawn();
    }
    public void kill(){
        gf.kill();
        background.kill();
    }
}
