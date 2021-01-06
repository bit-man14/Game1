package Game1;

import java.awt.*;

public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 200;
    private int score = 0;
    private Handler handler;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        if (HEALTH > 0) score++;

    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 25);
        g.setColor(new Color(200 - greenValue, greenValue, 0));
        g.fillRect(15, 15, HEALTH * 2, 25);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 25);
        g.drawString(String.valueOf(HEALTH), 110, 32);
        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
        g.drawString("Enemies: " + Game.enemies, 15, 96);
        //g.drawString("FPS: " + Game.getFrames(), 15, 96);
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        if (HEALTH == 0) {
            g.drawString("GAME OVER", Game.WIDTH / 2 - 125, Game.HEIGHT / 2);
        }
    }
}
