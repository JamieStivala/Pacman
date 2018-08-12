package frames;

import frames.listeners.MenuPacmanWindowListener;
import frames.listeners.menu.MenuMouseListener;
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

/**
 * This class is the entry point of the MainMenu and of the whole game
 *
 * In this class there are all the JPanels, the card layout used, all the users and the current user being played
 */
public class MainMenu extends JFrame {
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
    private SeedViewerList seedViewerList;

    private MenuMouseListener sharedMenuMouseListener;

    private Panel currentFrame;
    private Panel previousFrame;

    /**
     * The main constructor of the menus
     *
     * This sets the title to Pacman - Main Menu
     * Sets the layout to card layout
     * Starts the shared MenuMouseListener
     * Sets the frame size to 1440 x 799
     * Sets the visibility to true
     * Sets the frame as not resizable
     * Adds the window listener
     * Loads all the users and switches the panel depending on if the save file is found
     */
    public MainMenu() {
        this.cardLayout = new CardLayout();
        this.sharedMenuMouseListener = new MenuMouseListener(this);
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

        if (users.isEmpty()) {
            this.switchLayout(Panel.NEW_PROFILE);
        } else {
            this.switchLayout(Panel.PROFILE_CREATE_SELECT);
        }
    }

    /**
     * Loads the logo for global use
     */
    private void loadTextures() {
        try {
            this.logo = ImageIO.read(new File("resources/menu/pacman_logo.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This starts all the panels and adds them to the content pain to use them in the CardLayout
     */
    private void initializePanels() {
        this.profileCreateOrSelectMenu = new ProfileCreateOrSelectMenu(this);
        super.getContentPane().add(profileCreateOrSelectMenu, Panel.PROFILE_CREATE_SELECT.toString());

        this.newProfileMenu = new NewProfileMenu(this);
        super.getContentPane().add(newProfileMenu, Panel.NEW_PROFILE.toString());

        this.createProfileMenu = new CreateProfileMenu(this);
        super.getContentPane().add(createProfileMenu, Panel.CREATE_PROFILE.toString());

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

        this.seedViewerList = new SeedViewerList(this);
        super.getContentPane().add(seedViewerList, Panel.SEED_VIEWER_LIST.toString());
    }


    /**
     * @return The pacman logo
     */
    public BufferedImage getLogo() {
        return this.logo;
    }

    /**
     * @return The ArrayList of users
     */
    public ArrayList<User> getUsers() {
        if (this.users == null) this.users = new ArrayList<>();
        return users;
    }

    /**
     * @return The current user being used
     */
    public User getCurrentUser() {
        return this.currentUser;
    }

    /**
     * @param currentUser The user to be set as the current user
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return The NewProfileMenu panel
     */
    public NewProfileMenu getNewProfileMenu() {
        return this.newProfileMenu;
    }

    /**
     * @return The CreateProfileMenu panel
     */
    public CreateProfileMenu getCreateProfileMenu() {
        return this.createProfileMenu;
    }

    /**
     * @return The ProfileCreateOrSelectMenu panel
     */
    public ProfileCreateOrSelectMenu getProfileCreateOrSelectMenu() {
        return this.profileCreateOrSelectMenu;
    }

    /**
     * @return The LoadProfileList panel
     */
    public LoadProfileList getLoadProfileList() {
        return this.loadProfileList;
    }

    /**
     * @return The DeleteProfileList panel
     */
    public DeleteProfileList getDeleteProfileList() {
        return this.deleteProfileList;
    }

    /**
     * @return The MainPanel panel
     */
    public MainPanel getMainPanel() {
        return this.mainPanel;
    }

    /**
     * @return The PlayGame panel
     */
    public PlayGame getPlayGame() {
        return playGame;
    }

    /**
     * @return The SeedViewerList panel
     */
    public SeedViewerList getSeedViewerList() {
        return seedViewerList;
    }

    /**
     * @return The StatsPanel panel
     */
    public StatsPanel getStatsPanel() {
        return statsPanel;
    }

    /**
     * @return The shared MenuMouseListener
     */
    public MenuMouseListener getSharedMenuMouseListener() {
        return sharedMenuMouseListener;
    }

    /**
     * The previous frame is saved for the back button to work without extra code
     * @param panel This panel to switch to
     */
    public void switchLayout(Panel panel) {
        this.previousFrame = currentFrame;
        this.currentFrame = panel;
        this.cardLayout.show(super.getContentPane(), panel.toString());
    }

    /**
     * Switches the to the back panel
     */
    public void goBack() {
        switchLayout(this.previousFrame);
    }

    /**
     * This is used when the user is not expecting the previous frame to prevent looping in the menu
     * @param previousFrame The previous panel to switch to
     */
    public void setPreviousFrame(Panel previousFrame) {
        this.previousFrame = previousFrame;
    }

    /**
     * This starts the PacmanFrame with a random seed
     */
    public void startGame() {
        PacmanFrame pacmanFrame = new PacmanFrame(this.currentUser);
        pacmanFrame.addWindowListener(new MenuPacmanWindowListener(this, pacmanFrame));
    }

    /**
     * This starts the PacmanFrame with the specified seed
     */
    public void startGame(long seed) {
        PacmanFrame pacmanFrame = new PacmanFrame(this.currentUser, seed);
        pacmanFrame.addWindowListener(new MenuPacmanWindowListener(this, pacmanFrame));
    }

    /**
     * This handles the score for when the game ends
     */
    public void handleScore() {
        if (currentUser.getLastGameScore() > currentUser.getHighestScore()) {
            currentUser.setHighestScore(currentUser.getLastGameScore());
        }
        currentUser.setTotalScore(currentUser.getTotalScore() + currentUser.getLastGameScore());

        this.getStatsPanel().repaint();
    }
}
