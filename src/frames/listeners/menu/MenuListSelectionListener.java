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
        if(e.getValueIsAdjusting()) {
            new ClickSound().start();

            if(e.getSource() == mainMenu.getLoadProfileList().getProfilesList()){
                JList<String> list = mainMenu.getLoadProfileList().getProfilesList();
                if(list.getSelectedValue().equalsIgnoreCase("CREATE A PROFILE")){
                    mainMenu.getLoadProfileList().addCreate();
                }else {
                    mainMenu.getLoadProfileList().addLoad();
                }
            }
        }
    }
}
