package frames.panels.menu;

import frames.MainMenu;
import sounds.menu.ClickSound;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

abstract class BasePanel extends JPanel implements MouseListener {
    private MainMenu mainMenu;
    private Font font;

    private JLabel backLabel;
    private ImageIcon backTextures[];

    private boolean showBack;

    BasePanel(MainMenu mainMenu, boolean showBack){
        this.mainMenu = mainMenu;
        this.showBack = showBack;
        super.setBackground(new Color(240, 130, 0));
        super.setLayout(null);
        loadFont();
        loadTextures();
        loadComponents();
        super.repaint();
    }

    void loadComponents(){
        if(showBack){
            backLabel = new JLabel();
            backLabel.setIcon(backTextures[0]);
            backLabel.setBounds(1240, 680, 128, 32);
            backLabel.addMouseListener(this);
            super.add(backLabel);
        }
    }

    void loadTextures(){
        if(showBack){
            backTextures = new ImageIcon[2];
            try {
                backTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/back/back_small.png")));
                backTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/back/back_big.png")));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (mainMenu.getLogo() != null) g.drawImage(mainMenu.getLogo(), 208, 0, 1024, 242, null);
    }

    private void loadFont(){
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/PacFont.ttf")).deriveFont(Font.PLAIN, 60);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    MainMenu getMainMenu() {
        return this.mainMenu;
    }

    @Override
    public Font getFont() {
        return this.font;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() instanceof JLabel) new ClickSound().start();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
