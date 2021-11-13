package com.robsutar.robsutarfnf.AnimationBuilder;

import java.util.ArrayList;
import java.util.List;

public class SpriteJsonConfig {

    String author, xmlPath, idle, up, left, down, right;
    List<String> customAnimations = new ArrayList<>();

    public SpriteJsonConfig(String author, String xmlPath, String idle, String up, String left,
                            String down, String right, List<String> customAnimations){

        this.author=author;this.xmlPath=xmlPath;this.idle=idle;this.up=up;this.left=left;
        this.down=down;this.right=right;this.customAnimations=customAnimations;
    }

    public List<String> getCustomAnimations() {
        return customAnimations;
    }

    public String getCustomAnimations(int index) {
        return customAnimations.get(index);
    }

    public String getAuthor() {
        return author;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public String getIdle() {
        return idle;
    }

    public String getUp() {
        return up;
    }

    public String getLeft() {
        return left;
    }

    public String getDown() {
        return down;
    }

    public String getRight() {
        return right;
    }
}
