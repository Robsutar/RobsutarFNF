package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Camera;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class StartMenu extends Box{

    private final List<Camera.CameraState> states= new ArrayList<>();

    List<MenuOptions> menuOptions;

    private boolean approximate = false;

    public StartMenu(PositionType type,AnimatedObject animatedObject/*,BufferedImage optionsImage*/) {
        super(type,animatedObject);
        for (int i = 0; i < 10;i++){
            states.add(new Camera.CameraState(-(i*20+i),0,0,1+i/25.0));
        } //click action positions

        MenuOptions optionsWeeks = new MenuOptions(optionsEvents.weeks, Assets.AssetsTextures.START_MENU_OPTION);
        MenuOptions optionsFreeplay = new MenuOptions(optionsEvents.freeplay, Assets.AssetsTextures.START_MENU_OPTION);
        MenuOptions optionsCredits = new MenuOptions(optionsEvents.credits, Assets.AssetsTextures.START_MENU_OPTION);
        MenuOptions optionsDonate = new MenuOptions(optionsEvents.donate, Assets.AssetsTextures.START_MENU_OPTION);

        menuOptions = new ArrayList<>();

        menuOptions.add(optionsWeeks);
        menuOptions.add(optionsFreeplay);
        menuOptions.add(optionsCredits);
        menuOptions.add(optionsDonate);

        int list = -400;
        for (MenuOptions m:menuOptions
             ) {
            m.setX(animatedObject.getWidth());
            m.setY(animatedObject.getHeight()/2+list);
            m.setWidth(m.getImage().getWidth());
            m.setHeight(m.getImage().getHeight());
            list+=200;
        }

    }

    public List<MenuOptions> getMenuOptions() {
        return menuOptions;
    }

    @Override
    public void pressed(MouseEvent e) {
        Main.camera = new Camera(states, Main.getWindowDim().width, Main.getWindowDim().height, approximate);
        approximate = !approximate;
    }

    @Override
    public void released(MouseEvent e) {
    }

    private enum optionsEvents{
        weeks(),
        freeplay(),
        credits(),
        donate(),
    }

    public static class MenuOptions extends Box {
        optionsEvents event;
        public MenuOptions(optionsEvents event, BufferedImage img) {
            super(null, img);
            this.event=event;
        }

        @Override
        public void pressed(MouseEvent e) {
            switch (event){
                case weeks:
                    System.out.println(event);
                    break;
                case freeplay:
                    System.out.println(event);
                    break;
                case credits:
                    System.out.println(event);
                    break;
                case donate:
                    System.out.println(event);
                    break;
            }
        }

        @Override
        public void released(MouseEvent e) {
        }

    }
}
