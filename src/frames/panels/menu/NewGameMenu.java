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
}
