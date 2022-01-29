package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator;

import com.robsutar.robsutarfnf.Engine.Audio.Music;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Fnf.AnimationBuilder.Atlas;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;

public class PhaseJson {

    public static void readPhaseConfigs(File jsonFile,PhaseHandler handler){

        JSONObject object = FileManager.loadJson(jsonFile);
        JSONObject phaseConfigs = (JSONObject) object.get("phaseConfigs");
        JSONObject credits = (JSONObject) phaseConfigs.get("credits");
        JSONObject filePaths = (JSONObject) phaseConfigs.get("filePaths");
        JSONObject phaseSettings = (JSONObject) phaseConfigs.get("phaseSettings");

        String musicPath = (String) filePaths.get("music");
        String p1Voice = (String) filePaths.get("p1Voice");
        String p2Voice = (String) filePaths.get("p2Voice");
        float musicBpm = Float.parseFloat(phaseSettings.get("bpm").toString());

        String mapAuthor= (String) credits.get("mapAuthor");
        String musicAuthor= (String) credits.get("musicAuthor");

        JSONObject phaseObjects = (JSONObject) phaseConfigs.get("phaseObjects");

        handler.phaseTitle = jsonFile.getParentFile().getName();
        handler.mapAuthor = mapAuthor;
        handler.musicAuthor = musicAuthor;
        handler.music = new Music(FileManager.loadFile(jsonFile.getParent()+"\\sounds\\"+musicPath));
        handler.p1Voice = new Music(FileManager.loadFile(jsonFile.getParent()+"\\sounds\\"+p1Voice));
        handler.p2Voice = new Music(FileManager.loadFile(jsonFile.getParent()+"\\sounds\\"+p2Voice));
        handler.bpm = musicBpm;
    }

    public static JSONObject writePhaseConfigs(PhaseHandler handler){
        String mapAuthor=handler.mapAuthor;
        String musicAuthor=handler.musicAuthor;
        String musicPath = handler.music.getName();
        String p1Voice = handler.p1Voice.getName();
        String p2Voice = handler.p2Voice.getName();
        float musicBpm = handler.bpm;

        JSONObject phaseJson = new JSONObject(); //Out file

        //Credits
        JSONObject credits = new JSONObject();
        credits.put("mapAuthor",mapAuthor);
        credits.put("musicAuthor",musicAuthor);

        //PhaseConfigs
        JSONObject phaseSettings = new JSONObject();
        phaseSettings.put("bpm",musicBpm);

        //FilePaths
        JSONObject filePaths = new JSONObject();
        filePaths.put("music",musicPath);
        filePaths.put("p1Voice",p1Voice);
        filePaths.put("p2Voice",p2Voice);

        //Atlas
        JSONArray animatedObjects = new JSONArray();
        for (int i =0;i<handler.atlas.toArray().length;i++){
            animatedObjects.add(handler.atlas.get(i).getName());
        }
        //PhaseObjects
        JSONObject phaseObjects = new JSONObject();
        JSONArray phaseArrows = new JSONArray();
        phaseArrows.add("standard:w");
        phaseArrows.add("standard:d");
        phaseArrows.add("standard:s");
        phaseArrows.add("standard:a");
        phaseObjects.put("phaseArrows",phaseArrows);

        phaseJson.put("credits",credits);
        phaseJson.put("phaseSettings",phaseSettings);
        phaseJson.put("filePaths",filePaths);
        phaseJson.put("phaseObjects",phaseObjects);
        phaseJson.put("animatedObjects",animatedObjects);

        JSONObject outFile = new JSONObject();
        outFile.put("phaseConfigs",phaseJson);
        return outFile;
    }

}
