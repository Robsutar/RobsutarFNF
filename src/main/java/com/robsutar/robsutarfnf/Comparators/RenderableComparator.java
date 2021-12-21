package com.robsutar.robsutarfnf.Comparators;

import com.robsutar.robsutarfnf.Interface.Renderable;

import java.util.Comparator;

public class RenderableComparator implements Comparator<Renderable> {
    @Override
    public int compare(Renderable o1, Renderable o2) {
        if (o1.getPriority()>o2.getPriority()){
            return -1;
        }
        return 0;
    }
}
