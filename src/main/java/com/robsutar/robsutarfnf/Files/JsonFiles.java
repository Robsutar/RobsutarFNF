package com.robsutar.robsutarfnf.Files;

import com.robsutar.robsutarfnf.AnimationBuilder.SpriteJsonConfig;
import com.robsutar.robsutarfnf.Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFiles {
    public static void writePhaseConfig(String path){

        String imageXmlName = "lianna.xml";
        String author = "Robsutar";

        String idle = "Dad Sing Note IDLE";
        String up = "Dad Sing Note UP";
        String left = "Dad Sing Note LEFT";
        String down = "Dad Sing Note DOWN";
        String right = "Dad Sing Note RIGHT";

        List<String> customAnim = new ArrayList<>();

        customAnim.add("Dad idle dance");
        customAnim.add("Dad Sing Note UP");
        customAnim.add("Dad Sing Note LEFT");
        customAnim.add("Dad Sing Note DOWN");
        customAnim.add("Dad Sing Note RIGHT");

        //ANIMATIONS
        JSONObject animations = new JSONObject();
        animations.put("idle", idle);
        animations.put("up", up);
        animations.put("left", left);
        animations.put("down", down);
        animations.put("right", right);

        //CUSTOM ANIMATIONS
        JSONArray customAnimations = new JSONArray();
        for (int i = 0;i < customAnim.toArray().length;i++) {
                customAnimations.add(i,customAnim.get(i));
        }

        //ANIMATIONS OBJECT
        JSONObject animationsObject = new JSONObject();
        animationsObject.put("customAnimations", customAnimations);
        animationsObject.put("animations", animations);

        //BASE CONFIG
        JSONObject baseConfig = new JSONObject();
        baseConfig.put("author",author);
        baseConfig.put("imageXmlName", imageXmlName);
        baseConfig.put("animations",animations);
        baseConfig.put("customAnimations",customAnimations);
        //BASE CONFIG OBJECT
        JSONObject baseConfigObject = new JSONObject();
        baseConfigObject.put("baseConfig", baseConfig);

        //ADD OBJECTS TO LIST
        JSONArray outJsonList = new JSONArray();

        outJsonList.add(baseConfigObject);
        outJsonList.add(animationsObject);


        //Write JSON file
        try (FileWriter file = new FileWriter(path)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(baseConfigObject.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SpriteJsonConfig readSpriteJsonConfig(String path){
        JSONParser jsonParser = new JSONParser();
        SpriteJsonConfig config = null;

        try (FileReader reader = new FileReader(path))
        {
            System.out.println(Main.loadingConsoleMessage+path);
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject employeeList = (JSONObject) obj;

            config = readPhaseConfig(employeeList);

            //Iterate over employee array
            //employeeList.forEach( emp -> readPhaseConfig( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();System.out.println(Main.failedToLoadConsoleMessage);
        } catch (IOException e) {
            e.printStackTrace();System.out.println(Main.failedToLoadConsoleMessage);
        } catch (ParseException e) {
            e.printStackTrace();System.out.println(Main.failedToLoadConsoleMessage);
        }
        return config;
    }

    public static SpriteJsonConfig readPhaseConfig(JSONObject config) {
        //Get config object within list

        JSONObject baseConfig = (JSONObject) config.get("baseConfig"); //base config
        JSONObject animations = (JSONObject) baseConfig.get("animations"); //animations part
        JSONArray customAnimations = (JSONArray) baseConfig.get("customAnimations"); //custom animations part

        String author = (String) baseConfig.get("author");

        String imageXmlName = (String) baseConfig.get("imageXmlName");


        String idle = (String) animations.get("idle");

        String up = (String) animations.get("up");

        String left = (String) animations.get("left");

        String down = (String) animations.get("down");

        String right = (String) animations.get("right");

        List<String> customAnims = customAnimations;

        SpriteJsonConfig phaseConfig = new SpriteJsonConfig(author, imageXmlName, idle, up, left, down, right,customAnims);
        return phaseConfig;
    }
}
