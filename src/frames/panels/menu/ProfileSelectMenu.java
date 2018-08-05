package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class ProfileSelectMenu extends BasePanel {
    private ImageIcon newProfileTextures[];
    private ImageIcon loadProfileTextures[];

    public ProfileSelectMenu(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {

    }

    @Override
    void loadTextures() {
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
