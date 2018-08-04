package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NewGameMenu extends BasePanel {
    private ImageIcon newGameTextures[];
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
            newGameTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/new_big.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (super.getMainMenu().getLogo() != null) g.drawImage(super.getMainMenu().getLogo(), 208, 20, 1024, 242, null);
        if (super.getMainMenu().getLogo() != null) g.drawImage(super.getMainMenu().getLogo(), 208, 100, 1024, 242, null);
    }
}
