package frames.panels.menu;

import frames.MainMenu;

import javax.swing.*;
import java.awt.*;

abstract class BasePanel extends JPanel {
    private MainMenu mainMenu;
    BasePanel(MainMenu mainMenu){
        this.mainMenu = mainMenu;
        super.setBackground(new Color(240, 130, 0));
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

    MainMenu getMainMenu() {
        return mainMenu;
    }
}
