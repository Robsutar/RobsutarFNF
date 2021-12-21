package com.robsutar.robsutarfnf.Audio;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioManager {
    private final Clip audio;
    private final FloatControl fc;
    private float volume=80;

    public AudioManager(Clip audio){
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
    public void start(){
        audio.start();
    }
    public void startAt(int frame){
        audio.setFramePosition(frame);
    }
    public int getFrame(){
        return audio.getFramePosition();
    }
    public void setVolume(float max86){
        this.volume=max86;
        if (volume>86f){
            volume=86f;
        } else if(volume<0f){
            volume=0;
        }
        fc.setValue(volume-80f);
    }
}
