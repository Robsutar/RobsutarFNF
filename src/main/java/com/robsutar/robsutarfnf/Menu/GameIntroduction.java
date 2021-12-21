package com.robsutar.robsutarfnf.Menu;

import com.robsutar.robsutarfnf.Interface.BpmTicable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.SimpleText;

public class GameIntroduction implements BpmTicable {
    private int age=0;

    private SimpleText text = new SimpleText(Main.WIDTH/2,Main.HEIGHT/2,"&1ninja&2muffin&399");

    public GameIntroduction(){
        spawn();
    }

    public void spawn(){
        spawnBpm();
        Main.handler.setActualMusic(Main.mainAssets.INTRODUCTION_MUSIC);
    }

    @Override
    public void bpmTick() {
        age++;
        if (age==1){
            text.spawn();
            text.vector.setScale(0.02);
        } else if (age==16*2.5){
            text.vector.setOpacity(-0.1f);
        }else if (age==16*4){
            text.setText("&#R&#o&#b&#s&#u&#t&#a&#r");
            text.setScale(1);
            text.setOpacity(1);
            text.vector.setScale(0.02);
            text.vector.setOpacity(0);
        }else if (age==16*6.5){
            text.vector.setOpacity(-0.1f);
        }
    }
}
