package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import org.json.simple.JSONObject;

import java.awt.image.BufferedImage;
import java.util.List;

public class AtlasConfig extends MonoAtlas {

    protected String imageName;
    protected String folderPath;
    protected BufferedImage fullImage;
    protected JSONObject testPosJson;
    public AtlasConfig(String folderPath,String imagePath,List<String> name,List<Integer> x, List<Integer> y, List<Integer> width, List<Integer> height,
                       List<Integer> frameX, List<Integer> frameY, List<Integer> frameWidth, List<Integer> frameHeight){
        super(name, x, y, width, height, frameX, frameY, frameWidth, frameHeight);
        this.folderPath = folderPath;this.imageName = imagePath;
        fullImage = ImageManager.loadImage(folderPath +imageName);
        testPosJson = JsonFiles.readJsonObject(folderPath+ (imageName.replace("png", "json")));
    }

    public String getFolderPath() {
        return folderPath;
    }

    public String getImageName() {
        return imageName;
    }

    public BufferedImage getImage() {
        return fullImage;
    }

    public JSONObject getTestPosJson() {
        return  testPosJson;
    }
}
