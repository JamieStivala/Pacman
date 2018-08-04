package frames.panels.menu;

import frames.MainMenu;

import javax.swing.*;
import java.awt.*;

public abstract class BasePanel extends JPanel {
    private MainMenu mainMenu;
    BasePanel(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }
    abstract void loadComponents();
    abstract void loadTextures();

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (mainMenu.getLogo() != null) g.drawImage(mainMenu.getLogo(), 208, 20, 1024, 242, null);
    }
}
