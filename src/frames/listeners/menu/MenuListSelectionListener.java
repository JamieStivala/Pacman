package frames.listeners.menu;

import frames.MainMenu;
import sounds.menu.ClickSound;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This is going to handle the menu list selection list listener
 */
public class MenuListSelectionListener implements ListSelectionListener {
    private MainMenu mainMenu;

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public MenuListSelectionListener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     * This handles what happens when certain things are pressed in JList
     * @param e ListSelectionEvent
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            new ClickSound().start();

            if (e.getSource() == this.mainMenu.getLoadProfileList().getProfilesList()) {
                JList<String> list = this.mainMenu.getLoadProfileList().getProfilesList();
                if (list.getSelectedValue().equalsIgnoreCase("CREATE A PROFILE")) {
                    this.mainMenu.getLoadProfileList().addCreate(); //Triggers the create profile button
                } else {
                    this.mainMenu.getLoadProfileList().addLoad(); //Triggers the load profile button
                }
            } else if (e.getSource() == this.mainMenu.getDeleteProfileList().getProfilesList()) {
                this.mainMenu.getDeleteProfileList().triggerDeleteButton(); //Shows the delete button
            } else if (e.getSource() == this.mainMenu.getSeedViewerList().getSeeds()) {
                this.mainMenu.getSeedViewerList().triggerButtons(); //Shows the delete and load buttons
            }
        }
    }
}
