package Game1;

import java.awt.*;

public class Rocket extends GameObject {
    int sizeX = 20;
    int sizeY = 100;
    Handler handler;
    public Rocket(int x, int y,double angle, ID id,Handler handler) {
        super(x, y,angle, id);
        this.handler=handler;
    }

    @Override
    public void tick() {
//        x+=velX;
//        y+=velY;
        //y = getY();

        x = Game.clamp(x, 0, Game.WIDTH - 16 - sizeX);
        y = Game.clamp(y, 0, Game.HEIGHT - 42 - sizeY);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, sizeX, sizeY);
    }

    @Override
    public void render(Graphics g) {

        if (id == ID.Rocket) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, sizeX, sizeY);
        }

    }
}
