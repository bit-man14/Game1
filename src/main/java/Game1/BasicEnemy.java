package Game1;

import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject {
    int size = 10;
    double velX;
    double velY;

    @Override
    public double getVelX() {
        return velX;
    }

    @Override
    public void setVelX(double velX) {
        this.velX = velX;
    }

    @Override
    public double getVelY() {
        return velY;
    }

    @Override
    public void setVelY(double velY) {
        this.velY = velY;
    }

    Handler handler;
    Random r=new Random();
    public BasicEnemy(int x, int y,double velX,double velY, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.velX=velX;
        this.velY=velY;
//        velX = r.nextInt(3)+1;
//        velY = r.nextInt(3)+1;
    }

    @Override
    public void tick() {
        int PX = handler.objects.get(0).getX();
        int PY = handler.objects.get(0).getY();

        //velX = 1.0 + (3.0 - 1.0) * r.nextDouble();
        //velY = velX * (PY - y) / (PX - x);
        //velY = Game.clampD(velY, 0.5, 5.0);
        if (PX < x && velX>0) velX *= -1;
        if (PX > x && velX<0) velX *= -1;
        if (PY < y && velY>0) velY *= -1;
        if (PY > y && velY<0) velY *= -1;
        x += (int)velX;
        y += (int)velY;


        if (y <= 0 || y >= Game.HEIGHT - 42 - size) velY *= -1.0;
        if (x <= 0 || x >= Game.WIDTH - 16 - size) velX *= -1.0;
        handler.addObject(new Trail(x,y,ID.Trail,Color.RED,size,size,0.06f,handler));
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
                    //collision

                    //System.out.println("E Rocket hit!");
                }
            }
            if (tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    //velX*=-1;
//                    velX*=-1;
//                    velY*=-1;
//                    handler.removeObject(this);
//                    Game.enemies--;
                    //System.out.println("E Rocket hit!");
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
