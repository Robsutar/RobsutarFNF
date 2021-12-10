package com.robsutar.robsutarfnf.Graphics;
import com.robsutar.robsutarfnf.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageManager {

    public static BufferedImage loadImage(String path){

        BufferedImage img = null;
        try{
            System.out.println(Main.loadingConsoleMessage+path+" IMAGE ");
            img = ImageIO.read(new File(path));
        }catch( IOException e) {
            System.out.println();
            e.printStackTrace();
        }
        return img;
    }

    public static BufferedImage cropImage(BufferedImage img, int x, int y, int width, int height){
        BufferedImage croppedImage = img.getSubimage(x, y, width, height);
        return croppedImage;
    }
    public static BufferedImage moveImage(BufferedImage source, int frameX, int frameY){
        BufferedImage b = new BufferedImage(source.getWidth()+frameX, source.getHeight()+frameY, source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source,frameX,frameY, null);
        g.dispose();
        return b;
    }
}
