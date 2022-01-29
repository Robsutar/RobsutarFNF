package com.robsutar.robsutarfnf.Engine.Audio;

import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.SystemPrinter;

import java.io.File;

public class Music extends WavAudio{
    public final File file;

    public Music(File file) {
        super(FileManager.loadWav(file));
        this.file=file;
    }

    public String getName() {
        return file.getName();
    }

    public long getActualPosition(long maxPercent){
        return audio.getMicrosecondPosition() *maxPercent/ audio.getMicrosecondLength();
    }

    public void setPosition(long actualPercent,long maxPercent){
        long dx = actualPercent *audio.getMicrosecondLength()/maxPercent;
        audio.setMicrosecondPosition(dx);
    }

    public double getBeatLength(float bpm){
        return (audio.getMicrosecondLength()*Math.pow(10,-6)/60*bpm);
    }
}
