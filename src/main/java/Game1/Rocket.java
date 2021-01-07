package Game1;

import java.awt.*;

public class Rocket extends GameObject {
    int sizeX = 20;
    int sizeY = 100;
    Handler handler;
    public Rocket(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler=handler;
    }

    @Override
    public void tick() {
//        x+=velX;
//        y+=velY;
        //y = getY();

        x = Game.clamp(x, 0, Game.WIDTH - 16 - sizeX);
        y = Game.clamp(y, 0, Game.HEIGHT - 42 - sizeY);
        collision();
    }
    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject=handler.objects.get(i);
            if(tempObject.getId()==ID.MyPlayer){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision

                    //System.out.println("R Player hit!");
                }
            }
            if(tempObject.getId()==ID.TestObj){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision

                    //System.out.println("R Test object hit!");
                }
            }
            if(tempObject.getId()==ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision
                    //System.out.println("R Enemy hit!");
                }
            }
        }
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
