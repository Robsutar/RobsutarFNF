package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Graphics.ImageManager;
import com.robsutar.robsutarfnf.RenderableObjects.Box;
import org.json.simple.JSONObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AtlasConfig extends MonoAtlas {

    protected String imageName;
    protected String folderPath;
    protected BufferedImage fullImage;
    protected List<Box> readjustPos= new ArrayList<>();
    public AtlasConfig(String folderPath,String imagePath,List<String> name,List<Integer> x, List<Integer> y, List<Integer> width, List<Integer> height,
                       List<Integer> frameX, List<Integer> frameY, List<Integer> frameWidth, List<Integer> frameHeight){
        super(name, x, y, width, height, frameX, frameY, frameWidth, frameHeight);
        this.folderPath = folderPath;this.imageName = imagePath;
        fullImage = ImageManager.loadImage(folderPath +imageName);
        JSONObject testPosJson = JsonFiles.readJsonObject(folderPath+ (imageName.replace("png", "json")));
        if (testPosJson!=null){
            this.readjustPos=JsonFiles.readBaseTransform(testPosJson);
        }
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

    public List<Box> getReadjustPos() {
        return  readjustPos;
    }
}
