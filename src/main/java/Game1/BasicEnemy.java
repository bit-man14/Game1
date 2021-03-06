package Game1;

import java.awt.*;

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

    public BasicEnemy(int x, int y,double angle, double velX, double velY, ID id, Handler handler) {
        super(x, y,angle, id);
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;

    }

    @Override
    public void tick() {
        int PX = handler.objects.get(0).getX();
        int PY = handler.objects.get(0).getY();

        if (handler.objects.indexOf(handler.objects.get(handler.objects.size() - 1)) == (handler.objects.size() - 1)) {

            if (PX < x && velX > 0) velX *= -1;
            if (PX > x && velX < 0) velX *= -1;
            if (PY < y && velY > 0) velY *= -1;
            if (PY > y && velY < 0) velY *= -1;
        }

        x += (int) velX;
        y += (int) velY;


        if (y <= 0 || y >= Game.HEIGHT - 42 - size) velY *= -1.0;
        if (x <= 0 || x >= Game.WIDTH - 16 - size) velX *= -1.0;
        handler.addObject(new Trail(x, y,0, ID.Trail, Color.RED, size, size, 0.06f, handler));
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
