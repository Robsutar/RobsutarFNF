package com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.MusicBar;

import com.robsutar.robsutarfnf.Engine.Audio.Music;
import com.robsutar.robsutarfnf.Engine.Handler;
import com.robsutar.robsutarfnf.Engine.Interfaces.KeyboardInteractive;
import com.robsutar.robsutarfnf.Engine.Interfaces.MouseInteractive;
import com.robsutar.robsutarfnf.Engine.Window.WindowGame;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.MusicBar.SliderBar.SliderObject;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseCreator.Menus.Tabs.PhaseCreatorTab;
import com.robsutar.robsutarfnf.Fnf.Phase.PhaseHandler;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SliderPhase extends Component implements PhaseCreatorTab,MouseInteractive, KeyboardInteractive {
    private final PhaseHandler handler;

    int hgt = 100;
    int pointsVisibleRange;
    int position = 0;
    int pointAmount = 0;
    int pointHeight = 20;

    double pointDistance;
    private List<point> points = new ArrayList<>();
    private List<point> visiblePoints = new ArrayList<>();
    private List<point> selectedPoints = new ArrayList<>();
    private List<point> busyPoints = new ArrayList<>();

    private point lastClickedPoint = null;

    public SliderPhase(MusicBar musicbar){
        this.handler=musicbar.handler;

        Music music = handler.music;

        this.pointAmount = (int) music.getBeatLength(handler.bpm);
        constructPoints(points, pointAmount);
        setPointsVisibleRange(16);

        addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                point p = getPointAtClick();
                if(p != null) {
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        SliderObject o =SliderObject.getObject(handler.selectedObject);if (o!=null) {
                            if(p.object == null) {
                                p.addObject(o);
                            }
                        }
                    } else if(e.getButton() == MouseEvent.BUTTON3) {
                        p.removeObject();
                    }
                    lastClickedPoint = p;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                point p = getPointAtClick();
                if (p!=null){
                    if (p!=lastClickedPoint) {
                        if(lastClickedPoint.getObject() instanceof SliderObject.Arrow) {
                            if (p.value-lastClickedPoint.value>0) {
                                SliderObject.Arrow a = (SliderObject.Arrow) lastClickedPoint.getObject();
                                a.setSlider(p.value - lastClickedPoint.value);
                            }
                        }
                    } else {
                        SliderObject o =SliderObject.getObject(handler.selectedObject);if (o!=null) {
                            if(Objects.equals(o.getType(), p.object.getType())) {
                                p.changeSelect();
                            } else {
                                p.addObject(o);
                            }
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private point getPointAtClick() {
        Point mouse = Handler.mousePosition;
        for (point p:visiblePoints){
            int x = Handler.mousePosition.x;
            int px = (int) (p.x-pointDistance/2);
            int width = (int) pointDistance;
            if (x>=px&&x<=width+px){
                return p;
            }
        }
        return null;
    }

    private List<point> getVisiblePoints(){return visiblePoints;}
    public List<point> getBusyPoints() {return busyPoints;}
    private List<point> getSelectedPoints(){return selectedPoints;}

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WindowGame.wdt(),hgt);
    }

    private void constructPoints(List<point> plist, int amount){
        for (int i = 0; i < amount;i++){
            plist.add(new point(i));
        }
    }

    private void constructVisiblePoints() {
        List<point> p = new ArrayList<>();
        for (int i = 0; i <pointsVisibleRange;i++){
            point h = points.get(getPosition()+i);
            double x = pointDistance *i;
            h.x= (int) x;
            p.add(h);
        }
        visiblePoints = p;
    }
    @Override
    public int getWidth() {return getPreferredSize().width;}

    @Override
    public int getHeight() {return getPreferredSize().height;}

    private int getPosition() {return Math.min(position, pointAmount);}

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setStroke(new BasicStroke(2));
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
        g2d.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);

        List<point> points = getVisiblePoints();
        for (int i = 0; i < points.toArray().length;i++){
            point p = points.get(i);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
            p.render(g2d);
        }
    }

    @Override
    public void mouseWheel(MouseWheelEvent e) {
        if (e.getWheelRotation()>0){
            setPointsVisibleRange(pointsVisibleRange-1);
        } else if (e.getWheelRotation()<0){
            setPointsVisibleRange(pointsVisibleRange+1);
        }
    }

    private void setPointsVisibleRange(int i){
        pointsVisibleRange=i;
        if (pointsVisibleRange<1){pointsVisibleRange=1;}
        if (pointsVisibleRange>pointAmount){pointsVisibleRange=pointAmount;}
        pointDistance = (double) getWidth()/pointsVisibleRange;
        constructVisiblePoints();
    }

    @Override
    public void open() {
        spawnAll();
    }

    @Override
    public void close() {
        killAll();
    }

    @Override
    public void onHandlerSave() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            delete(getSelectedPoints());
        } else if (e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_A){
            selectAllBusyPoints();
        }
    }

    private void selectAllBusyPoints(){
        for (point p:getBusyPoints()){
            p.select();
        }
    }

    private void delete(List<point> points) {
        List<point> selectedPoints = new ArrayList<>(points);
        for (point p:selectedPoints){
            p.removeObject();
        }
    }

    public class point{

        private SliderObject object;

        private final int value;

        private int x;

        private final int y = getHeight()/2;

        private boolean selected = false;

        private point(int value){
            this.value=value;
        }
        private SliderObject getObject(){
            return this.object;
        }
        private void addObject(SliderObject object){
            this.object=object;
            busyPoints.add(this);
        }

        private void removeObject(){
            object=null;
            unselect();
            busyPoints.remove(this);
        }

        private void render(Graphics2D g2d){
            int height = pointHeight;
            double pDistance = pointDistance;
            if (value%4==0){height*=1.4;}

            g2d.setColor(Color.black);

            g2d.drawLine(x,y-height/2,x,y+height/2);
            if (object!=null){
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.8f));
                object.selected = selected;

                if (object instanceof SliderObject.Arrow){
                    SliderObject.Arrow a = (SliderObject.Arrow) object;
                    a.renderDrawSlider(g2d,x,y-pointHeight/2, (int) ((pDistance*a.getSlider())),pointHeight);
                }
                object.render(g2d,x,y);
            }
        }

        private void unselect(){
            selected=false;
            selectedPoints.remove(this);
        }

        private void select() {
            unselect();
            selected= true;
            selectedPoints.add(this);
        }

        private void changeSelect() {
            if (selected){
                unselect();
            } else {
                select();
            }
        }
    }
}
