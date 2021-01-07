package Game1;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();


    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        int velX;
        int velY;
        int EX;
        int EY;
        int PX;
        double PY;

        if (HUD.HEALTH > 0) {
            scoreKeep++;
            if (scoreKeep >= 500) {
                scoreKeep = 0;
                PX = handler.objects.get(0).getX();
                PY = handler.objects.get(0).getY();
                hud.setLevel(hud.getLevel() + 1);
                SoundEffect.GONG.play();
                EX = r.nextInt(Game.WIDTH - 26);
                EY = r.nextInt(Game.HEIGHT - 52);
                velX = r.nextInt(3) + 1;
                if (PX < EX) velX *= -1;
                velY = (int) (velX * (PY - EY) / (PX - EX));// aim the player - raster problem!!!
                velY = Game.clamp(velY, 1, velX);
                BasicEnemy newBasicEnemy = new BasicEnemy(EX, EY, velX, velY, ID.BasicEnemy, handler);
                System.out.println(PX);
                System.out.println(PY);
                System.out.println(velX);
                System.out.println(velY);
                System.out.println("---");

                handler.addObject(newBasicEnemy);
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 26), r.nextInt(Game.HEIGHT - 52), ID.FastEnemy, handler));
                Game.enemies += 2;
                velX = handler.objects.get(handler.objects.size() - 1).velX;
                velY = handler.objects.get(handler.objects.size() - 1).velY;
                EX = handler.objects.get(handler.objects.size() - 1).getX();
                EY = handler.objects.get(handler.objects.size() - 1).getY();


            }
        }
        //check player position

    }
}
