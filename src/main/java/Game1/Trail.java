package Game1;

import java.awt.*;

public class Trail extends GameObject {
    private  float life;
    private Handler handler;
    private float alpha = 1;
    private Color color;
    private int width, height;

    public Trail(int x, int y, double angle,ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y,angle, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    }

    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= life - 0.001f;
        } else {
            handler.removeObject(this);
        }
//        x = Game.clamp(x, 0, Game.WIDTH - 16 - size);
//        y = Game.clamp(y, 0, Game.HEIGHT - 42 - size);
        //collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Rocket) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision

                    //System.out.println("P Rocket hit!");
                }
            }
            if (tempObject.getId() == ID.TestObj) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    //System.out.println("P Test object hit!");
                }
            }
            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision
                    //System.out.println("P Enemy hit!");
                }
            }
        }
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color.darker());
        g.fillOval(x, y, width, height);
        //other obj not transparent
        g2d.setComposite(makeTransparent(1));
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
