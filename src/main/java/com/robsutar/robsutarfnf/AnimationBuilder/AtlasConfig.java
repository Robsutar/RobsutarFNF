package com.robsutar.robsutarfnf.AnimationBuilder;

import java.util.List;

public class AtlasConfig extends MonoAtlas {

    protected String imageName;
    protected String folderPath;
    public AtlasConfig(String folderPath,String imagePath,List<String> name,List<Integer> x, List<Integer> y, List<Integer> width, List<Integer> height,
                       List<Integer> frameX, List<Integer> frameY, List<Integer> frameWidth, List<Integer> frameHeight){
        super(name, x, y, width, height, frameX, frameY, frameWidth, frameHeight);
        this.folderPath = folderPath;this.imageName = imagePath;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public String getImageName() {
        return imageName;
    }
}
