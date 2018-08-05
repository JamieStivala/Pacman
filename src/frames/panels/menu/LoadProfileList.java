package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuListSelectionListener;
import frames.listeners.menu.MenuMouseListener;
import frames.panels.menu.custom.SelectedListCellRenderer;

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

    public LoadProfileList(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        DefaultListModel<String> listModel= new DefaultListModel<>();
        for (int i = 0; i != super.getMainMenu().getUsers().size(); i++) {
            listModel.add(i, super.getMainMenu().getUsers().get(i).getCharacterName());
        }
        listModel.add(super.getMainMenu().getUsers().size(), "CREATE A PROFILE");

        profilesList = new JList<>(listModel);
        profilesList.setBounds(312, 310, 826, 300);
        profilesList.setBackground(new Color(240, 130, 0));
        profilesList.setFont(super.getFont());
        profilesList.setFixedCellHeight(70);
        profilesList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        profilesList.setCellRenderer(new SelectedListCellRenderer());
        profilesList.addListSelectionListener(new MenuListSelectionListener(super.getMainMenu()));

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
        createLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(createLabel);

        loadLabel = new JLabel();
        loadLabel.setVisible(false);
        loadLabel.setIcon(loadTextures[0]);
        loadLabel.setBounds(1010, 630, 128, 32);
        loadLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(loadLabel);
    }

    @Override
    void loadTextures() {
        createTextures = new ImageIcon[2];
        loadTextures = new ImageIcon[2];
        try {
            listOfProfiles = ImageIO.read(new File("resources/menu/textures/profile/list_of_profiles.png"));
            createTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/createLabel/create_small.png")));
            createTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/createLabel/create_big.png")));
            loadTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/loadLabel/load_small.png")));
            loadTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/loadLabel/load_big.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(listOfProfiles,312 , 250, null);
    }

    public JLabel getCreateLabel() {
        return createLabel;
    }

    public void setCreateLabel(JLabel createLabel) {
        this.createLabel = createLabel;
    }

    public ImageIcon[] getCreateTextures() {
        return createTextures;
    }

    public void setCreateTextures(ImageIcon[] createTextures) {
        this.createTextures = createTextures;
    }

    public JLabel getLoadLabel() {
        return loadLabel;
    }

    public void setLoadLabel(JLabel loadLabel) {
        this.loadLabel = loadLabel;
    }

    public ImageIcon[] getLoadTextures() {
        return loadTextures;
    }

    public void setLoadTextures(ImageIcon[] loadTextures) {
        this.loadTextures = loadTextures;
    }

    public JList<String> getProfilesList() {
        return profilesList;
    }

    public void addCreate(){
        loadLabel.setVisible(false);
        createLabel.setVisible(true);
    }

    public void addLoad(){
        createLabel.setVisible(false);
        loadLabel.setVisible(true);
    }
}