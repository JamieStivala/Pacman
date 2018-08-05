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
    private JLabel createProfileLbl;
    private ImageIcon createProfileTextures[];
    private JTextField enterProfileName;
    public CreateProfileMenu(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        enterProfileName = new JTextField();
        enterProfileName.setBounds(72, 300, 1296, 90);
        enterProfileName.setBackground(new Color(240, 130, 0));
        enterProfileName.setHorizontalAlignment(SwingConstants.CENTER);
        enterProfileName.addKeyListener(new MenuKeyListener(super.getMainMenu()));
        enterProfileName.setFont(super.getFont());
        super.add(enterProfileName);

        createProfileLbl = new JLabel();
        createProfileLbl.setBounds(1176, 410, 192, 32);
        createProfileLbl.setIcon(createProfileTextures[0]);
        createProfileLbl.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(createProfileLbl);
    }

    @Override
    void loadTextures() {
        createProfileTextures = new ImageIcon[2];
        try{
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

    public JLabel getCreateProfileLbl() {
        return createProfileLbl;
    }

    public ImageIcon[] getCreateProfileTextures() {
        return createProfileTextures;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(enterProfileNameTexture, 72, 250, null);
    }
}
