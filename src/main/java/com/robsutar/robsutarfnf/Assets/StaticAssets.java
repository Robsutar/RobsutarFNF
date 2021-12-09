package com.robsutar.robsutarfnf.Assets;

import com.robsutar.robsutarfnf.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StaticAssets {
    public Font FONT;
    public StaticAssets(){
        this.FONT = loadFont();
    }

    private Font loadFont() {
        Font customFont = null;
        try {
            //create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(Main.assetsPath+"font.ttf")).deriveFont(32f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return customFont;
    }
}
