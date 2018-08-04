package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewProfileMenu extends BasePanel {
    private ImageIcon newProfileTextures[];
    private BufferedImage noSaveFound;
    private JLabel newProfile;
    public NewProfileMenu(MainMenu mainMenu){
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        newProfile = new JLabel();
        newProfile.setBounds(416, 399, 608, 32);
        newProfile.setIcon(newProfileTextures[0]);
        newProfile.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(newProfile);
    }

    @Override
    void loadTextures() {
        newProfileTextures = new ImageIcon[2];
        try{
            newProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_small.png")));
            newProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_big.png")));
            noSaveFound = ImageIO.read(new File("resources/menu/textures/profile/game_save_not_found.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(noSaveFound, 288, 250, null);
    }

    public ImageIcon[] getNewProfileTextures() {
        return newProfileTextures;
    }

    public JLabel getNewProfile() {
        return newProfile;
    }
}
