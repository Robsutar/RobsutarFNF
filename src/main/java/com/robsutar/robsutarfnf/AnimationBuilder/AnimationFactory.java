package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.AbstractObjects.Position;
import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.Files.XmlFiles;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class AnimationFactory extends Position {
    public AnimatedObject getAnimatedObject() {
        return animatedObject;
    }

    SpriteJsonConfig config;

    AtlasConfig atlas;
    BufferedImage mainImage;
    AnimatedObject animatedObject;


    protected int animIndex=0;
    protected int state = 0;

    public AnimationFactory(String SPRITEJSONCONFIG,String FOLDER){

        //Read Json Sprite Config (Image path, Animations name...)
        this.config= JsonFiles.readSpriteJsonConfig(SPRITEJSONCONFIG);

        this.atlas = XmlFiles.readTextureAtlasXml(FOLDER+config.getXmlPath());

        this.mainImage = ImageManager.loadImage(FOLDER+atlas.imagePath);

        this.animatedObject = new AnimatedObject(mainImage,atlas,config);
    }

}
