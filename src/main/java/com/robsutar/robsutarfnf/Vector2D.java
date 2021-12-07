package com.robsutar.robsutarfnf;

public class Vector2D {
    private double x=0,y=0,scale=0,rotation=0,resistance=0.1;
    private double targetScale=0,targetRotation=0;
    public Vector2D (){
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getScale() {
        return scale;
    }

    public double getRotation() {
        return rotation;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setTargetScale(double targetScale) {
        this.targetScale = targetScale;
    }

    public void setTargetRotation(double targetRotation) {
        this.targetRotation = targetRotation;
    }

    public void update(){
        if (targetScale>0){
            targetScale-=resistance;
            if (targetScale<0){
                targetScale=0;
            }
        } else if (targetScale<0){
            targetScale+=resistance;
            if (targetScale>0){
                targetScale=0;
            }
        }
        if (targetRotation>0){
            targetRotation-=resistance;
            if (targetRotation<0){
                targetRotation=0;
            }
        }else if (targetRotation<0){
            targetRotation+=resistance;
            if (targetRotation>0){
                targetRotation=0;
            }
        }
        if (x>0){
            x-=resistance;
            if (x<0){
                x=0;
            }
        } else if (x<0){
            x+=resistance;
            if (x>0){
                x=0;
            }
        }
        if (y>0){
            y-=resistance;
            if (y<0){
                y=0;
            }
        }else if (y<0){
            y+=resistance;
            if (y>0){
                y=0;
            }
        }
        if (scale>targetScale){
            scale-=targetScale*resistance+resistance;
            if (scale<targetScale){
                scale=targetScale;
            }
        } else if (scale<targetScale){
            scale+=targetScale*resistance-resistance;
            if (scale>targetScale){
                scale=targetScale;
            }
        }
        if (rotation>targetRotation){
            rotation-=targetRotation*resistance+resistance;
            if (rotation<targetRotation){
                rotation=targetRotation;
            }
        }else if (rotation<targetRotation){
            rotation+=targetRotation*resistance-resistance;
            if (rotation>targetRotation){
                rotation=targetRotation;
            }
        }
        System.out.println("X : "+x+" Y : "+y);
        System.out.println("Scale : "+scale+" Rotation : "+rotation);
        System.out.println("Target Scale : "+targetScale+" Target Rotation : "+targetRotation);
    }
}
