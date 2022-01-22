package com.robsutar.robsutarfnf.Engine.Audio;

import javax.sound.sampled.Clip;

public class Music extends WavAudio{
    private float bpm;

    public Music(Clip audio, float bpm) {
        super(audio);
        this.bpm=bpm;
    }

    public float getBpm() {return bpm;}

    public void setBpm(float bpm) {
        this.bpm=bpm;
    }
}
