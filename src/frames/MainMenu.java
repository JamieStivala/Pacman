package frames;

import frames.panels.menu.NewGameMenu;
import user.manager.User;
import user.manager.UserHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class MainMenu extends JFrame{
    private BufferedImage logo;
    private ArrayList<User> users;
    private CardLayout cardLayout;

    private NewGameMenu newGameMenu;

    public MainMenu() {
        this.cardLayout = new CardLayout();
        loadTextures();
        initializePanels();

        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 799);
        super.setVisible(true);
        super.getContentPane().setLayout(cardLayout);
        super.setResizable(false);

        this.users = UserHandler.loadUser();
        this.getContentPane().add(newGameMenu);
        cardLayout.show(super.getContentPane(), "NewGameMenu");
    }

    private void loadTextures() {
        try {
            logo = ImageIO.read(new File("resources/menu/PacmanLogo.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializePanels(){
        this.newGameMenu = new NewGameMenu(this);
        cardLayout.addLayoutComponent(newGameMenu, "NewGameMenu");
    }

    public BufferedImage getLogo() {
        return logo;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

/*
public class MainMenu extends JFrame {
    private BufferedImage logo;
    private BufferedImage[] startGameTextures;
    private JLabel startGame;
    private ArrayList<User> users;
    public MainMenu() {
        users = UserHandler.loadUser();
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
            startGameTextures[0] = ImageIO.read(new File("resources/menu/textures/start/start_small.png"));
            startGameTextures[1] = ImageIO.read(new File("resources/menu/textures/start/start_big.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addComponents(){
        startGame = new JLabel();
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

    public BufferedImage getLogo() {
        return logo;
    }
}
*/
