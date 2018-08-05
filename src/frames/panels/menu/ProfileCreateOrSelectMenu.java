package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class ProfileCreateOrSelectMenu extends BasePanel {
    private ImageIcon newProfileTextures[];
    private JLabel newProfileLbl;

    private ImageIcon loadProfileTextures[];
    private JLabel loadProfileLbl;

    public ProfileCreateOrSelectMenu(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    @SuppressWarnings("Duplicates")
    void loadComponents() {
        newProfileLbl = new JLabel();
        newProfileLbl.setBounds(416, 299, 608, 32);
        newProfileLbl.setIcon(newProfileTextures[0]);
        newProfileLbl.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(newProfileLbl);

        loadProfileLbl = new JLabel();
        loadProfileLbl.setBounds(528, 499, 384, 32);
        loadProfileLbl.setIcon(loadProfileTextures[0]);
        newProfileLbl.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(loadProfileLbl);
    }

    @Override
    void loadTextures() {
        newProfileTextures = new ImageIcon[2];
        loadProfileTextures = new ImageIcon[2];
        try{
            newProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_small.png")));
            newProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_big.png")));

            loadProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_profile_small.png")));
            loadProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_profile_big.png")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
