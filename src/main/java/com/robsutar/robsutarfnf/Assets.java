package com.robsutar.robsutarfnf;


import java.io.File;

public class Assets {
    public static String resourcesPath = new File("").getAbsolutePath()+"/resources/";
    public static String assetsPath = resourcesPath+"assets/";
    public static String phasesPath = resourcesPath+"phases/";

    private static final String RESET = "\033[0m";

    private static final String RED_BOLD = "\033[1;31m";
    private static final String CYAN = "\033[0;36m";
    private static final String BLUE_BOLD = "\033[1;34m";

    public static void loading(String string, String fileType){
        System.out.println(BLUE_BOLD+"Loading "+CYAN+fileType+": "+RESET+string);
    }
    public static void failedLoad(String string){
        System.out.println(RED_BOLD+"Failed to load: "+RESET+string);
    }
}
