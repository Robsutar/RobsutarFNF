package com.robsutar.robsutarfnf;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Camera {
    private List<CameraState> states = new ArrayList<>();
    private boolean reverse = false;
    private int width,height;
    private int index = 0;
    private double multiplier=1;

    public Camera(List<CameraState> states,int width,int height,double multiplier,boolean reverse){
        this.states=states;this.width=width;this.height=height;this.multiplier=multiplier;this.reverse=reverse;
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
            st.x+=((width/ st.scale)-width)/2;
            st.y+=((height/ st.scale)-height)/2;
        }
        return st;
    }
    public static void construct(Graphics2D g2d, CameraState st, int width,int height, double multiplier){

        g2d.scale(st.scale, st.scale);
        g2d.translate(st.getX(),st.getY());

        /*
        g2d.translate(width / 2.0, height / 2.0);
        g2d.rotate(Math.toRadians(st.rotation*multiplier));
        g2d.scale(st.scale, st.scale);
        g2d.translate(-width / 2.0 + (st.x*multiplier), -height / 2.0 +(st.y*multiplier));
        g2d.translate(st.x, st.y);
         */
    }

    public static class CameraState{
        private int x = 0, y = 0;
        private double rotation = 0,scale = 0;
        public CameraState(int x , int y, double rotation,double scale){
            this.x=x;this.y=y;this.rotation=rotation;this.scale=scale;
        }
        public CameraState(CameraState cs){
            this.x=cs.x;this.y=cs.y;this.rotation=cs.rotation;this.scale=cs.scale;
        }

        public double getScale() {return this.scale;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public double getRotation() {
            return rotation;
        }
    }
}
