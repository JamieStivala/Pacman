package frames.listeners;

import frames.MainMenu;
import frames.panels.menu.Panel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MenuPacmanWindowListener implements WindowListener {
    private MainMenu mainMenu;

    public MenuPacmanWindowListener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        mainMenu.setVisible(false);
        this.mainMenu.switchLayout(Panel.MAIN_PANEL);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.mainMenu.setVisible(true);
        this.mainMenu.handleScore();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
