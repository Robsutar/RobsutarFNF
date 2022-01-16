package com.robsutar.robsutarfnf.Engine.Renderable;

import com.robsutar.robsutarfnf.Engine.Box;
import com.robsutar.robsutarfnf.Engine.Threads.Ticable;
import com.robsutar.robsutarfnf.Engine.Window.Anchor.Anchor;

public class GameObject extends SimpleRenderable implements Ticable {
    protected int priority;

    public GameObject(Anchor anchor){
        super(anchor);
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void subordinatesTick(){
        for (Box o:subordinatedObjects) {
            if (o instanceof Ticable){
                ((Ticable) o).tick();
            }
        }
    }

    @Override
    public void tick() {
        animation.tick();
        subordinatesTick();
    }
}
