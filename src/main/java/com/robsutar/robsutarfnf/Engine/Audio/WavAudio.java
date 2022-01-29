package com.robsutar.robsutarfnf.Engine.Audio;

import com.robsutar.robsutarfnf.Engine.Handler;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class WavAudio {
    public final Clip audio;
    private final FloatControl fc;

    private boolean initialized = false;

    public WavAudio(Clip audio){
        this.audio=audio;
        this.fc=(FloatControl) audio.getControl(FloatControl.Type.MASTER_GAIN);
    }

    public void pauseOrStart(){
        if (audio.isActive()){
            pause();
        } else {
            start();
        }
    }
    public void pause(){
        audio.stop();
    }
    public void start(){if(!initialized){initialize();}audio.start();}

    public void initialize(){
        Handler.addObject(this.fc);
        fc.setValue(Handler.getValidVolume(Handler.volume));
        initialized=true;
    }

    public void stop(){
        pause();
        Handler.removeObject(this.fc);
    }
    public void startAt(int frame){
        audio.setFramePosition(frame);
    }
    public int getFrame(){
        return audio.getFramePosition();
    }
}
