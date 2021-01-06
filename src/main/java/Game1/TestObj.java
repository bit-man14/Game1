package Game1;

import java.awt.*;

public class TestObj extends GameObject {
    Handler handler;


    public TestObj(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
//        velX = 1;
//        velY = 1;
    }

    int outerRadius = 30;

    @Override
    public void tick() {
//        x += velX;
//        y += velY;
//        if (y <= size || y >= Game.HEIGHT - size - 42) velY *= -1;
//        if (x <= size || x >= Game.WIDTH - size - 16) velX *= -1;
        x = getX();
        y = getY();
        x = Game.clamp(x, outerRadius, Game.WIDTH - outerRadius - 16);
        y = Game.clamp(y, outerRadius, Game.HEIGHT - outerRadius - 42);
        //collision();
    }
    private void collision() {
        //position at collision
        int colX=x;
        int colY=y;
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject=handler.objects.get(i);
            if(tempObject.getId()==ID.Rocket){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision
//                    System.out.println(colX);
//                    System.out.println(colY);
//                    System.out.println("T Rocket hit!");
                }
            }
            if(tempObject.getId()==ID.Player){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision
                    //System.out.println("T Player hit!");
                }
            }
            if(tempObject.getId()==ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision
                    //System.out.println("T Enemy hit!");
                }
            }
        }
    }
    @Override
    public void render(Graphics g) {

        if (id == ID.TestObj) {
            MyFigures.CircleR(x, y, outerRadius, Color.YELLOW, g);
            MyFigures.CircleR(x, y, outerRadius - 1, Color.BLUE, g);
            MyFigures.CircleR(x, y, outerRadius - 2, Color.BLUE, g);
            MyFigures.WheelR(x, y, outerRadius / 3, Color.MAGENTA, g);
            //MyFigures.PointXY(x, y, Color.WHITE, g);
        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x-outerRadius, y-outerRadius, outerRadius*2, outerRadius*2);
    }

}
