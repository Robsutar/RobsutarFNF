package com.robsutar.robsutarfnf;

import com.robsutar.robsutarfnf.RenderableObjects.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Camera {
    private List<CameraState> states = new ArrayList<>();
    private boolean reverse = false;
    private final int width;
    private final int height;
    private int index = 0;

    public Camera(List<CameraState> states,int width,int height,boolean reverse){
        this.states=states;this.width=width;this.height=height;this.reverse=reverse;
        if (reverse){
            index = states.toArray().length-1;
        }
    }
    public CameraState update(){
        CameraState st=null;
        if (states!=null) {
            st = new CameraState(states.get(index));
            if (!reverse){
                if(index+1<states.toArray().length){index++;}
            } else{
                if(index>0){index--;}
            }
            st.setX((int) (st.getX()+((width/ st.getScale())-width)/2));
            st.setY((int) (st.getY()+((height/ st.getScale())-height)/2));
        }
        return st;
    }
    public static void construct(Graphics2D g2d, CameraState st){
        g2d.scale(st.getScale(), st.getScale());
        g2d.translate(st.getX(),st.getY());
    }

    public static class CameraState extends Position {
        public CameraState(int x , int y, double rotation,double scale){
            super(x,y,rotation,scale);
        }
        public CameraState(CameraState cs){
            super(cs.getX(),cs.getY(),cs.getRotation(),cs.getScale());
        }
    }
}
