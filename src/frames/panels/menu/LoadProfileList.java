package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadProfileList extends BasePanel {
    private BufferedImage listOfProfiles;
    public LoadProfileList(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {
    }

    @Override
    void loadTextures() {
        try {
            listOfProfiles = ImageIO.read(new File("resources/textures/profile/list_of_profiles.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
