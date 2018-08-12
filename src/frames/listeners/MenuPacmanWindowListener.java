package frames.listeners;

import frames.MainMenu;
import frames.PacmanFrame;
import frames.panels.menu.Panel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * This is the window listener that connects the Pacman to the MainMenu
 * It is attached the the PacmanFrame
 */
public class MenuPacmanWindowListener implements WindowListener {
    private MainMenu mainMenu;
    private PacmanFrame pacmanFrame;

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     * @param pacmanFrame The object of the pacmanFrame which stores most of the objects regarding the game
     */
    public MenuPacmanWindowListener(MainMenu mainMenu, PacmanFrame pacmanFrame) {
        this.mainMenu = mainMenu;
        this.pacmanFrame = pacmanFrame;
    }

    /**
     * This handles what happens when the pacman frame does when is starts
     * It sets the main menu to visible and also switches the layout of the MainMenu panel
     * @param e WindowEvent
     */
    @Override
    public void windowOpened(WindowEvent e) {
        mainMenu.setVisible(false);
        this.mainMenu.switchLayout(Panel.MAIN_PANEL);
    }

    /**
     * This handles what happens when the pacman frame when it is closed
     * @param e WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent e) {
        this.pacmanFrame.setStopped(true);
        this.pacmanFrame.dispose();
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
