package frames.listeners;

import frames.MainMenu;
import frames.PacmanFrame;
import frames.panels.menu.Panel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MenuPacmanWindowListener implements WindowListener {
    private MainMenu mainMenu;
    private PacmanFrame pacmanFrame;

    public MenuPacmanWindowListener(MainMenu mainMenu, PacmanFrame pacmanFrame) {
        this.mainMenu = mainMenu;
        this.pacmanFrame = pacmanFrame;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        mainMenu.setVisible(false);
        this.mainMenu.switchLayout(Panel.MAIN_PANEL);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.pacmanFrame.setStopped(true);
        this.mainMenu.setVisible(true);
        this.mainMenu.getSeedViewerList().reloadComponents();
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
