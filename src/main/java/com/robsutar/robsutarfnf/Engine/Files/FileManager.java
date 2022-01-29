package com.robsutar.robsutarfnf.Engine.Files;

import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.SystemPrinter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
import java.util.prefs.Preferences;

public class FileManager {

    public static final String resourcesPath = new File("").getAbsolutePath()+"\\resources\\";
    public static final String mainAssetsPath = resourcesPath+"assets\\";
    public static final String texturesPath=resourcesPath+"resourcepacks\\";
    public static final String phasesPath=mainAssetsPath+"phases\\";

    private static final String standard = "\033[1;37m"+"ORIGINAL - ";
    private static final String resourcePack = "\033[1;33m"+"TEXTURE - ";

    private static final String IMAGE = " \033[4;36m"+"IMAGE";
    private static final String JSON = " \033[4;34m"+"JSON";
    private static final String XML = " \033[4;31m"+"XML";
    private static final String WAV = " \033[4;33m"+"WAV";
    private static final String FONT = " \033[4;35m"+"FONT";

    public static File loadFile(String filePath, String assetsTexturePath){
        File file;
        if (assetsTexturePath!=null){
            file = new File(assetsTexturePath+filePath);
            if (file.exists()){
                SystemPrinter.print(resourcePack+SystemPrinter.loading+file.getPath()+IMAGE);
                return file;
            }
        }

        file = new File(mainAssetsPath+filePath);
        SystemPrinter.print(standard+SystemPrinter.loading+file.getPath()+IMAGE);

        return file;
    }

    public static BufferedImage loadImage(File file){
        BufferedImage img = null;
        try {
            img= ImageIO.read(file);
        } catch (IOException e) {

            SystemPrinter.print(SystemPrinter.failedToLoad+file.getPath()+IMAGE);
            e.printStackTrace();
        }
        return img;
    }

    public static File loadExplorerFile(){
        return loadExplorerFile(null,null);
    }

    public static File loadExplorerFile(FileNameExtensionFilter filter){
        return loadExplorerFile(null,filter);
    }

    public static File loadExplorerFile(JFileChooser fileChooser,FileNameExtensionFilter filter){
        Preferences prefs = Preferences.userRoot().node(FileManager.class.getName());
        JFileChooser chooser;
        chooser = Objects.requireNonNullElseGet(fileChooser, () -> new JFileChooser(FileManager.resourcesPath));

        String LAST_USED_FOLDER = "fileManager";

        chooser.setCurrentDirectory(new File(prefs.get(LAST_USED_FOLDER, new File(".").getAbsolutePath())));

        if (filter!=null){chooser.setFileFilter(filter);}

        File f = null;
        if (chooser.showOpenDialog(Handler.getWindow()) == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            prefs.put(LAST_USED_FOLDER,f.getParent());
        }
        return f;
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
            SystemPrinter.print(SystemPrinter.failedToLoad+file.getPath()+JSON);
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
            SystemPrinter.print(SystemPrinter.failedToLoad+file.getPath()+XML);
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
            SystemPrinter.print(SystemPrinter.failedToLoad+file.getPath()+WAV);
            e.printStackTrace();
        }
        return clip;
    }

    public static Font loadFont(File file){
        Font font = null;
        try {
            font=Font.createFont(Font.TRUETYPE_FONT, file);
        } catch (FontFormatException | IOException e) {
            SystemPrinter.print(SystemPrinter.failedToLoad+file.getPath()+FONT);
            e.printStackTrace();
        }
        return font;
    }

    public static void writeFile(JSONObject json,File path){
        File fileFolder = new File(path.getParent());
        if (!fileFolder.exists()){
            fileFolder.mkdirs();
        }

        SystemPrinter.print(SystemPrinter.writing+path.getName()+JSON);

        try (FileWriter file = new FileWriter(path)) {
            file.write(json.toJSONString());
            file.flush();

        } catch (IOException e) {
            SystemPrinter.print(SystemPrinter.failedToLoad+path.getName()+JSON);
            e.printStackTrace();
        }
    }

    public static File writeFile(File file, File path){

        File fileFolder = new File(path.getParent());
        if (!fileFolder.exists()){
            fileFolder.mkdirs();
        }

        SystemPrinter.print(SystemPrinter.writing+file.getName()+JSON);

        try (
            InputStream in = new BufferedInputStream(
                    new FileInputStream(file));
            OutputStream out = new BufferedOutputStream(
                    new FileOutputStream(path))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
                return new File(path.getPath());
            }
        } catch (IOException fileNotFoundException) {
            SystemPrinter.print(SystemPrinter.failedToWrite+path);
            fileNotFoundException.printStackTrace();
        }
        return null;
    }

    public static void deleteFile(File file) {
        SystemPrinter.print(SystemPrinter.deleting+file.getPath());
        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            SystemPrinter.print(SystemPrinter.failedToDelete+file.getPath());
            e.printStackTrace();
        }
    }
}
