package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuAnimationHandler;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ProfileCreateOrSelectMenu extends BasePanel {
    private ImageIcon newProfileTextures[];
    private JLabel newProfileLbl;

    private ImageIcon loadProfileTextures[];
    private JLabel loadProfileLbl;

    public ProfileCreateOrSelectMenu(MainMenu mainMenu) {
        super(mainMenu, false);
    }

    @Override
    @SuppressWarnings("Duplicates")
    void loadComponents() {
        super.loadComponents();
        this.newProfileLbl = new JLabel();
        this.newProfileLbl.setBounds(416, 299, 608, 32);
        this.newProfileLbl.setIcon(newProfileTextures[0]);
        this.newProfileLbl.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        this.newProfileLbl.addMouseListener(new MenuAnimationHandler(this.newProfileTextures,  new Rectangle(416, 299, 608, 32), new Rectangle(340, 299, 760, 40)));
        super.add(newProfileLbl);

        this.loadProfileLbl = new JLabel();
        this.loadProfileLbl.setBounds(528, 499, 384, 32);
        this.loadProfileLbl.setIcon(loadProfileTextures[0]);
        this.loadProfileLbl.addMouseListener(new MenuAnimationHandler(this.loadProfileTextures, new Rectangle(528, 499, 384, 32), new Rectangle(480, 499, 760, 40)));
        this.loadProfileLbl.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(loadProfileLbl);
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        this.newProfileTextures = new ImageIcon[2];
        this.loadProfileTextures = new ImageIcon[2];
        try{
            this.newProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_small.png")));
            this.newProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_big.png")));

            this.loadProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_profile_small.png")));
            this.loadProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_profile_big.png")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ImageIcon[] getNewProfileTextures() {
        return this.newProfileTextures;
    }

    public JLabel getNewProfileLbl() {
        return this.newProfileLbl;
    }

    public ImageIcon[] getLoadProfileTextures() {
        return this.loadProfileTextures;
    }

    public JLabel getLoadProfileLbl() {
        return this.loadProfileLbl;
    }
}
