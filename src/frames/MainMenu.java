package frames;

import frames.listeners.menu.MenuWindowListener;
import frames.panels.menu.*;
import frames.panels.menu.Panel;
import user.manager.User;
import user.manager.UserHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class MainMenu extends JFrame{
    private ArrayList<User> users;
    private User currentUser;
    private CardLayout cardLayout;

    private BufferedImage logo;

    private NewProfileMenu newProfileMenu;
    private CreateProfileMenu createProfileMenu;
    private ProfileCreateOrSelectMenu profileCreateOrSelectMenu;
    private LoadProfileList loadProfileList;
    private DeleteProfileList deleteProfileList;
    private MainPanel mainPanel;
    private StatsPanel statsPanel;
    private PlayGame playGame;

    private Panel currentFrame;
    private Panel previousFrame;

    public MainMenu() {
        this.cardLayout = new CardLayout();
        super.pack();
        super.setTitle("Pacman - Main Menu");
        super.setSize(1440, 799);
        super.setVisible(true);
        super.getContentPane().setLayout(cardLayout);
        super.setResizable(false);
        super.addWindowListener(new MenuWindowListener(this));
        this.users = UserHandler.loadUser();

        this.loadTextures();
        this.initializePanels();

        if(users.isEmpty()) {
            this.switchLayout(Panel.NEW_PROFILE);
        }else{
            this.switchLayout(Panel.PROFILE_CREATE_SELECT);
        }
    }

    private void loadTextures() {
        try {
            this.logo = ImageIO.read(new File("resources/menu/pacman_logo.png"));
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

        this.loadProfileList = new LoadProfileList(this);
        super.getContentPane().add(loadProfileList, Panel.LOAD_PROFILE_LIST.toString());

        this.deleteProfileList = new DeleteProfileList(this);
        super.getContentPane().add(deleteProfileList, Panel.DELETE_PROFILE_LIST.toString());

        this.mainPanel = new MainPanel(this);
        super.getContentPane().add(mainPanel, Panel.MAIN_PANEL.toString());

        this.statsPanel = new StatsPanel(this);
        super.getContentPane().add(statsPanel, Panel.STATS_PANEL.toString());

        this.playGame = new PlayGame(this);
        super.getContentPane().add(playGame, Panel.PLAY_GAME_PANEL.toString());
    }

    public BufferedImage getLogo() {
        return this.logo;
    }

    public ArrayList<User> getUsers() {
        if(this.users == null) this.users = new ArrayList<>();
        return users;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public NewProfileMenu getNewProfileMenu() {
        return this.newProfileMenu;
    }

    public CreateProfileMenu getCreateProfileMenu() {
        return this.createProfileMenu;
    }

    public ProfileCreateOrSelectMenu getProfileCreateOrSelectMenu() {
        return this.profileCreateOrSelectMenu;
    }

    public LoadProfileList getLoadProfileList() {
        return this.loadProfileList;
    }

    public DeleteProfileList getDeleteProfileList() {
        return this.deleteProfileList;
    }

    public MainPanel getMainPanel() {
        return this.mainPanel;
    }

    public PlayGame getPlayGame() {
        return playGame;
    }

    public void switchLayout(Panel panel){
        this.previousFrame = currentFrame;
        this.currentFrame = panel;
        this.cardLayout.show(super.getContentPane(), panel.toString());
    }

    public void goBack(){
        switchLayout(this.previousFrame);
    }

    public void setPreviousFrame(Panel previousFrame) {
        this.previousFrame = previousFrame;
    }
}
