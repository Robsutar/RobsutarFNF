package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.Assets.MenuAssets;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TitleScream extends AnimatedObject {

    MenuAssets assets;
    private boolean atZoom=false;
    private int xOption = Main.WIDTH-Main.WIDTH/3;
    private int yOption = Main.HEIGHT/2;

    private List<TitleScreamOption> options = new ArrayList<>();

    public TitleScream(MenuAssets assets) {
        super(0,0, assets.GF_DANCE_TITLE);
        this.assets = assets;
        mouseInteractive=true;
        moveByCenter(Main.WIDTH/2,Main.HEIGHT/2);

        TitleScreamOption weeks = new TitleScreamOption(xOption,yOption,assets.MENU_OPTION,"Weeks");
        TitleScreamOption freeplay = new TitleScreamOption(xOption,yOption,assets.MENU_OPTION,"Freeplay");
        TitleScreamOption credits = new TitleScreamOption(xOption,yOption,assets.MENU_OPTION,"Credits");
        options.add(weeks);options.add(freeplay);options.add(credits);

        for (int i = 0; i < options.toArray().length;i++){
            TitleScreamOption o=options.get(i);
            o.moveByCenter(o.getX(),o.getY());
            o.spawn();
            o.oculte=true;
        }

        spawn();
    }

    @Override
    public void onMousePressed() {
    }

    @Override
    protected void onMouseReleased() {
        atZoom=!atZoom;
        if (atZoom){
            moveByCenter(Main.WIDTH/2,Main.HEIGHT/2);
            getVector().setX(-25);
            for (int i = 0; i < options.toArray().length;i++){
                TitleScreamOption o=options.get(i);
                o.oculte=false;
                o.moveByCenter(xOption,yOption);
                if (i%2==0) {
                    o.getVector().setY((10*i));
                } else {
                    o.getVector().setY(-(20*i));
                }
                if (i!=0) {
                    o.getVector().setX(15);
                } else {
                    o.getVector().setScale(0.1);
                    o.getVector().setX(10);
                }
            }
        } else {
            getVector().setX(25);
            for (int i = 0; i < options.toArray().length;i++){
                TitleScreamOption o=options.get(i);
                o.oculte=true;
                if (i%2==0) {
                    o.getVector().setY(-(10*i));
                } else {
                    o.getVector().setY((20*i));
                }
                if (i!=0) {
                    o.getVector().setX(-15);
                } else {

                    o.getVector().setScale(0);
                    o.getVector().setX(-10);
                }
            }
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
    }
}
