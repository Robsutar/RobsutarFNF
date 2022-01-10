package com.robsutar.robsutarfnf.Fnf.Phase;

import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.PhaseJson;
import com.robsutar.robsutarfnf.Engine.Threads.BpmTicable;

public class PhaseHandler implements BpmTicable {
    private final PhaseJson phase;

    public PhaseHandler(PhaseJson phase){
        this.phase=phase;
    }

    public void start(){
        Handler.setBpm(phase.music.getBpm());
        spawnBpmTick();
        phase.music.initialize();
        phase.music.start();

    }

    @Override
    public void bpmTick(int age) {

    }
}
