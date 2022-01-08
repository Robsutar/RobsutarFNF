package com.robsutar.robsutarfnf.Phase.PhaseCreator;

import com.robsutar.robsutarfnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Files.FileManager;
import com.robsutar.robsutarfnf.GameObjects.AnimatedObject;
import com.robsutar.robsutarfnf.Window.Anchor.AnchorTypes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.sound.sampled.Clip;
import java.io.File;

public class PhaseJson {
    String mapAuthor; String musicAuthor; Atlas player1; Atlas player2; Clip music; Clip voices; JSONObject phaseObjects;

    public PhaseJson(String mapAuthor, String musicAuthor, Atlas player1, Atlas player2, Clip music, Clip voices, JSONObject phaseObjects){
        this.mapAuthor=mapAuthor;this.musicAuthor=musicAuthor;this.player1=player1;this.player2=player2;
        this.music=music;this.voices=voices;this.phaseObjects=phaseObjects;

        System.out.println(mapAuthor+"\n"+musicAuthor+"\n"+player1+"\n"+player2+"\n"+music+"\n"+voices+"\n"+phaseObjects);

        AnimatedObject p2 = new AnimatedObject(AnchorTypes.ANCHOR_MIDDLE,player2);
        p2.spawnAll();
        AnimatedObject p1 = new AnimatedObject(AnchorTypes.ANCHOR_MIDDLE,player1);
        p1.spawnAll();
    }

    public static PhaseJson readPhaseConfigs(File file){
        JSONObject object = FileManager.loadJson(file);

        JSONObject phaseConfigs = (JSONObject) object.get("phaseConfigs");
        JSONObject credits = (JSONObject) phaseConfigs.get("credits");
        JSONObject filePaths = (JSONObject) phaseConfigs.get("filePaths");

        String musicPath = (String) filePaths.get("music");
        String voicesPath = (String) filePaths.get("voices");
        String player1PathXml = "/characters/robot.xml";
        String player2PathXml = "/characters/ankha_assets.xml";
        String mapFolder = file.getParent()+"/";

        String mapAuthor= (String) credits.get("mapAuthor");
        String musicAuthor= (String) credits.get("musicAuthor");

        Atlas player1 = new Atlas(FileManager.loadFile(mapFolder+player1PathXml));
        Atlas player2 = new Atlas(FileManager.loadFile(mapFolder+player2PathXml));

        Clip music = FileManager.loadWav(FileManager.loadFile(mapFolder+musicPath));
        Clip voices = FileManager.loadWav(FileManager.loadFile(mapFolder+voicesPath));

        JSONObject phaseObjects = (JSONObject) phaseConfigs.get("phaseObjects");

        return  new PhaseJson(mapAuthor,musicAuthor,player1,player2,music,voices,phaseObjects);
    }

    public static JSONObject writePhaseConfigs(){
        String mapAuthor="Robsutar";
        String musicAuthor="RWBY";
        String musicPath = "sounds/liannaMusic.wav";
        String voicesPath = "sounds/liannaVoices.wav";
        String player1PathXml = "characters/robot.xml";
        String player2PathXml = "characters/ankha_assets.xml";

        JSONObject phaseJson = new JSONObject(); //Out file

        //Credits
        JSONObject credits = new JSONObject();
        credits.put("mapAuthor",mapAuthor);
        credits.put("musicAuthor",musicAuthor);

        //FilePaths
        JSONObject filePaths = new JSONObject();
        filePaths.put("music",musicPath);
        filePaths.put("voices",voicesPath);
        filePaths.put("p1Xml",player1PathXml);
        filePaths.put("p2Xml",player2PathXml);

        //PhaesObjects
        JSONObject phaseObjects = new JSONObject();
        JSONArray phaseArrows = new JSONArray();
        phaseArrows.add("standard:w");
        phaseArrows.add("standard:d");
        phaseArrows.add("standard:s");
        phaseArrows.add("standard:a");
        phaseObjects.put("phaseArrows",phaseArrows);

        phaseJson.put("credits",credits);
        phaseJson.put("filePaths",filePaths);
        phaseJson.put("phaseObjects",phaseObjects);

        JSONObject outFile = new JSONObject();
        outFile.put("phaseConfigs",phaseJson);
        return outFile;
    }
}
