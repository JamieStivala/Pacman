package sounds.pacman;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This class represents a thread where the chomp sound (made by the Pacman) will be heard repeatedly in the Game
 * Sounds used where Royalty Free unlicensed sounds
 */
public class Chomp extends Thread {
    public void run() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/game/sounds/pacman_chomp.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
