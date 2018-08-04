package frames;

import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainMenu extends JFrame {
    private BufferedImage logo;
    private BufferedImage[] startGameTextures;
    private JLabel startGame;
    public MainMenu() {
        this.loadTextures();
        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 799);
        super.setVisible(true);
        super.getContentPane().setLayout(null);
        super.getContentPane().setBackground(new Color(240, 130, 0));
        addComponents();
        repaint();
    }

    public void paint( Graphics g ) {
        super.paint(g);
        if (logo != null) g.drawImage(logo, 208, 20, 1024, 242, null);
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
