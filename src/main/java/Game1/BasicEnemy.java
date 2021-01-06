package Game1;

import java.awt.*;

public class BasicEnemy extends GameObject {
    int size = 10;
    Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 2;
        velY = 2;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 42 - size) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16 - size) velX *= -1;
        handler.addObject(new Trail(x,y,ID.Trail,Color.RED,size,size,0.06f,handler));
        //collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Rocket) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    //velX*=-1;
                    handler.removeObject(this);
                    //System.out.println("E Rocket hit!");
                }
            }
            if (tempObject.getId() == ID.TestObj) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    //System.out.println("E Test object hit!");
                }
            }
            if (tempObject.getId() == ID.Player) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    //System.out.println("E Player hit!");
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        if (id == ID.BasicEnemy) {
            g.setColor(Color.RED);
            g.fillOval(x, y, size, size);
        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}