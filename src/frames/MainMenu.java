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
    private MainPanel mainPanel;
    private StatsPanel statsPanel;

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

        loadTextures();
        initializePanels();

        if(users.isEmpty()) {
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

        this.loadProfileList = new LoadProfileList(this);
        super.getContentPane().add(loadProfileList, Panel.LOAD_PROFILE_LIST.toString());

        this.mainPanel = new MainPanel(this);
        super.getContentPane().add(mainPanel, Panel.MAIN_PANEL.toString());

        this.statsPanel = new StatsPanel(this);
        super.getContentPane().add(statsPanel, Panel.STATS_PANEL.toString());
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

    public ProfileCreateOrSelectMenu getProfileCreateOrSelectMenu() {
        return profileCreateOrSelectMenu;
    }

    public LoadProfileList getLoadProfileList() {
        return loadProfileList;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void switchLayout(Panel panel){
        if(panel == Panel.NEW_PROFILE){
            cardLayout.show(super.getContentPane(), panel.toString());
        }else if(panel == Panel.CREATE_PROFILE){
            cardLayout.show(super.getContentPane(), panel.toString());
        }else if(panel == Panel.PROFILE_CREATE_SELECT){
            cardLayout.show(super.getContentPane(), panel.toString());
        }else if(panel == Panel.LOAD_PROFILE_LIST){
            cardLayout.show(super.getContentPane(), panel.toString());
        }else if(panel == Panel.MAIN_PANEL){
            cardLayout.show(super.getContentPane(), panel.toString());
        }else if(panel == Panel.STATS_PANEL){
            cardLayout.show(super.getContentPane(), panel.toString());
        }
    }
}
