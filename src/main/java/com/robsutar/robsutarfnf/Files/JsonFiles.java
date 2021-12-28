package com.robsutar.robsutarfnf.Files;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.RenderableObjects.Box;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFiles {
    public static void writeBaseTransform(List<Box> streams, String path){
        writeJsonObject(jsonConfigAnimation(streams),path);
    }
    public static List<Box> readBaseTransform(String path){
        JSONObject obj = readJsonObject(path);
        if (obj==null){
            List<Box> pos = new ArrayList<>();
            return pos;
        }
        return readBaseTransform(obj);
    }

    public static void writeJsonObject(JSONObject object,String path){
        try (FileWriter file = new FileWriter(path)) {
            file.write(object.toJSONString());
            Assets.writing(path,"json");
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject jsonConfigAnimation(List<Box> streams){
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

    public static JSONObject readJsonObject(String path){
        JSONParser parser = new JSONParser();
        JSONObject jObject;

        Assets.loading(path,"json");
        try(FileReader reader = new FileReader(path)) {
            Object obj = parser.parse(reader);
            jObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            Assets.failedLoad(path);
            e.printStackTrace();
            return null;
        }
        return jObject;
    }

    public static List<Box> readBaseTransform(JSONObject object){
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
        } catch (NullPointerException e){e.printStackTrace();}
        return positionList;
    }
}