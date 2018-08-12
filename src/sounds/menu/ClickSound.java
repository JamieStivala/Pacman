package sounds.menu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This class represents a thread where the clicking sound (similar to the one in Minecraft) will be heard when clicking a Button/JLabel
 * Sounds used where Royalty Free unlicensed sounds
 */
public class ClickSound extends Thread {
    public void run() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resources/menu/sounds/click.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
