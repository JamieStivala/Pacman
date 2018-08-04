package frames.listeners.menu;

import frames.MainMenu;
import sounds.menu.ClickSound;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuMouseListener implements MouseListener {
    private MainMenu mainMenu;
    public MenuMouseListener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() instanceof JLabel){
            new ClickSound().start();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfile()){
            mainMenu.getNewProfileMenu().getNewProfile().setBounds(340, 399, 760, 40);
            mainMenu.getNewProfileMenu().getNewProfile().setIcon(mainMenu.getNewProfileMenu().getNewProfileTextures()[1]);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfile()){
            mainMenu.getNewProfileMenu().getNewProfile().setBounds(416, 399, 608, 32);
            mainMenu.getNewProfileMenu().getNewProfile().setIcon(mainMenu.getNewProfileMenu().getNewProfileTextures()[0]);
        }
    }
}
