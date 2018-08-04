package frames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends JFrame {
    private BufferedImage logo;
    private BufferedImage[] startGameTextures;
    private JButton startGame;
    public MainMenu() {
        this.loadTextures();
        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 799);
        super.setVisible(true);
        super.setLayout(null);
        super.getContentPane().setBackground(new Color(240, 130, 0));
        super.getContentPane().getGraphics().drawImage(logo, 208, 0, null);
        addButtons();
    }

    private void loadTextures(){
        try {
            logo = ImageIO.read(new File("resources/menu/PacmanLogo.png"));
            startGameTextures[0] = ImageIO.read(new File("resources/menu/buttons/start_before.png"));
            startGameTextures[1] = ImageIO.read(new File("resources/menu/buttons/start_after.png"));
        } catch (Exception e) {
            System.out.println("Error loading: Pacman Logo");
        }
    }

    private void addButtons(){
    }
}
