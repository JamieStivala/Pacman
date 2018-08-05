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

        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfileLabel() || e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl() || e.getComponent() == mainMenu.getLoadProfileList().getCreateLabel()){
            mainMenu.switchLayout(Panel.CREATE_PROFILE);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfileLabel() && !mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().isEmpty() && !mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().trim().isEmpty() && mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText() != null && !UserHandler.nameExists(mainMenu.getUsers(), mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText())){
            User user = new User(mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().toLowerCase());
            this.mainMenu.getUsers().add(user);
            this.mainMenu.setCurrentUser(user);
            this.mainMenu.switchLayout(Panel.MAIN_PANEL);
        }else if (e.getComponent() == mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl() || e.getComponent() == mainMenu.getMainPanel().getChangeProfileLabel()){
            mainMenu.switchLayout(Panel.LOAD_PROFILE_LIST);
        }else if (e.getComponent() == mainMenu.getLoadProfileList().getLoadLabel()){
            mainMenu.setCurrentUser(mainMenu.getUsers().get(mainMenu.getLoadProfileList().getProfilesList().getSelectedIndex()));
            this.mainMenu.switchLayout(Panel.MAIN_PANEL);
        }else if(e.getComponent() == mainMenu.getMainPanel().getExitLabel()){
            UserHandler.saveUser(mainMenu.getUsers());
            System.exit(0);
        }else if(e.getComponent() == mainMenu.getMainPanel().getViewStatsLabel()){
            mainMenu.switchLayout(Panel.STATS_PANEL);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfileLabel()){
            mainMenu.getNewProfileMenu().getNewProfileLabel().setBounds(340, 399, 760, 40);
            mainMenu.getNewProfileMenu().getNewProfileLabel().setIcon(mainMenu.getNewProfileMenu().getNewProfileTextures()[1]);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfileLabel()){
            mainMenu.getCreateProfileMenu().getCreateProfileLabel().setBounds(1152, 410, 240, 40);
            mainMenu.getCreateProfileMenu().getCreateProfileLabel().setIcon(mainMenu.getCreateProfileMenu().getCreateProfileTextures()[1]);
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
        }else if(e.getComponent() == mainMenu.getMainPanel().getStartGameLabel()){
            mainMenu.getMainPanel().getStartGameLabel().setBounds(520, 299, 400, 40);
            mainMenu.getMainPanel().getStartGameLabel().setIcon(mainMenu.getMainPanel().getStartGameTextures()[1]);
        }else if(e.getComponent() == mainMenu.getMainPanel().getViewStatsLabel()){
            mainMenu.getMainPanel().getViewStatsLabel().setBounds(520,399,400,40);
            mainMenu.getMainPanel().getViewStatsLabel().setIcon(mainMenu.getMainPanel().getViewStatsTextures()[1]);
        }else if(e.getComponent() == mainMenu.getMainPanel().getChangeProfileLabel()){
            mainMenu.getMainPanel().getChangeProfileLabel().setBounds(440,499,560,40);
            mainMenu.getMainPanel().getChangeProfileLabel().setIcon(mainMenu.getMainPanel().getChangeProfileTextures()[1]);
        }else if(e.getComponent() == mainMenu.getMainPanel().getExitLabel()){
            mainMenu.getMainPanel().getExitLabel().setBounds(640,599,160,40);
            mainMenu.getMainPanel().getExitLabel().setIcon(mainMenu.getMainPanel().getExitTextures()[1]);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent() == mainMenu.getNewProfileMenu().getNewProfileLabel()){
            mainMenu.getNewProfileMenu().getNewProfileLabel().setBounds(416, 399, 608, 32);
            mainMenu.getNewProfileMenu().getNewProfileLabel().setIcon(mainMenu.getNewProfileMenu().getNewProfileTextures()[0]);
        }else if(e.getComponent() == mainMenu.getCreateProfileMenu().getCreateProfileLabel()){
            mainMenu.getCreateProfileMenu().getCreateProfileLabel().setBounds(1176, 410, 192, 32);
            mainMenu.getCreateProfileMenu().getCreateProfileLabel().setIcon(mainMenu.getCreateProfileMenu().getCreateProfileTextures()[0]);
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
        }else if(e.getComponent() == mainMenu.getMainPanel().getStartGameLabel()){
            mainMenu.getMainPanel().getStartGameLabel().setBounds(560, 299, 320, 32);
            mainMenu.getMainPanel().getStartGameLabel().setIcon(mainMenu.getMainPanel().getStartGameTextures()[0]);
        }else if(e.getComponent() == mainMenu.getMainPanel().getViewStatsLabel()){
            mainMenu.getMainPanel().getViewStatsLabel().setBounds(560,399,320,32);
            mainMenu.getMainPanel().getViewStatsLabel().setIcon(mainMenu.getMainPanel().getViewStatsTextures()[0]);
        }else if(e.getComponent() == mainMenu.getMainPanel().getChangeProfileLabel()){
            mainMenu.getMainPanel().getChangeProfileLabel().setBounds(496,499,448,32);
            mainMenu.getMainPanel().getChangeProfileLabel().setIcon(mainMenu.getMainPanel().getChangeProfileTextures()[0]);
        }else if(e.getComponent() == mainMenu.getMainPanel().getExitLabel()){
            mainMenu.getMainPanel().getExitLabel().setBounds(660,599,128,32);
            mainMenu.getMainPanel().getExitLabel().setIcon(mainMenu.getMainPanel().getExitTextures()[0]);
        }
    }
}
