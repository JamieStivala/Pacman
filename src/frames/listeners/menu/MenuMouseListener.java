package frames.listeners.menu;

import frames.MainMenu;

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

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent() == mainMenu.getStartGame()){
            mainMenu.getStartGame().setBounds(520, 299, 400, 40);
            mainMenu.getStartGame().setIcon(new ImageIcon(mainMenu.getStartGameTextures()[1]));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent() == mainMenu.getStartGame()){
            mainMenu.getStartGame().setBounds(560, 299, 400, 40);
            mainMenu.getStartGame().setIcon(new ImageIcon(mainMenu.getStartGameTextures()[0]));
        }
    }
}
