package com.robsutar.robsutarfnf.AnimationBuilder;

import com.robsutar.robsutarfnf.Assets;
import com.robsutar.robsutarfnf.Files.JsonFiles;
import com.robsutar.robsutarfnf.ImageBuffer.ImageManager;
import com.robsutar.robsutarfnf.Interfaces.BpmTicable;
import com.robsutar.robsutarfnf.Main;
import com.robsutar.robsutarfnf.Position.ExtendedPosition;
import com.robsutar.robsutarfnf.RenderableObjects.RenderableObject;
import org.json.simple.JSONObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedObject extends RenderableObject implements BpmTicable {

    private ArrayList<ArrayList<BufferedImage>> animatedImages = new ArrayList<ArrayList<BufferedImage>>();

    private List<Integer> widths= new ArrayList<>();
    private List<Integer> heights= new ArrayList<>();
    private List<ExtendedPosition> posEps = new ArrayList<>();
    private int animationIndex=0,imageIndex=0;
    private boolean animating = true;

    public AnimatedObject(int x, int y,AtlasConfig atlasXml) {
        super(x,y);

        AtlasConfig atlas = atlasXml;
        BufferedImage img = ImageManager.loadImage(atlas.getFolderPath() + atlas.getImageName());
        ArrayList<ArrayList<String>> animationsName = new ArrayList<ArrayList<String>>();
        JSONObject testPosJson = JsonFiles.readJsonObject(atlas.getFolderPath()+(atlas.getImageName().replace("png","json")));
        if (testPosJson!=null) {
            this.posEps = JsonFiles.readBaseTransform(testPosJson);
        }

        for (int i = 0;i < atlas.getName().toArray().length;i++){
            String name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);

            ArrayList<String> innerAnimationsName = new ArrayList<String>();
            ArrayList<BufferedImage> innerImages = new ArrayList<BufferedImage>();

            int widt = 0,heigt=0;

            if(this.posEps.toArray().length<=i){
                this.posEps.add(new ExtendedPosition());
            }

            while (atlas.getName(i).contains(name)){
                name = atlas.getName(i).substring(0,atlas.getName(i).length()-4);
                innerAnimationsName.add(atlas.getName(i));

                BufferedImage tempI =  ImageManager.cropImage(img, atlas.getX(i),atlas.getY(i),atlas.getWidth(i),atlas.getHeight(i));
                tempI = ImageManager.moveImage(tempI, -atlas.getFrameX(i),-atlas.getFrameY(i));
                innerImages.add(tempI);

                widt+=tempI.getWidth();
                heigt+=tempI.getHeight();

                i+=1;
            }
            i-=1;

            widt/=innerImages.toArray().length;
            heigt/=innerImages.toArray().length;
            animationsName.add(innerAnimationsName);
            widths.add(widt);
            heights.add(heigt);
            animatedImages.add(innerImages);
        }
        if(testPosJson==null){
            JsonFiles.writeBaseTransform(posEps, (atlas.getFolderPath())+(atlas.getImageName().replace("png","json")));
        }
    }

    @Override
    public int getWidth() {
        if (!(animationIndex >=widths.toArray().length)){
            width=widths.get(animationIndex);
        }
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        if (!(animationIndex >=heights.toArray().length)){
            height=heights.get(animationIndex);
        }
        return super.getHeight();
    }

    public int getAnimationIndex() {
        return animationIndex;
    }

    public void setIndex(int index){
        setImageIndex(0);
        if (index<0){
            this.animationIndex = animatedImages.toArray().length-1;
        } else
        if (animatedImages.toArray().length-1<index) {
            this.animationIndex = 0;
        } else this.animationIndex=index;
    }
    public void setImageIndex(int index){
        if (animatedImages.get(animationIndex).toArray().length-1<index) {
            this.imageIndex = 0;
        } else {
            this.imageIndex = index;
        }
    }

    @Override
    public void spawn() {
        bpmSpawn();
        super.spawn();
    }

    @Override
    public void bpmTick() {
        if (animating&&alive){
            setImageIndex(imageIndex+1);
            setActualImage(animatedImages.get(animationIndex).get(imageIndex));
            setActualPosEP(posEps.get(animationIndex));
        }
    }
}
