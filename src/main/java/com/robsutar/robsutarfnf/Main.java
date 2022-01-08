package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Files.FileManager;
import com.robsutar.robsutarfnf.GameObjects.GameObject;
import com.robsutar.robsutarfnf.Menus.TitleMenu.TitleMenu;
import com.robsutar.robsutarfnf.Phase.PhaseCreator.PhaseJson;
import com.robsutar.robsutarfnf.Window.Anchor.AnchorTypes;
import com.robsutar.robsutarfnf.Window.Window;

public class Main {
    public static void main(String[] args){
        Window.frame =new Window();
        new Assets(null);

        TitleMenu tMenu=new TitleMenu();
        tMenu.spawnAll();

        GameObject backg = new GameObject(AnchorTypes.ANCHOR_MIDDLE);
        backg.setImage(Assets.BACKGROUND,true);
        backg.setPriority(0);
        backg.spawnAll();

        FileManager.writeJson(FileManager.phasesPath+"lianna/","liannaPhase.json", PhaseJson.writePhaseConfigs());

        PhaseJson phaseJson = PhaseJson.readPhaseConfigs(FileManager.loadFile(FileManager.phasesPath+"lianna/"+"liannaPhase.json"));
    }
}
