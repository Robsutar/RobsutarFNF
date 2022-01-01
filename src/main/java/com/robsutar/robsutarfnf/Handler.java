package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.Threads.BpmTicable;
import com.robsutar.robsutarfnf.Threads.Renderable;
import com.robsutar.robsutarfnf.Threads.Ticable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private static ArrayList<Renderable> renderables = new ArrayList<>();
    private static ArrayList<Ticable> ticables = new ArrayList<>();
    private static ArrayList<BpmTicable> bpmTicables = new ArrayList<>();

    public static void addObject(Renderable object) {renderables.add(object);}
    public static void removeObject(Renderable object) {renderables.remove(object);}

    public static void addObject(Ticable object) {ticables.add(object);}
    public static void removeObject(Ticable object) {ticables.remove(object);}

    public static void addObject(BpmTicable object) {bpmTicables.add(object);}
    public static void removeObject(BpmTicable object) {bpmTicables.remove(object);}

    public static void render(Graphics g){

    }

    public static void tick(){

    }
    public static void bpmTick(){

    }
}
