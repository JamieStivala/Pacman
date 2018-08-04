package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewGameMenu extends BasePanel {
    private ImageIcon newProfileTextures[];
    private BufferedImage noSaveFound;
    private JLabel newProfile;
    public NewGameMenu(MainMenu mainMenu){
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        newProfile = new JLabel();
        newProfile.setBounds(544, 399, 352, 32);
        newProfile.setIcon(newProfileTextures[0]);
        newProfile.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(newProfile);
    }

    @Override
    void loadTextures() {
        newProfileTextures = new ImageIcon[2];
        try{
            newGameTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new_small.png")));
            newGameTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new_big.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
    }

    public ImageIcon[] getNewProfileTextures() {
        return newProfileTextures;
    }

    public JLabel getNewProfile() {
        return newProfile;
    }
}
