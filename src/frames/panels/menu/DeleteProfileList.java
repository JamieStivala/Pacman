package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuAnimationHandler;
import frames.listeners.menu.MenuListSelectionListener;
import frames.panels.menu.custom.SelectedListCellRenderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class DeleteProfileList extends BasePanel {
    private JLabel deleteLabel;
    private ImageIcon deleteTextures[];

    private JList<String> profilesList;

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public DeleteProfileList(MainMenu mainMenu) {
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

        deleteLabel = new JLabel();
        deleteLabel.setVisible(false);
        deleteLabel.setIcon(deleteTextures[0]);
        deleteLabel.setBounds(946, 630, 192, 32);
        deleteLabel.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        deleteLabel.addMouseListener(new MenuAnimationHandler(this.deleteTextures, this.deleteLabel.getBounds(), new Rectangle(898, 630, 240, 40)));
        super.add(deleteLabel);
    }

    /**
     * This loads all the textures for the JLabel
     */
    @Override
    void loadTextures() {
        super.loadTextures();
        this.deleteTextures = new ImageIcon[2];
        try {
            this.deleteTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_small.png")));
            this.deleteTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_big.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JLabel getDeleteLabel() {
        return this.deleteLabel;
    }

    public JList<String> getProfilesList() {
        return this.profilesList;
    }

    public void triggerDeleteButton() {
        this.deleteLabel.setVisible(true);
    }

    /**
     * Reloads all the components of the frame due to updates to the frame
     */
    public void reloadComponents() {
        this.removeAll();
        this.loadComponents();
    }
}
