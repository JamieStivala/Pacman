package sounds.pacman;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This class represents a thread where the death sound (made by the Pacman when dying) will be heard repeatedly in the Game
 * Sounds used where Royalty Free unlicensed sounds
 */
public class Death extends Thread {
    public void run() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/game/sounds/pacman_death.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
