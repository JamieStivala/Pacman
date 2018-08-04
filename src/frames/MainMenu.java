package frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends JFrame {
    private BufferedImage background;
    public MainMenu() {
        try {
            background = ImageIO.read(new File("resources/" + "PacmanBackground.png"));
        } catch (Exception e) {
            System.out.println("Error loading: PacmanBackground");
        }

        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 900);
        super.setVisible(true);
        paint(super.getGraphics());
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(background, 0, 0, null);
    }
}
