package frames.listeners.menu;

import frames.MainMenu;
import sounds.menu.ClickSound;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MenuListSelectionListener implements ListSelectionListener {
    private MainMenu mainMenu;

    public MenuListSelectionListener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            new ClickSound().start();

            if (e.getSource() == this.mainMenu.getLoadProfileList().getProfilesList()) {
                JList<String> list = this.mainMenu.getLoadProfileList().getProfilesList();
                if (list.getSelectedValue().equalsIgnoreCase("CREATE A PROFILE")) {
                    this.mainMenu.getLoadProfileList().addCreate();
                } else {
                    this.mainMenu.getLoadProfileList().addLoad();
                }
            } else if (e.getSource() == this.mainMenu.getDeleteProfileList().getProfilesList()) {
                this.mainMenu.getDeleteProfileList().triggerDeleteButton();
            } else if (e.getSource() == this.mainMenu.getSeedViewerList().getSeeds()) {
                this.mainMenu.getSeedViewerList().triggerButtons();
            }
        }
    }
}
