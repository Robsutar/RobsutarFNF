package com.robsutar.robsutarfnf.Fnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Engine.Box;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonReadjust {
    private List<Box> readjusts;
    public JsonReadjust(File file){
        readjusts=readAnimationReadjust(FileManager.loadJson(file));
    }

    public static List<Box> readAnimationReadjust(JSONObject object){
        List<Box> positionList = new ArrayList<>();
        try {
            JSONArray array = (JSONArray) object.get("frameModifiers");
            for (int i = 0; i < array.toArray().length; i++) {
                Box pos = new Box();
                JSONObject obj = (JSONObject) array.get(i);
                JSONObject frame = (JSONObject) obj.get(String.valueOf(i));
                pos.setX(Integer.parseInt(frame.get("frameX").toString()));
                pos.setY(Integer.parseInt(frame.get("frameY").toString()));
                pos.setScale(Double.parseDouble(frame.get("scale").toString()));
                pos.setRotation(Double.parseDouble(frame.get("rotation").toString()));
                positionList.add(pos);
            }
        } catch (NullPointerException e){return null;}
        return positionList;
    }

    public static JSONObject writeAnimationReadjust(List<Box> streams){
        JSONArray frameModifier = new JSONArray();

        for (int i = 0; i < streams.toArray().length;i++) {
            JSONObject configs  = new JSONObject();
            JSONObject transform = new JSONObject();
            transform.put("frameX",(int)streams.get(i).getX());
            transform.put("frameY",(int)streams.get(i).getY());
            transform.put("scale",streams.get(i).getScale());
            transform.put("rotation",streams.get(i).getRotation());
            configs.put(i,transform);
            frameModifier.add(configs);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("frameModifiers",frameModifier);
        return jsonObject;
    }

    public List<Box> getReadjusts() {
        return readjusts;
    }

    public void setReadjusts(List<Box> readjusts) {
        this.readjusts = readjusts;
    }
}
