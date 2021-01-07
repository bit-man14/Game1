package Game1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter {
    private Handler handler;

    public MouseInput(Handler handler) {
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.TestObj && e.getButton() == 1) {
                tempObject.setX(e.getX());
                tempObject.setY(e.getY());
            }
            if (tempObject.getId() == ID.MyPlayer && e.getButton() == 3) {
                tempObject.setX(e.getX());
                tempObject.setY(e.getY());
            }
        }

    }

    public void mouseMoved(MouseEvent e) {
//
//        System.out.println("Moved X: " + e.getX());
//        System.out.println("Moved Y: " + e.getY() + "\n---");

    }

    public void mouseDragged(MouseEvent e) {

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects. get(i);
            if (tempObject.getId() == ID.TestObj && e.getModifiersEx() == 1024) {
                tempObject.setX(e.getX());
                tempObject.setY(e.getY());
            }
            if (tempObject.getId() == ID.MyPlayer && e.getModifiersEx() == 4096) {
                tempObject.setX(e.getX());
                tempObject.setY(e.getY());
                //handler.addObject(new Trail(tempObject.getX(), tempObject.getY(), ID.Player, Color.GREEN,Player.getSize(),Player.getSize(),0.09f,handler));
            }
        }
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        int dir;
        int tempSpeed = 20;
        if (e.getWheelRotation() == 1) dir = 1;
        else dir = -1;

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Rocket) {
//                if (dir == 1) tempObject.setVelY(tempSpeed);
//                if (dir == -1) tempObject.setVelY(-tempSpeed);
                if (dir == 1) tempObject.setY(tempObject.getY() + tempSpeed);
                if (dir == -1) tempObject.setY(tempObject.getY() - tempSpeed);
            }
        }
    }
}

