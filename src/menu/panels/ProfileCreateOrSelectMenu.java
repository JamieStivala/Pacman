package menu.panels;

import shared.frames.MainMenu;
import menu.listeners.MenuAnimationHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ProfileCreateOrSelectMenu extends BasePanel {
    private ImageIcon newProfileTextures[];
    private JLabel newProfileLbl;

    private ImageIcon loadProfileTextures[];
    private JLabel loadProfileLbl;

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public ProfileCreateOrSelectMenu(MainMenu mainMenu) {
        super(mainMenu, false);
    }

    /**
     * This loads all the JLabel and components needed for the frame to work
     */
    @Override
    @SuppressWarnings("Duplicates")
    void loadComponents() {
        super.loadComponents();
        this.newProfileLbl = new JLabel();
        this.newProfileLbl.setBounds(416, 299, 608, 32);
        this.newProfileLbl.setIcon(newProfileTextures[0]);
        this.newProfileLbl.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        this.newProfileLbl.addMouseListener(new MenuAnimationHandler(this.newProfileTextures, this.newProfileLbl.getBounds(), new Rectangle(340, 299, 760, 40)));
        super.add(newProfileLbl);

        this.loadProfileLbl = new JLabel();
        this.loadProfileLbl.setBounds(528, 499, 384, 32);
        this.loadProfileLbl.setIcon(loadProfileTextures[0]);
        this.loadProfileLbl.addMouseListener(new MenuAnimationHandler(this.loadProfileTextures, this.loadProfileLbl.getBounds(), new Rectangle(480, 499, 760, 40)));
        this.loadProfileLbl.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        super.add(loadProfileLbl);
    }

    /**
     * This loads all the textures for the JLabel
     */
    @Override
    void loadTextures() {
        super.loadTextures();
        this.newProfileTextures = new ImageIcon[2];
        this.loadProfileTextures = new ImageIcon[2];
        try {
            this.newProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_small.png")));
            this.newProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_big.png")));

            this.loadProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_profile_small.png")));
            this.loadProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/load/load_profile_big.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JLabel getNewProfileLbl() {
        return this.newProfileLbl;
    }

    public JLabel getLoadProfileLbl() {
        return this.loadProfileLbl;
    }
}
