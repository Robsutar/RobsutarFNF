package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.RenderableObjects.Box;

import java.util.ArrayList;
import java.util.List;

public class Animation {
    private List<KeyFrame> frameList = new ArrayList<>();
    private final Box object;
    public Animation(Box object){
        this.object=object;
    }

    public void tick(){
        if (!frameList.isEmpty()){
            KeyFrame animation = frameList.get(0);
            if (!animation.keyTick(object)){
                frameList.remove(0);
            }
        }
    }

    public void finish(KeyFrame kframe ){
        frameList.remove(kframe);
    }

    public void finish(){
        if (!frameList.isEmpty()){
            KeyFrame animation = frameList.get(0);
            while ( animation.keyTick(object)){
            }
            frameList.remove(0);
        }
    }

    public void finishAll(){
        while (!frameList.isEmpty()){
            KeyFrame animation = frameList.get(0);
            while ( animation.keyTick(object)){
            }
            frameList.remove(0);
        }
    }

    public void addAnimation(KeyFrame kframe){
        kframe.reset();
        this.frameList.add(kframe);
    }

    public void playAnimation(KeyFrame kframe){
        finishAll();
        addAnimation(kframe);
    }
}
