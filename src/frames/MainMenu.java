package frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends JFrame {
    private BufferedImage logo;
    private JButton startGame;
    public MainMenu() {
        this.loadTextures();
        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 799);
        super.setVisible(true);
        super.setLayout(null);
        super.getContentPane().getGraphics().drawImage(logo, 208, 0, null);
    }

    private void loadTextures(){
        try {
            logo = ImageIO.read(new File("resources/menu/PacmanLogo.png"));
        } catch (Exception e) {
            System.out.println("Error loading: Pacman Logo");
        }
    }
}
