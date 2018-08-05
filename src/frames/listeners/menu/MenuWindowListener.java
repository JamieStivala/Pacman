package frames.listeners.menu;

import frames.MainMenu;
import user.manager.UserHandler;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MenuWindowListener implements WindowListener {
    private MainMenu mainMenu;
    public MenuWindowListener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

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
