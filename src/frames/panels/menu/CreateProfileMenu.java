package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuKeyListener;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateProfileMenu extends BasePanel {
    private BufferedImage enterProfileNameTexture;
    private JLabel createProfile;
    private ImageIcon createProfileTextures[];
    private JTextField enterProfileName;
    public CreateProfileMenu(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        Font font = new Font("PacFont Good", Font.PLAIN, 60);
        enterProfileName = new JTextField();
        enterProfileName.setBounds(72, 300, 1296, 90);
        enterProfileName.setBackground(new Color(240, 130, 0));
        enterProfileName.setHorizontalAlignment(SwingConstants.CENTER);
        enterProfileName.addKeyListener(new MenuKeyListener(super.getMainMenu()));
        enterProfileName.setFont(font);
        super.add(enterProfileName);
    }

    @Override
    void loadTextures() {
        createProfileTextures = new ImageIcon[2];
        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/PacFont.ttf")).deriveFont(Font.PLAIN);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);

            enterProfileNameTexture = ImageIO.read(new File("resources/menu/textures/profile/please_enter_a_profile_name.png"));

            createProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_small.png")));
            createProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/create/create_big.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public JTextField getEnterProfileName() {
        return enterProfileName;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(enterProfileNameTexture, 72, 250, null);
    }
}
