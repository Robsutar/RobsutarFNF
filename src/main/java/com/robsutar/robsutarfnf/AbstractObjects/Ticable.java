package com.robsutar.robsutarfnf.AbstractObjects;

public abstract class Ticable {

    protected int age;
    protected int agelimit = 2147483640;

    private boolean alive=true;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setAgelimit(int limit){this.agelimit=limit;}

    public int getAge(){return this.age;}

    public void onTick(){
        if (age<agelimit&&isAlive()){
            age++;
            tick();
        } else{setAlive(false);}
    }

    protected abstract void tick();
}
