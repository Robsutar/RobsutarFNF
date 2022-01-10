package com.robsutar.robsutarfnf.Engine.Audio;

import javax.sound.sampled.Clip;

public class Music extends WavAudio{
    private final int bpm;

    public Music(Clip audio, int bpm) {
        super(audio);
        this.bpm=bpm;
    }

    public float getBpm() {return bpm;}
}
