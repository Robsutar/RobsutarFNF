package com.robsutar.robsutarfnf.Fnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Engine.Files.FileManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XmlImageStream {
    protected final List<List<BufferedImage>> images = new ArrayList<>();
    protected final List<List<Integer>> framesX = new ArrayList<>();
    protected final List<List<Integer>> framesY = new ArrayList<>();
    protected final List<Integer> widths = new ArrayList<>();
    protected final List<Integer> heights = new ArrayList<>();
    protected final List<String> names = new ArrayList<>();

    protected final String imageName;

    protected final String folderPath;

    public XmlImageStream(File file){

        Document xmlFile = FileManager.loadXml(file);

        imageName = xmlFile.getDocumentElement().getAttribute("imagePath");

        folderPath = file.getParent()+"/";

        BufferedImage fullImage = FileManager.loadImage(FileManager.loadFile(folderPath+imageName));

        NodeList list = xmlFile.getElementsByTagName("SubTexture");

        int i = 0;
        int lastWidth=0;
        int lastHeight=0;
        String lastName="";
        List<Integer> framesX = new ArrayList<>();
        List<Integer> framesY = new ArrayList<>();
        List<BufferedImage> images = new ArrayList<>();
        l1:while (i<list.getLength()){
            while (i<list.getLength()) {
                Node node = list.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    int x, y, width, height, frameY, frameX, frameWidth, frameHeight;

                    String name = (element.getAttribute("name"));

                    String substring = name.substring(0, name.length() - 4);

                    if(lastName.equals("")) {
                        lastName = substring;
                        names.add(substring);
                    }else if (!lastName.equals(substring)){

                        this.framesX.add(framesX);
                        this.framesY.add(framesY);
                        this.images.add(images);
                        this.widths.add(lastWidth);
                        this.heights.add(lastHeight);
                        this.names.add(substring);

                        framesX=new ArrayList<>();
                        framesY=new ArrayList<>();
                        images=new ArrayList<>();

                        lastName = substring;
                        continue;
                    }

                    if(!Objects.equals(element.getAttribute("x"), "")) {
                        x = (Integer.parseInt(element.getAttribute("x")));
                    } else {
                        x = (0);
                    }

                    if(!Objects.equals(element.getAttribute("y"), "")) {
                        y = (Integer.parseInt(element.getAttribute("y")));
                    } else {
                        y = (0);
                    }

                    if(!Objects.equals(element.getAttribute("width"), "")) {
                        width = (Integer.parseInt(element.getAttribute("width")));
                    } else {
                        width = (0);
                    }

                    if(!Objects.equals(element.getAttribute("height"), "")) {
                        height = (Integer.parseInt(element.getAttribute("height")));
                    } else {
                        height = (0);
                    }

                    if(!Objects.equals(element.getAttribute("frameX"), "")) {
                        frameX = (Integer.parseInt(element.getAttribute("frameX")));
                    } else {
                        frameX = (0);
                    }

                    if(!Objects.equals(element.getAttribute("frameY"), "")) {
                        frameY = (Integer.parseInt(element.getAttribute("frameY")));
                    } else {
                        frameY = (0);
                    }

                    if(!Objects.equals(element.getAttribute("frameWidth"), "")) {
                        frameWidth = (Integer.parseInt(element.getAttribute("frameWidth")));
                    } else {
                        frameWidth = (width);
                    }

                    if(!Objects.equals(element.getAttribute("frameHeight"), "")) {
                        frameHeight = (Integer.parseInt(element.getAttribute("frameHeight")));
                    } else {
                        frameHeight = (height);
                    }

                    BufferedImage img = fullImage.getSubimage(x, y, width, height);
                    lastWidth = frameWidth;
                    lastHeight = frameHeight;

                    images.add(img);
                    framesX.add(frameX);
                    framesY.add(frameY);

                    if (i+1==list.getLength()){
                        this.framesX.add(framesX);
                        this.framesY.add(framesY);
                        this.images.add(images);
                        this.widths.add(lastWidth);
                        this.heights.add(lastHeight);
                        break l1;
                    }
                }
                i++;
            }
            i--;
        }
    }

    public List<List<BufferedImage>> getImages() {
        return images;
    }

    public List<List<Integer>> getFramesX() {
        return framesX;
    }

    public List<List<Integer>> getFramesY() {
        return framesY;
    }

    public String getImageName() {
        return imageName;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public List<Integer> getWidths() {
        return widths;
    }

    public List<Integer> getHeights() {
        return heights;
    }

    public List<String> getNames() {
        return names;
    }
}
