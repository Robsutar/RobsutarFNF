package com.robsutar.robsutarfnf.Editor;

import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Interface.KeyboardInteractive;
import com.robsutar.robsutarfnf.Interface.MouseInteractive;
import com.robsutar.robsutarfnf.Interface.Ticable;
import com.robsutar.robsutarfnf.RenderableObjects.AnimatedObject;
import com.robsutar.robsutarfnf.RenderableObjects.Box;
import com.robsutar.robsutarfnf.RenderableObjects.SimpleText;

import java.awt.event.KeyEvent;
import java.util.List;

public class AnimatedObjectReadjust implements MouseInteractive, Ticable, KeyboardInteractive {
    private final AnimatedObject front;
    private final AnimatedObject background;

    private final List<Box> readjustPos;

    private int actualX,actualY;

    public AnimatedObjectReadjust(AnimatedObject object){
        readjustPos=object.getReadjustPos();

        background = new AnimatedObject(object);

        front = new AnimatedObject(object);

        background.setOpacity(0.5f);

        spawnMouseInteractive();spawnTick();spawnKeyboardTick();

        front.setAnimationIndex(front.getAnimationIndex()+1);

        front.setPriority(background.getPriority()+1);
        background.spawn();
        front.spawn();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 65) {
            front.setAnimationIndex(front.getAnimationIndex()-1);
            background.setAnimationIndex(background.getAnimationIndex()-1);
        } else if(e.getKeyCode() == 68) {
            front.setAnimationIndex(front.getAnimationIndex()+1);
            background.setAnimationIndex(background.getAnimationIndex()+1);
        } else if (e.getKeyCode()==10){
            SimpleText saved = new SimpleText((int)background.getCenterX(),(int)background.getHeight(),"&#Sa&#ve&#d!");
            saved.disappear = true;
            saved.spawn();

            Box b = background.getReadjustPos().get(front.getAnimationIndex());

            b.setLocation((int)b.getX()-actualX,(int)b.getY()-actualY);

            background.getReadjustPos().get(front.getAnimationIndex()).setLocation(b.getLocation());

            background.setAnimationIndex(background.getAnimationIndex()+1);
            front.setAnimationIndex(front.getAnimationIndex()+1);
        } else if (e.getKeyCode()==32){
            SimpleText saved = new SimpleText((int)background.getCenterX(),(int)background.getHeight(),"&1Saving &2Json &7File");
            saved.disappear = true;
            saved.spawn();

            JsonFiles.writeBaseTransform(background.getReadjustPos(),background.getFullImagePath().replace("png","json"));
        }
    }

    @Override
    public void mouseDragged(int xDistance, int yDistance) {
        int distX = (int)background.getX()-xDistance;
        int distY = (int)background.getY()-yDistance;

        front.setLocation(distX,distY);

        actualX = xDistance;
        actualY = yDistance;
    }
}
