package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuListSelectionListener;
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

    public LoadProfileList(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        DefaultListModel<String> listModel= new DefaultListModel<>();
        for (int i = 0; i != super.getMainMenu().getUsers().size(); i++) {
            listModel.add(i, super.getMainMenu().getUsers().get(i).getCharacterName());
        }

        profiles = new JList<>(listModel);
        profiles.setBounds(312, 310, 826, 300);
        profiles.setBackground(new Color(240, 130, 0));
        profiles.setFont(super.getFont());
        profiles.setFixedCellHeight(70);
        profiles.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        profiles.setCellRenderer(new SelectedListCellRenderer());
        profiles.addListSelectionListener(new MenuListSelectionListener());

        JScrollPane scrollPane = new JScrollPane(profiles);
        scrollPane.setBounds(312, 310, 826, 300);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(2, 0));
        scrollPane.getViewport().setBorder(null);
        scrollPane.setViewportBorder(null);

        super.add(scrollPane);
    }

    @Override
    void loadTextures() {
        try {
            listOfProfiles = ImageIO.read(new File("resources/menu/textures/profile/list_of_profiles.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(listOfProfiles,312 , 250, null);
    }
}