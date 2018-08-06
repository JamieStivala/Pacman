package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuAnimationHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NewProfileMenu extends BasePanel {
    private ImageIcon newProfileTextures[];
    private JLabel newProfileLabel;

    private BufferedImage noSaveFound;

    public NewProfileMenu(MainMenu mainMenu){
        super(mainMenu, false);
    }

    @Override
    void loadComponents() {
        super.loadComponents();
        this.newProfileLabel = new JLabel();
        this.newProfileLabel.setBounds(416, 399, 608, 32);
        this.newProfileLabel.setIcon(newProfileTextures[0]);
        this.newProfileLabel.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        this.newProfileLabel.addMouseListener(new MenuAnimationHandler(this.getNewProfileTextures(), this.getNewProfileLabel().getBounds(), new Rectangle(340, 399, 760, 40)));
        super.add(newProfileLabel);
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        this.newProfileTextures = new ImageIcon[2];
        try{
            this.newProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_small.png")));
            this.newProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/new/new_profile_big.png")));
            this.noSaveFound = ImageIO.read(new File("resources/menu/textures/profile/game_save_not_found.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(this.noSaveFound, 288, 250, null);
    }

    public ImageIcon[] getNewProfileTextures() {
        return this.newProfileTextures;
    }

    public JLabel getNewProfileLabel() {
        return this.newProfileLabel;
    }
}
