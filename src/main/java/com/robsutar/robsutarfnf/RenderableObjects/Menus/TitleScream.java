package com.robsutar.robsutarfnf.RenderableObjects.Menus;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Assets.MenuAssets;
import com.robsutar.robsutarfnf.Assets.StaticAssets;
import com.robsutar.robsutarfnf.Graphics.StringManipulator;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TitleScream extends AnimatedObject {

    MenuAssets assets;
    private boolean atZoom=false;

    private List<TitleScreamOption> options = new ArrayList<>();
    public TitleScream(MenuAssets assets) {
        super(0,0, assets.GF_DANCE_TITLE);
        this.assets = assets;
        moveByCenter(Main.WIDTH/2,Main.HEIGHT/2);
        spawn();

        options.add(new TitleScreamOption(Main.WIDTH-Main.WIDTH/3,Main.HEIGHT/2,assets.MENU_OPTION,this));
    }

    @Override
    public void spawn() {
        super.spawn();
        mouseISpawn();
    }

    @Override
    public void onMousePressed() {
        System.out.println("1");
    }

    @Override
    protected void onMouseReleased() {
        System.out.println("2");
    }

    @Override
    public void render(Graphics2D g2d) {
        super.render(g2d);
    }
}
