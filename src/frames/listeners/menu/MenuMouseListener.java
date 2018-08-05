package frames.listeners.menu;

import frames.MainMenu;
import frames.panels.menu.Panel;
import sounds.menu.ClickSound;
import user.manager.User;
import user.manager.UserHandler;

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

        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfileLbl() || e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl()){
            mainMenu.switchLayout(Panel.CREATE_PROFILE);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfileLbl() && !mainMenu.getCreateProfileMenu().getEnterProfileName().getText().isEmpty() && !mainMenu.getCreateProfileMenu().getEnterProfileName().getText().trim().isEmpty() && mainMenu.getCreateProfileMenu().getEnterProfileName().getText() != null && !UserHandler.nameExists(mainMenu.getUsers(), mainMenu.getCreateProfileMenu().getEnterProfileName().getText())){
            User user = new User(mainMenu.getCreateProfileMenu().getEnterProfileName().getText().toLowerCase());
            this.mainMenu.getUsers().add(user);
            this.mainMenu.setCurrentUser(user);
            //Switch Layout
        }else if (e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl()){
            mainMenu.switchLayout(Panel.LOAD_PROFILE_LIST);
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
        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfileLbl()){
            mainMenu.getNewProfileMenu().getNewProfileLbl().setBounds(340, 399, 760, 40);
            mainMenu.getNewProfileMenu().getNewProfileLbl().setIcon(mainMenu.getNewProfileMenu().getNewProfileTextures()[1]);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfileLbl()){
            mainMenu.getCreateProfileMenu().getCreateProfileLbl().setBounds(1152, 410, 240, 40);
            mainMenu.getCreateProfileMenu().getCreateProfileLbl().setIcon(mainMenu.getCreateProfileMenu().getCreateProfileTextures()[1]);
        }else if(e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl()){
            mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setBounds(340, 299, 760, 40);
            mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setIcon(mainMenu.getProfileCreateOrSelectMenu().getNewProfileTextures()[1]);
        }else if(e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl()){
            mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setBounds(480, 499, 760, 40);
            mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setIcon(mainMenu.getProfileCreateOrSelectMenu().getLoadProfileTextures()[1]);
        }else if(e.getComponent() == mainMenu.getLoadProfileList().getLoadLabel() && mainMenu.getLoadProfileList().getLoadLabel().isVisible()){
            mainMenu.getLoadProfileList().getLoadLabel().setBounds(978, 630, 160, 40);
            mainMenu.getLoadProfileList().getLoadLabel().setIcon(mainMenu.getLoadProfileList().getLoadTextures()[1]);
        }else if(e.getComponent() == mainMenu.getLoadProfileList().getCreateLabel() && mainMenu.getLoadProfileList().getCreateLabel().isVisible()){
            mainMenu.getLoadProfileList().getCreateLabel().setBounds(898, 630, 240, 40);
            mainMenu.getLoadProfileList().getCreateLabel().setIcon(mainMenu.getLoadProfileList().getCreateTextures()[1]);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfileLbl()){
            mainMenu.getNewProfileMenu().getNewProfileLbl().setBounds(416, 399, 608, 32);
            mainMenu.getNewProfileMenu().getNewProfileLbl().setIcon(mainMenu.getNewProfileMenu().getNewProfileTextures()[0]);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfileLbl()){
            mainMenu.getCreateProfileMenu().getCreateProfileLbl().setBounds(1176, 410, 192, 32);
            mainMenu.getCreateProfileMenu().getCreateProfileLbl().setIcon(mainMenu.getCreateProfileMenu().getCreateProfileTextures()[0]);
        }else if(e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl()){
            mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setBounds(416, 299, 608, 32);
            mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setIcon(mainMenu.getProfileCreateOrSelectMenu().getNewProfileTextures()[0]);
        }else if(e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl()){
            mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setBounds(528, 499, 384, 32);
            mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setIcon(mainMenu.getProfileCreateOrSelectMenu().getLoadProfileTextures()[0]);
        }else if(e.getComponent() == mainMenu.getLoadProfileList().getLoadLabel()){
            mainMenu.getLoadProfileList().getLoadLabel().setBounds(1010, 630, 128, 32);
            mainMenu.getLoadProfileList().getLoadLabel().setIcon(mainMenu.getLoadProfileList().getLoadTextures()[0]);
        }else if(e.getComponent() == mainMenu.getLoadProfileList().getCreateLabel()){
            mainMenu.getLoadProfileList().getCreateLabel().setBounds(946, 630, 192, 32);
            mainMenu.getLoadProfileList().getCreateLabel().setIcon(mainMenu.getLoadProfileList().getCreateTextures()[0]);
        }
    }
}
