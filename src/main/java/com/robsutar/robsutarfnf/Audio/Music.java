package com.robsutar.robsutarfnf.Audio;

import javax.sound.sampled.Clip;

public class Music extends AudioManager{
    private final int bpm;

    public Music(Clip audio, int bpm) {
        super(audio);
        this.bpm=bpm;
    }

    public float getBpm() {return bpm;}
}
