package Game1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int tempSpeed = 5;
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) tempObject.setVelY(-tempSpeed);
                if (key == KeyEvent.VK_S) tempObject.setVelY(tempSpeed);
                if (key == KeyEvent.VK_A) tempObject.setVelX(-tempSpeed);
                if (key == KeyEvent.VK_D) tempObject.setVelX(tempSpeed);
            }
            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP) tempObject.setVelY(-tempSpeed);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(tempSpeed);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-tempSpeed);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(tempSpeed);
            }

            //System.out.println("X=" + tempObject.getX() + "    " + "Y=" + tempObject.getY());
        }
        if (key == KeyEvent.VK_M) {
            System.out.println("m");
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) tempObject.setVelY(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
            }

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
            }

//            System.out.println("X=" + tempObject.getX() + "    " + "Y=" + tempObject.getY());
        }
    }

}
