package frames.panels.menu;

import frames.MainMenu;
import sounds.menu.ClickSound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class SeedViewerList extends BasePanel {
    public SeedViewerList(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    @Override
    void loadComponents() {
        super.loadComponents();
    }

    @Override
    void loadTextures() {
        super.loadTextures();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent() instanceof JLabel) new ClickSound().start();
        if(e.getComponent() == super.getBackLabel()) {
            super.getMainMenu().goBack();
            super.getMainMenu().setPreviousFrame(Panel.MAIN_PANEL);
        }

    }
}
