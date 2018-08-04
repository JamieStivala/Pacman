package frames.panels.menu;

import frames.MainMenu;

import java.awt.*;

public class NewGameMenu extends BasePanel {
    private MainMenu mainMenu;
    public NewGameMenu(MainMenu mainMenu){
        super(mainMenu);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (mainMenu.getLogo() != null) g.drawImage(mainMenu.getLogo(), 208, 20, 1024, 242, null);
    }

    @Override
    void loadComponents() {

    }

    @Override
    void loadTextures() {

    }
}
