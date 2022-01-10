package com.robsutar.robsutarfnf.Engine.Movement;

import com.robsutar.robsutarfnf.Engine.Box;

import java.util.ArrayList;
import java.util.List;

public class MovementStream {
    private final List<KeyFrame> frames = new ArrayList<>();
    private final Box object;

    private boolean paused = false;
    private boolean boomerang = false;

    public MovementStream(Box object){
        this.object=object;
    }

    public void addFrame(KeyFrame k){
        this.frames.add(k);
    }

    public void playNow(KeyFrame k){
        replaceAnimation(k);
    }

    public void replaceAnimation(KeyFrame k){
        if(!frames.isEmpty()) {
            KeyFrame f = frames.get(0);
            while (!f.tick(object)) {
                frames.remove(f);
            }
            frames.set(0,k);
        }
    }

    public void tick(){
        if (!paused) {
            if(!frames.isEmpty()) {
                KeyFrame f = frames.get(0);
                if(!f.tick(object)) {
                    frames.remove(f);
                    if (boomerang) {
                        frames.add(f.reverse());
                    }
                }
            }
        }
    }

    public void finishAnimation(){
        if(!frames.isEmpty()) {
            KeyFrame f = frames.get(0);
            while (f.tick(object)) {
            }
            frames.remove(f);
        }
    }

    public void finishAll(){
        while (!frames.isEmpty()) {
            KeyFrame f = frames.get(0);
            while (f.tick(object)) {
            }
            frames.remove(f);
        }
    }

    public void pauseOrStop(){
        this.paused=!paused;
    }

    public void pause (){
        this.paused = true;
    }
    public void start (){
        this.paused=false;
    }

    public void setBoomerang(boolean boomerang) {
        this.boomerang = boomerang;
    }
}
