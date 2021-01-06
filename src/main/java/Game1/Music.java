package Game1;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music {
    public boolean play;
    FileInputStream fis;
    static AdvancedPlayer player;
    private int pausedOnFrame = 0;

    public Music() {
    }

    {
        try {
            fis = new FileInputStream("D:\\IdeaProjects\\Game1\\src\\main\\resources\\muza.mp3");
            AdvancedPlayer player = new AdvancedPlayer(fis);
            player.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent event) {
                    pausedOnFrame = event.getFrame();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public static void playMp3() {
        try {
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void stopMp3() {
        player.stop();
    }


    public void playbackFinished(PlaybackEvent event) {
        int pausedOnFrame = 0;
        pausedOnFrame = event.getFrame();
    }

}
