package com.robsutar.robsutarfnf.Handlers;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.RenderableObjects.Menus.StartMenu;
import com.robsutar.robsutarfnf.RenderableObjects.Position;

public class MenuHandler extends Handlers{
    public  MenuHandler(){
        AnimatedObject startMenuMain = new AnimatedObject(Assets.AssetsXml.GF_DANCE);
        StartMenu box = new StartMenu(Position.PositionType.MIDDLE,startMenuMain);
        if (box.getMenuOptions()!=null){
            for (StartMenu.MenuOptions m :box.getMenuOptions()
                 ) {
                addRenderableObject(m);
            }
        }
        addRenderableObject(box);
    }
}
