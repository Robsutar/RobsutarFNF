package com.robsutar.robsutarfnf.Movement;

import com.robsutar.robsutarfnf.Box;
import com.robsutar.robsutarfnf.Menus.TitleMenu.TitleOptions;

public class KeyFrame {
    private int age = 0;
    int tickLength;int frameX; int frameY;double scale;double rotation;float opacity;
    public KeyFrame (int tickLength,int frameX, int frameY,double scale,double rotation,float opacity){
        this.tickLength=tickLength;this.frameX=frameX;this.frameY=frameY;
        this.scale=scale;this.rotation=rotation;this.opacity=opacity;
    }
    public boolean tick(Box object){
        if (age<tickLength) {
            int x = (int) (object.getX() + (frameX / tickLength) * 1.0);
            int y = (int) (object.getY() + (frameY / tickLength) * 1.0);
            double s = object.getScale()+(scale/tickLength);
            double r = object.getRotation()+(rotation / tickLength);
            float o = object.getOpacity()+(opacity / tickLength);
            object.setLocation(x, y);
            object.setScale(s);
            object.setRotation(r);
            object.setOpacity(o);
            age++;
            return true;
        }
        return false;
    }

    public KeyFrame reverse(){
        return new KeyFrame(tickLength,-frameX,-frameY,-scale,-rotation,-opacity);
    }
}
