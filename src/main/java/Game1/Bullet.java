package Game1;

import java.awt.*;

public class Bullet extends GameObject {
    int size = 2;
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

    public Bullet(int x, int y, double angle, double velX, double velY, ID id, Handler handler) {
        super(x, y,angle, id);
        this.handler = handler;
        this.velX = velX;
        this.velY = velY;

    }

    @Override
    public void tick() {

        x += (int) velX;
        y += (int) velY;

        handler.addObject(new Trail(x, y,0, ID.Trail, Color.RED, size, size, 0.06f, handler));
        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(this);
                    Game.enemies--;
                }
            }
            if (tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(this);
                    Game.enemies--;
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
