package com.robsutar.robsutarfnf.Engine;

import static com.robsutar.robsutarfnf.Engine.Files.FileManager.resourcesPath;

public abstract class SystemPrinter {
    private static final String resetColor = "\033[0m";

    public static final String failed = "\033[1;31m"+"failed ";
    public static final String loading = "\033[1;32m"+"Loading file: "+"\033[0;34m";
    public static final String failedToLoad = failed+"to load file: "+"\033[0;31m";
    public static final String writing = "\033[1;35m"+"Writing file: "+"\033[0;32m";
    public static final String failedToWrite = failed+"to write file: "+"\033[0;31m";

    public static void print(String x){
        String replacement = " ⛣ "+(x.replace(resourcesPath,"resources\\"+"\033[1;97m"))+resetColor;
        System.out.println(replacement);
    }
}
