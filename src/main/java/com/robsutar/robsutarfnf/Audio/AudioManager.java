package com.robsutar.robsutarfnf.Audio;

import javax.sound.sampled.Clip;

public class AudioManager {
    private final Clip audio;
    public AudioManager(Clip audio){
        this.audio=audio;
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
}
