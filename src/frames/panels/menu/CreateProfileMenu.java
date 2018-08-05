package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuKeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateProfileMenu extends BasePanel {
    private BufferedImage enterProfileNameTexture;
    private JTextField enterProfileName;
    public CreateProfileMenu(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {
        try{
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/PacFont.ttf")).deriveFont(Font.PLAIN);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);

            enterProfileNameTexture = ImageIO.read(new File("resources/menu/textures/profile/please_enter_a_profile_name.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    void loadTextures() {
        Font font = new Font("PacFont Good", Font.PLAIN, 60);
        enterProfileName = new JTextField();
        enterProfileName.setBounds(72, 300, 1296, 90);
        enterProfileName.setBackground(new Color(240, 130, 0));
        enterProfileName.setHorizontalAlignment(SwingConstants.CENTER);
        enterProfileName.addKeyListener(new MenuKeyListener(super.getMainMenu()));
        enterProfileName.setFont(font);
        super.add(enterProfileName);
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
