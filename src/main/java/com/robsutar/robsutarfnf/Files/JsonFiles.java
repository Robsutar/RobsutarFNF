package com.robsutar.robsutarfnf.Files;

import com.robsutar.robsutarfnf.AnimationBuilder.AnimatedObject;
import com.robsutar.robsutarfnf.AnimationBuilder.AnimationStream;
import com.robsutar.robsutarfnf.AnimationBuilder.Stream;
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
    public static void writeAnimationConfig(List<Stream> streams, String path){
        writeJsonObject(jsonConfigAnimation(streams),path);
    }

    public static JSONObject jsonConfigAnimation(List<Stream> streams){
        JSONArray frameModifier = new JSONArray();
        for (int i = 0; i < streams.toArray().length;i++) {
            JSONObject configs  = new JSONObject();
            configs.put("frameX",streams.get(i).getX());
            configs.put("frameY",streams.get(i).getY());
            configs.put("scale",streams.get(i).getScale());
            configs.put("rotation",streams.get(i).getRotation());

            frameModifier.add(configs);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("frameModifiers",frameModifier);
        return jsonObject;
    }
    public static void writeJsonObject(JSONObject object,String path){
        try (FileWriter file = new FileWriter(path)) {
            file.write(object.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject readJsonObject(String path){
        JSONParser parser = new JSONParser();
        JSONObject jObject=null;

        try(FileReader reader = new FileReader(path)) {
            Object obj = parser.parse(reader);
            jObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jObject;
    }

    public static AnimationStream readAnimationConfig(String path){
        return readAnimationConfig(readJsonObject(path));
    }
    public static AnimationStream readAnimationConfig(JSONObject object){
        JSONArray array = (JSONArray) object.get("frameModifiers");
        AnimationStream streamList = new AnimationStream();

        for (Object o:array
             ) {
            Stream stream = new Stream();
            JSONObject obj = (JSONObject) o;
            stream.setX(Integer.parseInt(obj.get("frameX").toString()));
            stream.setY(Integer.parseInt(obj.get("frameY").toString()));
            stream.setScale(Double.parseDouble(obj.get("scale").toString()));
            stream.setRotation(Double.parseDouble(obj.get("rotation").toString()));
            streamList.add(stream);
        }
        return streamList;
    }
}
