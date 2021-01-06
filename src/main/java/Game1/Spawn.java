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
        if (HUD.HEALTH > 0) {
            scoreKeep++;
            if (scoreKeep >= 500) {
                scoreKeep = 0;
                hud.setLevel(hud.getLevel() + 1);
                SoundEffect.GONG.play();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 26), r.nextInt(Game.HEIGHT - 52), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 26), r.nextInt(Game.HEIGHT - 52), ID.FastEnemy, handler));
                Game.enemies += 2;
            }
        }

    }
}
