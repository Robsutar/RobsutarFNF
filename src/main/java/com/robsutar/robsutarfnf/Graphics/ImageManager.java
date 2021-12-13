package com.robsutar.robsutarfnf.Graphics;

import com.robsutar.robsutarfnf.Assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageManager{

    public static BufferedImage loadImage(String path){
        BufferedImage img = null;
        try{
            Assets.loading(path,"image");
            img = ImageIO.read(new File(path));
        }catch( IOException e) {
            Assets.failedLoad(path);
        }
        return img;
    }
}
