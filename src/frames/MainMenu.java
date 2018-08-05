package frames;

import frames.listeners.menu.MenuWindowListener;
import frames.panels.menu.CreateProfileMenu;
import frames.panels.menu.NewProfileMenu;
import frames.panels.menu.Panel;
import frames.panels.menu.ProfileCreateOrSelectMenu;
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
    private User currentUser;
    private CardLayout cardLayout;

    private NewProfileMenu newProfileMenu;
    private CreateProfileMenu createProfileMenu;
    private ProfileCreateOrSelectMenu profileCreateOrSelectMenu;

    public MainMenu() {
        this.cardLayout = new CardLayout();
        super.pack();
        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 799);
        super.setVisible(true);
        super.getContentPane().setLayout(cardLayout);
        super.setResizable(false);
        super.addWindowListener(new MenuWindowListener(this));
        loadTextures();
        initializePanels();

        this.users = UserHandler.loadUser();

        if(users == null) {
            switchLayout(Panel.NEW_PROFILE);
        }else{
            switchLayout(Panel.PROFILE_CREATE_SELECT);
        }
    }

    private void loadTextures() {
        try {
            logo = ImageIO.read(new File("resources/menu/pacman_logo.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializePanels(){
        this.newProfileMenu = new NewProfileMenu(this);
        super.getContentPane().add(newProfileMenu, Panel.NEW_PROFILE.toString());

        this.createProfileMenu = new CreateProfileMenu(this);
        super.getContentPane().add(createProfileMenu, Panel.CREATE_PROFILE.toString());

        this.profileCreateOrSelectMenu = new ProfileCreateOrSelectMenu(this);
        super.getContentPane().add(profileCreateOrSelectMenu, Panel.PROFILE_CREATE_SELECT.toString());
    }

    public BufferedImage getLogo() {
        return logo;
    }

    public ArrayList<User> getUsers() {
        if(this.users == null) this.users = new ArrayList<>();
        return users;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public NewProfileMenu getNewProfileMenu() {
        return newProfileMenu;
    }

    public CreateProfileMenu getCreateProfileMenu() {
        return createProfileMenu;
    }

    public void switchLayout(Panel panel){
        if(panel == Panel.NEW_PROFILE){
            cardLayout.show(super.getContentPane(), panel.toString());
        }else if(panel == Panel.CREATE_PROFILE){
            cardLayout.show(super.getContentPane(), panel.toString());
        }
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
            logo = ImageIO.read(new File("resources/menu/pacman_logo.png"));
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
