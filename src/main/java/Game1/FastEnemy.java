package Game1;

import java.awt.*;
import java.util.Random;

public class FastEnemy extends GameObject {
    int size = 5;
    Handler handler;
    Random r=new Random();
    public FastEnemy(int x, int y,double angle, ID id, Handler handler) {
        super(x, y, angle,id);
        this.handler = handler;
        velX = r.nextInt(5)+1;
        velY = r.nextInt(5)+1;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 42 - size) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16 - size) velX *= -1;
        handler.addObject(new Trail(x,y,0,ID.Trail,Color.BLUE,size,size,0.06f,handler));
        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Rocket) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    //velX*=-1;
                    handler.removeObject(this);
                    Game.enemies--;
                    //System.out.println("E Rocket hit!");
                }
            }

            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    velX*=-1;
                    velY*=-1;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        if (id == ID.FastEnemy) {
            g.setColor(Color.BLUE);
            g.fillOval(x, y, size, size);
        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}
