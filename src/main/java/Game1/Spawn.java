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
        double velX;
        double velY;
        int EX;
        int EY;
        int PX;
        int PY;

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
                velX = 1.0 + (3.0 - 1.0) * r.nextDouble();
                velY = 1.0 + (3.0 - 1.0) * r.nextDouble();
                if (PX < EX && velX > 0) velX *= -1;
                if (PX > EX && velX < 0) velX *= -1;
                if (PY < EY && velY > 0) velY *= -1;
                if (PY > EY && velY < 0) velY *= -1;

                BasicEnemy newBasicEnemy = new BasicEnemy(EX, EY, velX, velY, ID.BasicEnemy, handler);
//                System.out.println("Player pos:");
//                System.out.println("PX = " + PX);
//                System.out.println("PY = " + PY);
//                System.out.println("EX = " + EX);
//                System.out.println("EY = " + EY);
//                System.out.println("Enemy vector:");
//                System.out.println(velX);
//                System.out.println(velY);
//                System.out.println("---");

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
