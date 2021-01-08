package Game1;

import java.awt.*;

public class MyPlayer extends GameObject {
    int size = 20;
    Handler handler;


    public MyPlayer(int x, int y, double angle,ID id, Handler handler) {
        super(x, y,angle, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
//        if(y<=0||y>=Game.HEIGHT-52) velY*=-1;
//        if(x<=0||x>=Game.WIDTH-26) velX*=-1;

        x = Game.clamp(x, 0, Game.WIDTH - 16 - size);
        y = Game.clamp(y, 0, Game.HEIGHT - 42 - size);

        handler.addObject(new Trail(x, y,0, ID.MyPlayer, Color.GREEN, size, size, 0.09f, handler));

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);


            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    SoundEffect.SHOOT.play();
                    HUD.HEALTH -= 1;
                    //System.out.println("P Enemy hit!");
                }
            }
            if (tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    SoundEffect.SHOOT.play();
                    HUD.HEALTH -= 1;
                    //System.out.println("P Enemy hit!");
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        int size = 20;
        if (id == ID.MyPlayer) {
            g.setColor(Color.GREEN);
            g.fillOval(x, y, size, size);
        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}
