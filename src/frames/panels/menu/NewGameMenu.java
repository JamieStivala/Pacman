package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NewGameMenu extends BasePanel {
    private ImageIcon newGameTextures[];
    private JLabel newProfile;
    public NewGameMenu(MainMenu mainMenu){
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        newProfile = new JLabel();
        newProfile.setBounds(560, 299, 400, 40);
        newProfile.setIcon(newGameTextures[0]);
        newProfile.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(newProfile);
    }

    @Override
    void loadTextures() {
        newGameTextures = new ImageIcon[2];
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

    public ImageIcon[] getNewGameTextures() {
        return newGameTextures;
    }

    public JLabel getNewProfile() {
        return newProfile;
    }
}
