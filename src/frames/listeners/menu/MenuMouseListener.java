package frames.listeners.menu;

import frames.MainMenu;
import frames.panels.menu.Panel;
import sounds.menu.ClickSound;
import user.manager.User;

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

        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfile()){
            mainMenu.switchLayout(Panel.CREATE_PROFILE);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfile() && !mainMenu.getCreateProfileMenu().getEnterProfileName().getText().isEmpty() && !mainMenu.getCreateProfileMenu().getEnterProfileName().getText().trim().isEmpty() && mainMenu.getCreateProfileMenu().getEnterProfileName().getText() != null){
            User user = new User(mainMenu.getCreateProfileMenu().getEnterProfileName().getText());
            this.mainMenu.getUsers().add(user);
            this.mainMenu.setCurrentUser(user);
            //Switch Layout
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
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfile()){
            mainMenu.getCreateProfileMenu().getCreateProfile().setBounds(1152, 410, 240, 40);
            mainMenu.getCreateProfileMenu().getCreateProfile().setIcon(mainMenu.getCreateProfileMenu().getCreateProfileTextures()[1]);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfile()){
            mainMenu.getNewProfileMenu().getNewProfile().setBounds(416, 399, 608, 32);
            mainMenu.getNewProfileMenu().getNewProfile().setIcon(mainMenu.getNewProfileMenu().getNewProfileTextures()[0]);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfile()){
            mainMenu.getCreateProfileMenu().getCreateProfile().setBounds(1176, 410, 192, 32);
            mainMenu.getCreateProfileMenu().getCreateProfile().setIcon(mainMenu.getCreateProfileMenu().getCreateProfileTextures()[0]);
        }
    }
}
