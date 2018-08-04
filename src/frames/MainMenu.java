package frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends JFrame {
    BufferedImage image;
    public MainMenu() {
        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 900);
        super.setVisible(true);
        try {
            image = ImageIO.read(new File("resources/" + "PacmanBackground.png"));
        } catch (Exception e) {
            System.out.println("Error loading: PacmanBackground");
        }
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, null);
    }
}
