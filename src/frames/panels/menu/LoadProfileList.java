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
    private JList<String> profiles;

    private JLabel create;
    private ImageIcon createTextures[];

    private JLabel load;
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

        profiles = new JList<>(listModel);
        profiles.setBounds(312, 310, 826, 300);
        profiles.setBackground(new Color(240, 130, 0));
        profiles.setFont(super.getFont());
        profiles.setFixedCellHeight(70);
        profiles.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        profiles.setCellRenderer(new SelectedListCellRenderer());
        profiles.addListSelectionListener(new MenuListSelectionListener(super.getMainMenu()));

        JScrollPane scrollPane = new JScrollPane(profiles);
        scrollPane.setBounds(312, 310, 826, 300);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(2, 0));
        scrollPane.getViewport().setBorder(null);
        scrollPane.setViewportBorder(null);
        super.add(scrollPane);

        create = new JLabel();
        create.setVisible(false);
        create.setIcon(createTextures[0]);
        create.setBounds(946, 630, 192, 32);
        create.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(create);

        load = new JLabel();
        load.setVisible(false);
        load.setIcon(loadTextures[0]);
        load.setBounds(1010, 630, 128, 32);
        load.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(load);
    }

    @Override
    void loadTextures() {
        createTextures = new ImageIcon[2];
        loadTextures = new ImageIcon[2];
        try {
            listOfProfiles = ImageIO.read(new File("resources/menu/textures/profile/list_of_profiles.png"));
            createTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_small.png")));
            createTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_big.png")));
            loadTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_small.png")));
            loadTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_big.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(listOfProfiles,312 , 250, null);
    }

    public JLabel getCreate() {
        return create;
    }

    public void setCreate(JLabel create) {
        this.create = create;
    }

    public ImageIcon[] getCreateTextures() {
        return createTextures;
    }

    public void setCreateTextures(ImageIcon[] createTextures) {
        this.createTextures = createTextures;
    }

    public JLabel getLoad() {
        return load;
    }

    public void setLoad(JLabel load) {
        this.load = load;
    }

    public ImageIcon[] getLoadTextures() {
        return loadTextures;
    }

    public void setLoadTextures(ImageIcon[] loadTextures) {
        this.loadTextures = loadTextures;
    }

    public JList<String> getProfiles() {
        return profiles;
    }

    public void addCreate(){
        load.setVisible(false);
        create.setVisible(true);
    }

    public void addLoad(){
        create.setVisible(false);
        load.setVisible(true);
    }
}