package com.robsutar.robsutarfnf.Menu;

import com.robsutar.robsutarfnf.Interface.BpmTicable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.SimpleText;

public class GameIntroduction implements BpmTicable {

    private SimpleText text = new SimpleText(Main.WIDTH/2,Main.HEIGHT/2,"&1ninja&2muffin&399");

    public GameIntroduction(){
        spawn();
    }

    public void spawn(){
        spawnBpm();
        Main.handler.setActualMusic(Main.mainAssets.INTRODUCTION_MUSIC);
    }
}
