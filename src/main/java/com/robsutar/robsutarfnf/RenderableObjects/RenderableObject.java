package com.robsutar.robsutarfnf.RenderableObjects;

import java.awt.*;

public abstract class RenderableObject extends Position{
    private int age;
    private int ageLimit=2134567893;

    private boolean immortal;
    private boolean alive;


    public RenderableObject(){
        this.immortal=true;
    }
    public RenderableObject(int ageLimit){
        this.ageLimit=ageLimit;
    }

    public void onRenderer(Graphics2D g2d){
        if (immortal||age<ageLimit) {
            age++;
            renderer(g2d);
            tick();
        }
    }

    protected abstract void renderer(Graphics2D g2d);

    protected abstract void tick();

    public int getAge() {
        return age;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public boolean isImmortal() {
        return immortal;
    }

    public boolean isAlive() {
        return alive;
    }
}
