package frames.panels.menu;

import frames.MainMenu;

import javax.swing.*;
import java.awt.*;

public class NewGameMenu extends JPanel {
    private MainMenu mainMenu;
    public NewGameMenu(MainMenu mainMenu){
        this.mainMenu = mainMenu;
        super.setBackground(new Color(240, 130, 0));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (mainMenu.getLogo() != null) g.drawImage(mainMenu.getLogo(), 208, 20, 1024, 242, null);
    }
}