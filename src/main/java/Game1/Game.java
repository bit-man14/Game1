package Game1;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable {
    //public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; //480
    public static final int WIDTH = 720, HEIGHT = WIDTH / 12 * 9; //480
    private Thread thread;
    private boolean running = false;
    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    public static int frames = 0;
    public static int enemies = 2;

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public static int getFrames() {
        return frames;
    }

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler));
        this.addMouseMotionListener(new MouseInput(handler));
        this.addMouseWheelListener(new MouseInput(handler));
        new Window(WIDTH, HEIGHT, "My First Game", this);
        hud = new HUD();
        spawner = new Spawn(handler, hud);
        r = new Random();
        handler.addObject(new MyPlayer(WIDTH / 2, HEIGHT / 2,0, ID.MyPlayer, handler));//first element in handler array
        handler.addObject(new Gun(100,100,0,ID.Gun, handler));//Gun
        //handler.addObject(new TestObj(WIDTH / 2, HEIGHT / 2,0, ID.TestObj, handler));
        //handler.addObject(new Rocket(WIDTH - 200, HEIGHT / 2,0, ID.Rocket, handler));
        //handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 26), r.nextInt(HEIGHT - 52),0,1.0 + (3.0 - 1.0) * r.nextDouble(),1.0 + (3.0 - 1.0) * r.nextDouble(), ID.BasicEnemy, handler));
        //handler.addObject(new FastEnemy(r.nextInt(WIDTH - 26), r.nextInt(HEIGHT - 52), 0,ID.FastEnemy, handler));

    }

    public  int playerX() {
        int x = 0;
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.MyPlayer) {
                x = tempObject.getX();
            }
        }
        return x;
    }

    public  int playerY() {
        int y = 0;
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.MyPlayer) {
                y = tempObject.getY();
            }
        }
        return y;
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        //Snippet
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        //int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //net
//        g.setColor(Color.DARK_GRAY);
//        int step = 50;
//        for (int i = step; i < WIDTH; i += step) {
//            g.drawLine(i, 0, i, HEIGHT);
//        }
//        for (int i = step; i < HEIGHT; i += step) {
//            g.drawLine(0, i, WIDTH, i);
//        }


        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    private void tick() {
        handler.tick();
        hud.tick();
        spawner.tick();
    }


    public static int clamp(int var, int min, int max) {
        if (var > max)
            return max;

        else if (var < min)
            return min;

        return var;
    }
    public static double clampD(double var, double min, double max) {
        if (var > max)
            return max;

        else if (var < min)
            return min;

        return var;
    }


    public static void main(String[] args) {
        new Game();


    }
}
