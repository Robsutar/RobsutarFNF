package com.robsutar.robsutarfnf.Fnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Engine.ExtendedRectangle;
import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import com.robsutar.robsutarfnf.Engine.SystemPrinter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonReadjust {
    private JSONObject file = new JSONObject();
    public JSONObject arrows;
    private List<ExtendedRectangle> readjusts;
    private int amount;

    public JsonReadjust(int readjustCount){
        this.amount = readjustCount;
        writeAnimationReadjust(amount);
    }
    public void loadReadjust(File file){
        this.file=FileManager.loadJson(file);
        if (this.file!=null) {
            readjusts = readAnimationReadjust();
            arrows = getArrows();
        } else {
            this.file = new JSONObject();
            writeAnimationReadjust(amount);
        }
    }

    public boolean isPlayer(){
        return arrows != null;
    }

    public JSONObject getArrows(){
        try {
            return (JSONObject) file.get("arrows");
        } catch (Exception e){
            SystemPrinter.print(SystemPrinter.failed+" to find arrows");
            return null;
        }
    }

    public String getArrow(String type){
        if (arrows==null){
            return null;
        }
        return (String) arrows.get("arrow"+type);
    }

    public List<ExtendedRectangle> readAnimationReadjust(){
        List<ExtendedRectangle> positionList = new ArrayList<>();
        try {
            JSONArray array = (JSONArray) this.file.get("frameModifiers");
            for (int i = 0; i < array.toArray().length; i++) {
                ExtendedRectangle pos = new ExtendedRectangle();
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

    public void writeFile(String folder, String name){
        FileManager.writeJson(folder,name,file);
    }

    public void writeAnimationReadjust(int count){
        List<ExtendedRectangle> rdj = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rdj.add(new ExtendedRectangle());
        }
        setReadjusts(rdj);
    }

    public void writeAnimationReadjust(List<ExtendedRectangle> streams){
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
        file.put("frameModifiers",frameModifier);
    }

    public void writeArrows(String arrowUp,String arrowDown,String arrowLeft,String arrowRight,String arrowIdle){
        JSONObject arrows = new JSONObject();

        arrows.put("arrowUp",arrowUp);
        arrows.put("arrowDown",arrowDown);
        arrows.put("arrowLeft",arrowLeft);
        arrows.put("arrowRight",arrowRight);
        arrows.put("arrowIdle",arrowIdle);

        file.put("arrows",arrows);
    }

    public List<ExtendedRectangle> getReadjusts() {
        return readjusts;
    }

    public void setReadjusts(List<ExtendedRectangle> readjusts) {
        this.readjusts = readjusts;
    }

    public JSONObject getFile() {
        return file;
    }
}
