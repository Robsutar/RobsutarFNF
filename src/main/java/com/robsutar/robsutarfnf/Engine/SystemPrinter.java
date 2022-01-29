package com.robsutar.robsutarfnf.Engine;

import com.robsutar.robsutarfnf.Engine.Interfaces.PrintColor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.robsutar.robsutarfnf.Engine.Files.FileManager.resourcesPath;

public abstract class SystemPrinter implements PrintColor {

    public static final String failed = RED_BOLD+"failed ";
    public static final String loading = GREEN_BOLD+"Loading file: "+BLUE;
    public static final String failedToLoad = failed+"to load file: "+RED;
    public static final String writing = PURPLE_BOLD+"Writing file: "+GREEN;
    public static final String failedToWrite = failed+"to write file: "+RED;
    public static final String deleting = RED_BOLD_BRIGHT+"Deleting file: "+RED_BRIGHT;
    public static final String failedToDelete= failed+"to delete file "+RED;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void print(String x){
        LocalDateTime now = LocalDateTime.now();
        String replacement = YELLOW+dtf.format(now)+WHITE_BRIGHT+" ⛣ "+(x.replace(resourcesPath,"resources\\"+"\033[1;97m"))+RESET;
        System.out.println(replacement);
    }
}
