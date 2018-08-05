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
    void loadComponents() {
        newProfileLbl = new JLabel();
        newProfileLbl.setBounds(560, 299, 400, 40);
        newProfileLbl.setIcon(newProfileTextures[0]);
        newProfileLbl.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(newProfileLbl);
    }

    @Override
    void loadTextures() {
        newProfileTextures = new ImageIcon[2];
        loadProfileTextures = new ImageIcon[2];
        try{
            newProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_small.png")));
            newProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_big.png")));

            loadProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load__profile_small.png")));
            loadProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_profile_big.png")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
