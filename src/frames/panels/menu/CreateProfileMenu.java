package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateProfileMenu extends BasePanel {
    private BufferedImage enterProfileNameTexture;
    public CreateProfileMenu(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        try{
            enterProfileNameTexture = ImageIO.read(new File("resources/menu/textures/profile/please_enter_a_profile_name.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    void loadTextures() {

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(enterProfileNameTexture, 72, 250, null);
    }
}
