package com.robsutar.robsutarfnf.Graphics;

import com.robsutar.robsutarfnf.Assets;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
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

    public static BufferedImage cropImage(BufferedImage img, int x, int y, int width, int height){
        return img.getSubimage(x, y, width, height);
    }

    public static BufferedImage moveImage(BufferedImage source, int frameX, int frameY,
                                          int width, int height,int maxFrameX, int maxFrameY){
        width+=maxFrameX;height+=maxFrameY;

        BufferedImage b = new BufferedImage(width,height,source.getType());
        Graphics g = b.getGraphics();

        g.drawImage(source,frameX,frameY,null);
        g.dispose();
        return b;

    }
    public static BufferedImage moveImage(BufferedImage source , int frameX,int frameY){
        BufferedImage b = new BufferedImage(source.getWidth(),source.getHeight(),source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source,frameX,frameY,null);
        g.dispose();
        return b;
    }
}
