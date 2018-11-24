package menu.panels;

import shared.frames.MainMenu;
import menu.listeners.MenuAnimationHandler;
import menu.listeners.MenuKeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This represent the CreateProfileMenu
 */
public class CreateProfileMenu extends BasePanel {
    private BufferedImage enterProfileNameTexture;

    private JLabel createProfileLabel;
    private ImageIcon createProfileTextures[];

    private JTextField enterProfileNameTextField;

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public CreateProfileMenu(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    /**
     * This loads all the JLabel and components needed for the frame to work
     */
    @Override
    void loadComponents() {
        super.loadComponents();
        this.enterProfileNameTextField = new JTextField();
        this.enterProfileNameTextField.setBounds(72, 300, 1296, 90);
        this.enterProfileNameTextField.setBackground(new Color(240, 130, 0));
        this.enterProfileNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        this.enterProfileNameTextField.addKeyListener(new MenuKeyListener(super.getMainMenu()));
        this.enterProfileNameTextField.setFont(super.getPacFont());
        super.add(enterProfileNameTextField);

        this.createProfileLabel = new JLabel();
        this.createProfileLabel.setBounds(1176, 410, 192, 32);
        this.createProfileLabel.setIcon(createProfileTextures[0]);
        this.createProfileLabel.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        this.createProfileLabel.addMouseListener(new MenuAnimationHandler(this.getCreateProfileTextures(), this.createProfileLabel.getBounds(), new Rectangle(1152, 410, 240, 40)));
        super.add(createProfileLabel);
    }

    /**
     * This loads all the textures for the JLabel
     */
    @Override
    void loadTextures() {
        super.loadTextures();
        this.createProfileTextures = new ImageIcon[2];
        try {
            this.enterProfileNameTexture = ImageIO.read(new File("resources/menu/textures/profile/please_enter_a_profile_name.png"));

            this.createProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_small.png")));
            this.createProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_big.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JTextField getEnterProfileNameTextField() {
        return this.enterProfileNameTextField;
    }

    public JLabel getCreateProfileLabel() {
        return this.createProfileLabel;
    }

    public ImageIcon[] getCreateProfileTextures() {
        return this.createProfileTextures;
    }

    /**
     * This paints the enterProfileName text
     * @param g The java.awt Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(enterProfileNameTexture, 72, 250, null);
    }
}
