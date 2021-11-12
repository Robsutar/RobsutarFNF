package com.robsutar.robsutarfnf.Files;

import com.robsutar.robsutarfnf.AnimationBuilder.AtlasConfig;
import com.robsutar.robsutarfnf.Main;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class XmlFiles {

    public static AtlasConfig readTextureAtlasXml(String file) {
        String FILENAME = file;
        System.out.println(Main.loadingConsoleMessage+FILENAME+" and texture");

        String imagePath=null;

        List<String> name = new ArrayList<>();

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> width = new ArrayList<>();
        List<Integer> height = new ArrayList<>();
        List<Integer> frameX = new ArrayList<>();
        List<Integer> frameY = new ArrayList<>();
        List<Integer> frameWidth = new ArrayList<>();
        List<Integer> frameHeight = new ArrayList<>();

        LinkedList<AtlasConfig> atlasMonos = new LinkedList<AtlasConfig>();

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            imagePath = doc.getDocumentElement().getAttribute("imagePath");

            /*
            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("-----------");
            System.out.println("Image Path : "+imagePath);
             */

            // get <staff>
            NodeList list = doc.getElementsByTagName("SubTexture");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    name.add (element.getAttribute("name"));
                    x.add (Integer.valueOf(element.getAttribute("x")));
                    y.add (Integer.valueOf(element.getAttribute("y")));
                    width.add (Integer.valueOf(element.getAttribute("width")));
                    height.add (Integer.valueOf(element.getAttribute("height")));
                    frameX.add (Integer.valueOf(element.getAttribute("frameX")));
                    frameY.add (Integer.valueOf(element.getAttribute("frameY")));
                    frameWidth.add (Integer.valueOf(element.getAttribute("frameWidth")));
                    frameHeight.add (Integer.valueOf(element.getAttribute("frameHeight")));

                    AtlasConfig tempAtlas =new AtlasConfig(
                            imagePath,name, x,  y,  width,  height,  frameX,  frameY,  frameWidth,  frameHeight);
                    atlasMonos.add(tempAtlas);


                    /*
                    System.out.println("Name : " + name);
                    System.out.println("X : " + x + "Y : "+y);
                    System.out.println("Width : " + width + "Heidth : "+height);
                    System.out.println("FrameX : " + frameX + "FrameY : "+frameY);
                    System.out.println("FrameWidth : " + frameWidth + "FrameHeight : "+frameHeight);
                    System.out.println("---------------");

                     */
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(Main.failedToLoadConsoleMessage +file);
            e.printStackTrace();
        }
        AtlasConfig[] finalAtlas = new AtlasConfig[atlasMonos.toArray().length];
        finalAtlas = atlasMonos.toArray(finalAtlas);
        return new AtlasConfig(imagePath,name,x,y,width,height,frameX,frameY,frameWidth,frameHeight);
    }
}
