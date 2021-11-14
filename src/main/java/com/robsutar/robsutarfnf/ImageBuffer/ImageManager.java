package com.robsutar.robsutarfnf.ImageBuffer;
import com.robsutar.robsutarfnf.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageManager {

    public static void makeImage (Graphics g, BufferedImage img,AffineTransform at){
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img,at,null);
    }

    public static BufferedImage loadImage(String path){

        BufferedImage img = null;
        try{
            path = path;
            System.out.println(Main.loadingConsoleMessage+path);
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

    public static AffineTransform loadImageTansformer(int x , int y,BufferedImage img,int rotation){
        double rotationRequired = Math.toRadians (rotation);
        double locationX = img.getWidth() / 2.0;
        double locationY = img.getHeight() / 2.0;
        AffineTransform tx =new AffineTransform();
        tx.translate(x,y);
        tx.rotate(rotationRequired);
        tx.translate(-locationX,-locationY);
        return tx;
    }

    public static AffineTransform loadImageTansformer(int x , int y,BufferedImage img , int rotation, double scale){
        double rotationRequired = Math.toRadians (rotation);
        double locationX = img.getWidth() / 2.0;
        double locationY = img.getHeight() / 2.0;
        AffineTransform tx =new AffineTransform();
        tx.translate(x,y);
        tx.rotate(rotationRequired);
        tx.scale(scale,scale);
        tx.translate(-locationX,-locationY);
        return  tx;
    }
    public static AffineTransform loadImageTansformer(int x , int y,BufferedImage img){
        double locationX = img.getWidth() / 2.0;
        double locationY = img.getHeight() / 2.0;
        AffineTransform tx =new AffineTransform();
        tx.translate(x,y);
        tx.translate(-locationX,-locationY);
        return  tx;
    }

    public static void makeImage(BufferedImage img , AffineTransform at,Graphics2D g2d){
        g2d.drawImage(img,at,null);
    }
}
