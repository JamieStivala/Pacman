package frames;

import frames.listeners.menu.MenuMouseListener;
import frames.listeners.menu.MenuWindowListener;

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
        super.addWindowListener(new MenuWindowListener());
        addComponents();
        repaint();
    }

    public void paint( Graphics g ) {
        super.paint(g);
        if (logo != null) g.drawImage(logo, 208, 20, 1024, 242, null);
    }

    private void loadTextures() {
        this.startGameTextures = new BufferedImage[2];
        try {
            logo = ImageIO.read(new File("resources/menu/PacmanLogo.png"));
            startGameTextures[0] = ImageIO.read(new File("resources/menu/buttons/start_before.png"));
            startGameTextures[1] = ImageIO.read(new File("resources/menu/buttons/start_after.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addComponents(){
        startGame = new JLabel();
        startGame.setName("start");
        startGame.setBounds(560, 299, 400, 40);
        startGame.setIcon(new ImageIcon(startGameTextures[0]));
        startGame.addMouseListener(new MenuMouseListener(this));
        super.getContentPane().add(startGame);
    }

    public JLabel getStartGame() {
        return startGame;
    }

    public BufferedImage[] getStartGameTextures() {
        return startGameTextures;
    }
}
