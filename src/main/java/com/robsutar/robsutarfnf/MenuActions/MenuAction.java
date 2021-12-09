package com.robsutar.robsutarfnf.MenuActions;

public abstract class MenuAction {
    public void action(){
        onAction();
    }
    protected abstract void onAction();
}
