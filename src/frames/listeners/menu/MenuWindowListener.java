package frames.listeners.menu;

import frames.MainMenu;
import user.manager.UserHandler;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * This is the menu window listener that when the window is closing it saves the user
 */
public class MenuWindowListener implements WindowListener {
    private MainMenu mainMenu;

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public MenuWindowListener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Saves the user on exit
     * @param e The WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent e) {
        UserHandler.saveUser(mainMenu.getUsers());
        System.exit(0);
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
