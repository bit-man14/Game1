package Game1;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Gun extends GameObject {
    int sizeX = 10;
    int sizeY = 150;
    double angle=0.2;
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }



    Handler handler;

    public Gun(int x, int y,double angle, ID id, Handler handler) {
        super(x, y,angle, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
//        x+=velX;
//        y+=velY;
        //y = getY();

//        x = Game.clamp(x, 0, Game.WIDTH - 16 - sizeX);
//        y = Game.clamp(y, 0, Game.HEIGHT - 42 - sizeY);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(Game.WIDTH - sizeX / 2, Game.HEIGHT - sizeY / 2, sizeX, sizeY);
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Gun) {
            //super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            AffineTransform old = g2d.getTransform();
            g2d.rotate(angle,Game.WIDTH / 2  - 8,Game.HEIGHT -40);
            //draw shape/image (will be rotated)
            g.setColor(Color.BLUE);
            g.fillRect(Game.WIDTH / 2 - sizeX / 2 - 8, Game.HEIGHT - sizeY / 2 - 21, sizeX, sizeY);
            g.fillRect(Game.WIDTH / 2 - sizeX / 2 - 8, Game.HEIGHT - sizeY / 2 - 21, sizeX, sizeY);
            g.fillPolygon(new int[]{Game.WIDTH/2-sizeY/5-8,Game.WIDTH/2+sizeY/5-8,Game.WIDTH/2-8},new int[]{Game.HEIGHT-40,Game.HEIGHT-40,Game.HEIGHT-40-sizeY/3},3);
            g2d.setTransform(old);
            g.setColor(Color.YELLOW);
            MyFigures.WheelR(Game.WIDTH / 2 - 8, Game.HEIGHT - 40, sizeY/8, Color.YELLOW,g);
            //things you draw after here will not be rotated


        }

    }
}
