package com.robsutar.robsutarfnf.Files;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static final String resourcesPath = new File("").getAbsolutePath()+"/resources/";
    public static final String mainAssetsPath = resourcesPath+"assets/";
    public static final String texturesPath=resourcesPath+"resourcepacks/";
    public static final String phasesPath=mainAssetsPath+"phases/";

    private static final String resetColor = "\033[0m";

    private static final String loading = "\033[1;32m"+"Loading file: "+"\033[0;32m";
    private static final String failedToLoad = "\033[1;31m"+"failed to load file: "+"\033[0;31m";
    private static final String writing = "\033[1;35m"+"Writing file: "+"\033[0;32m";
    private static final String failedToWrite = "\033[1;31m"+"failed to write file: "+"\033[0;31m";

    private static final String standard = "\033[1;37m"+"ORIGINAL - ";
    private static final String resourcePack = "\033[1;33m"+"TEXTURE - ";

    private static final String IMAGE = " \033[4;36m"+"IMAGE"+resetColor;
    private static final String JSON = " \033[4;34m"+"JSON"+resetColor;
    private static final String XML = " \033[4;31m"+"XML"+resetColor;
    private static final String WAV = " \033[4;33m"+"WAV"+resetColor;

    public static File loadFile(String filePath, String assetsTexturePath){
        File file;
        if (assetsTexturePath!=null){
            file = new File(assetsTexturePath+filePath);
            if (file.exists()){
                System.out.println(resourcePack+loading+file.getPath()+IMAGE);
                return file;
            }
        }

        file = new File(mainAssetsPath+filePath);
        System.out.println(standard+loading+file.getPath()+IMAGE);
        return file;
    }

    public static BufferedImage loadImage(File file){
        BufferedImage img = null;
        try {
            img= ImageIO.read(file);
        } catch (IOException e) {
            System.out.println(failedToLoad+file.getPath()+IMAGE);
            e.printStackTrace();
        }
        return img;
    }

    public static File loadFile(String absoluteFilePath){
        return new File(absoluteFilePath);
    }

    public static JSONObject loadJson(File file){
        JSONParser parser = new JSONParser();
        JSONObject jObject=null;
        try {
            java.io.FileReader reader = new java.io.FileReader(file);
            Object obj = parser.parse(reader);
            jObject = (JSONObject) obj;
        } catch (Exception e) {
            System.out.println(failedToLoad+file.getPath()+JSON);
            e.printStackTrace();
        }
        return jObject;
    }

    public static Document loadXml(File file ){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            doc.getDocumentElement().normalize();
        }catch (Exception e){
            System.out.println(failedToLoad+file.getPath()+XML);
            e.printStackTrace();
        }
        return doc;
    }

    public static Clip loadWav(File file){
        Clip clip = null;
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(stream);
        }catch (Exception e){
            System.out.println(failedToLoad+file.getPath()+WAV);
            e.printStackTrace();
        }
        return clip;
    }

    public static void writeJson(String folder,String name,JSONObject json){
        File fileFolder = new File(folder);
        if (!fileFolder.exists()){
            fileFolder.mkdirs();
        }
        System.out.println(writing+name+JSON);
        try (FileWriter file = new FileWriter(folder+name)) {
            file.write(json.toJSONString());
            file.flush();

        } catch (IOException e) {
            System.out.println(failedToLoad+name+JSON);
            e.printStackTrace();
        }
    }
}
