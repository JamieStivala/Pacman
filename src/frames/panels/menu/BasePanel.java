package frames.panels.menu;

import frames.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.io.File;

abstract class BasePanel extends JPanel {
    private MainMenu mainMenu;
    private Font font;
    BasePanel(MainMenu mainMenu){
        this.mainMenu = mainMenu;
        super.setBackground(new Color(240, 130, 0));
        super.setLayout(null);
        loadFont();
        loadTextures();
        loadComponents();
        super.repaint();
    }
    abstract void loadComponents();
    abstract void loadTextures();

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (mainMenu.getLogo() != null) g.drawImage(mainMenu.getLogo(), 208, 0, 1024, 242, null);
    }

    private void loadFont(){
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/PacFont.ttf")).deriveFont(Font.PLAIN);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    MainMenu getMainMenu() {
        return mainMenu;
    }

    @Override
    public Font getFont() {
        return font;
    }
}
