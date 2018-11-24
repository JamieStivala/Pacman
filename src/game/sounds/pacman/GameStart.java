package game.sounds.pacman;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This class represents a thread where the game start sound (made by the original Pacman) will be heard repeatedly in the Game
 * Sounds used where Royalty Free unlicensed sounds
 */
public class GameStart extends Thread {
    public void run() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/game/sounds/pacman_beginning.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
