package com.robsutar.robsutarfnf.Fnf.Phase;

import com.robsutar.robsutarfnf.Engine.Audio.Music;
import com.robsutar.robsutarfnf.Fnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Fnf.GameObjects.Player;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.TapBpm;

import java.util.ArrayList;
import java.util.List;

public class PhaseHandler {
    public String mapTitle;
    public String mapAuthor;
    public float approximatingRate;
    public Music music;
    public List<AnimatedObject> animatedObjects = new ArrayList<>();
    public Player player1;
    public Player player2;

    public PhaseHandler(){
        TapBpm tp=new TapBpm(this);
        tp.open();
    }
}
