package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;


public class StartMenu extends Box{

    public StartMenu(int x, int y, int width, int height,AnimatedObject animatedObject) {
        super(x, y, width, height,animatedObject);
        isAnimated(true);
    }
    @Override
    public void tick(){
        setState(getAge()/20);
    }
}
