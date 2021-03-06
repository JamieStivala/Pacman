package menu.panels;

import shared.frames.MainMenu;
import menu.listeners.MenuAnimationHandler;
import menu.listeners.MenuListSelectionListener;
import menu.panels.custom.SelectedListCellRenderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadProfileList extends BasePanel {
    private BufferedImage listOfProfiles;
    private JList<String> profilesList;

    private JLabel createLabel;
    private ImageIcon createTextures[];

    private JLabel loadLabel;
    private ImageIcon loadTextures[];

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public LoadProfileList(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    /**
     * This loads all the JLabel and components needed for the frame to work
     */
    @Override
    void loadComponents() {
        super.loadComponents();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i != super.getMainMenu().getUsers().size(); i++) {
            listModel.add(i, super.getMainMenu().getUsers().get(i).getCharacterName());
        }
        listModel.add(super.getMainMenu().getUsers().size(), "CREATE A PROFILE");

        this.profilesList = new JList<>(listModel);
        this.profilesList.setBounds(312, 310, 826, 300);
        this.profilesList.setBackground(new Color(240, 130, 0));
        this.profilesList.setFont(super.getPacFont());
        this.profilesList.setFixedCellHeight(70);
        this.profilesList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        this.profilesList.setCellRenderer(new SelectedListCellRenderer());
        this.profilesList.addListSelectionListener(new MenuListSelectionListener(super.getMainMenu()));

        JScrollPane scrollPane = new JScrollPane(profilesList);
        scrollPane.setBounds(312, 310, 826, 300);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(2, 0));
        scrollPane.getViewport().setBorder(null);
        scrollPane.setViewportBorder(null);
        super.add(scrollPane);

        createLabel = new JLabel();
        createLabel.setVisible(false);
        createLabel.setIcon(createTextures[0]);
        createLabel.setBounds(946, 630, 192, 32);
        createLabel.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        createLabel.addMouseListener(new MenuAnimationHandler(this.getCreateTextures(), this.getCreateLabel().getBounds(), new Rectangle(898, 630, 240, 40)));
        super.add(createLabel);

        loadLabel = new JLabel();
        loadLabel.setVisible(false);
        loadLabel.setIcon(loadTextures[0]);
        loadLabel.setBounds(1010, 630, 128, 32);
        loadLabel.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        loadLabel.addMouseListener(new MenuAnimationHandler(this.getLoadTextures(), this.getCreateLabel().getBounds(), new Rectangle(978, 630, 160, 40)));
        super.add(loadLabel);
    }

    /**
     * This loads all the textures for the JLabel
     */
    @Override
    void loadTextures() {
        super.loadTextures();
        createTextures = new ImageIcon[2];
        loadTextures = new ImageIcon[2];
        try {
            listOfProfiles = ImageIO.read(new File("resources/menu/textures/profile/list_of_profiles.png"));
            createTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_small.png")));
            createTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_big.png")));
            loadTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_small.png")));
            loadTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_big.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(listOfProfiles, 312, 250, null);
    }

    public JLabel getCreateLabel() {
        return this.createLabel;
    }

    public ImageIcon[] getCreateTextures() {
        return createTextures;
    }

    public JLabel getLoadLabel() {
        return this.loadLabel;
    }

    public ImageIcon[] getLoadTextures() {
        return this.loadTextures;
    }

    public JList<String> getProfilesList() {
        return this.profilesList;
    }

    /**
     * Shows the create button
     */
    public void addCreate() {
        this.loadLabel.setVisible(false);
        this.createLabel.setVisible(true);
    }

    /**
     * Shows the load button
     */
    public void addLoad() {
        this.createLabel.setVisible(false);
        this.loadLabel.setVisible(true);
    }

    /**
     * Reloads all the components of the frame due to updates to the frame
     */
    public void reloadComponents() {
        this.removeAll();
        this.loadComponents();
    }
}