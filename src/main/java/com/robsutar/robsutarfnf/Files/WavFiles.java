package com.robsutar.robsutarfnf.Files;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class WavFiles {
    public static Clip loadWav(String path){
        Clip clip = null;
        try {
            File file = new File(path);
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(stream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return clip;
    }
}
