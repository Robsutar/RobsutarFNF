package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;

import java.awt.image.BufferedImage;

public class AnimationFactory {

    SpriteJsonConfig config;

    AtlasConfig atlas;
    BufferedImage mainImage;
    AnimatedObject animatedObject;
    public AnimationFactory(String SPRITEJSONCONFIG){

        //Read Json Sprite Config (Image path, Animations name...)
        this.config= JsonFiles.readSpriteJsonConfig(SPRITEJSONCONFIG);

        this.atlas = XmlFiles.readTextureAtlasXml(config.getXmlPath());

        this.mainImage = ImageManager.loadImage(atlas.imagePath);

        this.animatedObject = new AnimatedObject(mainImage,atlas,config);
    }
}
