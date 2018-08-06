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

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent() instanceof JLabel){
            new ClickSound().start();
        }

        if(e.getComponent() == this.mainMenu.getNewProfileMenu().getNewProfileLabel() || e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl() || e.getComponent() == this.mainMenu.getLoadProfileList().getCreateLabel()){
            this.mainMenu.switchLayout(Panel.CREATE_PROFILE);
        }else if(e.getComponent() == this.mainMenu.getCreateProfileMenu().getCreateProfileLabel() && !this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().isEmpty() && !this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().trim().isEmpty() && mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText() != null && !UserHandler.nameExists(mainMenu.getUsers(), mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText())){
            User user = new User(this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().toLowerCase());
            this.mainMenu.getUsers().add(user);
            this.mainMenu.setCurrentUser(user);
            this.mainMenu.switchLayout(Panel.MAIN_PANEL);
            this.mainMenu.getLoadProfileList().reloadComponents();
            this.mainMenu.getDeleteProfileList().reloadComponents();
            this.mainMenu.getSeedViewerList().reloadComponents();
            this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().setText(null);
        }else if (e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl() || e.getComponent() == this.mainMenu.getMainPanel().getChangeProfileLabel()){
            this.mainMenu.switchLayout(Panel.LOAD_PROFILE_LIST);
        }else if (e.getComponent() == this.mainMenu.getLoadProfileList().getLoadLabel()){
            this.mainMenu.setCurrentUser(this.mainMenu.getUsers().get(this.mainMenu.getLoadProfileList().getProfilesList().getSelectedIndex()));
            this.mainMenu.getSeedViewerList().reloadComponents();
            this.mainMenu.switchLayout(Panel.MAIN_PANEL);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getExitLabel()){
            UserHandler.saveUser(this.mainMenu.getUsers());
            System.exit(0);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getViewStatsLabel()){
            this.mainMenu.switchLayout(Panel.STATS_PANEL);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getDeleteProfileLabel()) {
            this.mainMenu.switchLayout(Panel.DELETE_PROFILE_LIST);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getStartGameLabel()){
            this.mainMenu.switchLayout(Panel.PLAY_GAME_PANEL);
        }else if(e.getComponent() == this.mainMenu.getDeleteProfileList().getDeleteLabel()){
            int selected = this.mainMenu.getDeleteProfileList().getProfilesList().getSelectedIndex();
            User removed = this.mainMenu.getUsers().get(selected);

            this.mainMenu.getUsers().remove(selected);
            this.mainMenu.getLoadProfileList().reloadComponents();
            ((DefaultListModel) this.mainMenu.getDeleteProfileList().getProfilesList().getModel()).remove(selected);

            if(this.mainMenu.getUsers().isEmpty()){
                this.mainMenu.setPreviousFrame(Panel.NEW_PROFILE);
            }else if(removed == this.mainMenu.getCurrentUser()){
                this.mainMenu.setPreviousFrame(Panel.PROFILE_CREATE_SELECT);
            }else{
                this.mainMenu.getDeleteProfileList().getProfilesList().setSelectedIndex(10);
            }
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getGenerateRandomWorldLabel()){
            this.mainMenu.startGame();
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getStartLabel()){
            if(this.mainMenu.getPlayGame().getSeed().getText() == null || this.mainMenu.getPlayGame().getSeed().getText().trim().isEmpty() || this.mainMenu.getPlayGame().getSeed().getText().isEmpty())  this.mainMenu.startGame();
            else this.mainMenu.startGame(Long.parseLong(this.mainMenu.getPlayGame().getSeed().getText()));
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getPreviousSeedsLabel()){
            this.mainMenu.switchLayout(Panel.SEED_VIEWER_LIST);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent() == this.mainMenu.getNewProfileMenu().getNewProfileLabel()){
            this.mainMenu.getNewProfileMenu().getNewProfileLabel().setBounds(340, 399, 760, 40);
            this.mainMenu.getNewProfileMenu().getNewProfileLabel().setIcon(this.mainMenu.getNewProfileMenu().getNewProfileTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getCreateProfileMenu().getCreateProfileLabel()){
            this.mainMenu.getCreateProfileMenu().getCreateProfileLabel().setBounds(1152, 410, 240, 40);
            this.mainMenu.getCreateProfileMenu().getCreateProfileLabel().setIcon(this.mainMenu.getCreateProfileMenu().getCreateProfileTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl()){
            this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setBounds(340, 299, 760, 40);
            this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setIcon(this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl()){
            this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setBounds(480, 499, 760, 40);
            this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setIcon(this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getLoadProfileList().getLoadLabel() && this.mainMenu.getLoadProfileList().getLoadLabel().isVisible()){
            this.mainMenu.getLoadProfileList().getLoadLabel().setBounds(978, 630, 160, 40);
            this.mainMenu.getLoadProfileList().getLoadLabel().setIcon(this.mainMenu.getLoadProfileList().getLoadTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getLoadProfileList().getCreateLabel() && this.mainMenu.getLoadProfileList().getCreateLabel().isVisible()){
            this.mainMenu.getLoadProfileList().getCreateLabel().setBounds(898, 630, 240, 40);
            this.mainMenu.getLoadProfileList().getCreateLabel().setIcon(this.mainMenu.getLoadProfileList().getCreateTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getStartGameLabel()){
            this.mainMenu.getMainPanel().getStartGameLabel().setBounds(520, 299, 400, 40);
            this.mainMenu.getMainPanel().getStartGameLabel().setIcon(this.mainMenu.getMainPanel().getStartGameTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getViewStatsLabel()){
            this.mainMenu.getMainPanel().getViewStatsLabel().setBounds(520,399,400,40);
            this.mainMenu.getMainPanel().getViewStatsLabel().setIcon(this.mainMenu.getMainPanel().getViewStatsTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getChangeProfileLabel()){
            this.mainMenu.getMainPanel().getChangeProfileLabel().setBounds(440,499,560,40);
            this.mainMenu.getMainPanel().getChangeProfileLabel().setIcon(this.mainMenu.getMainPanel().getChangeProfileTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getDeleteProfileLabel()){
            this.mainMenu.getMainPanel().getDeleteProfileLabel().setBounds(440,599,560,40);
            this.mainMenu.getMainPanel().getDeleteProfileLabel().setIcon(this.mainMenu.getMainPanel().getDeleteProfileTexture()[1]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getExitLabel()){
            this.mainMenu.getMainPanel().getExitLabel().setBounds(640,699,160,40);
            this.mainMenu.getMainPanel().getExitLabel().setIcon(this.mainMenu.getMainPanel().getExitTextures()[1]);
        }else if(e.getComponent() == this.mainMenu.getDeleteProfileList().getDeleteLabel()){
            this.mainMenu.getDeleteProfileList().getDeleteLabel().setIcon(this.mainMenu.getDeleteProfileList().getDeleteTextures()[1]);
            this.mainMenu.getDeleteProfileList().getDeleteLabel().setBounds(898, 630, 240, 40);
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getGenerateRandomWorldLabel()){
            this.mainMenu.getPlayGame().getGenerateRandomWorldLabel().setIcon(this.mainMenu.getPlayGame().getGenerateRandomWorldTextures()[1]);
            this.mainMenu.getPlayGame().getGenerateRandomWorldLabel().setBounds(50, 299, 840, 40);
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getPreviousSeedsLabel()){
            this.mainMenu.getPlayGame().getPreviousSeedsLabel().setIcon(this.mainMenu.getPlayGame().getPreviousSeedsTextures()[1]);
            this.mainMenu.getPlayGame().getPreviousSeedsLabel().setBounds(50, 599, 560, 40);
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getStartLabel()){
            this.mainMenu.getPlayGame().getStartLabel().setIcon(this.mainMenu.getPlayGame().getStartTextures()[1]);
            this.mainMenu.getPlayGame().getStartLabel().setBounds(520, 700, 400, 40);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent() == this.mainMenu.getNewProfileMenu().getNewProfileLabel()){
            this.mainMenu.getNewProfileMenu().getNewProfileLabel().setBounds(416, 399, 608, 32);
            this.mainMenu.getNewProfileMenu().getNewProfileLabel().setIcon(this.mainMenu.getNewProfileMenu().getNewProfileTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getCreateProfileMenu().getCreateProfileLabel()){
            this.mainMenu.getCreateProfileMenu().getCreateProfileLabel().setBounds(1176, 410, 192, 32);
            this.mainMenu.getCreateProfileMenu().getCreateProfileLabel().setIcon(this.mainMenu.getCreateProfileMenu().getCreateProfileTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl()){
            this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setBounds(416, 299, 608, 32);
            this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl().setIcon(this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl()){
            this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setBounds(528, 499, 384, 32);
            this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl().setIcon(this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getLoadProfileList().getLoadLabel()){
            this.mainMenu.getLoadProfileList().getLoadLabel().setBounds(1010, 630, 128, 32);
            this.mainMenu.getLoadProfileList().getLoadLabel().setIcon(this.mainMenu.getLoadProfileList().getLoadTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getLoadProfileList().getCreateLabel()){
            this.mainMenu.getLoadProfileList().getCreateLabel().setBounds(946, 630, 192, 32);
            this.mainMenu.getLoadProfileList().getCreateLabel().setIcon(this.mainMenu.getLoadProfileList().getCreateTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getStartGameLabel()){
            this.mainMenu.getMainPanel().getStartGameLabel().setBounds(560, 299, 320, 32);
            this.mainMenu.getMainPanel().getStartGameLabel().setIcon(this.mainMenu.getMainPanel().getStartGameTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getViewStatsLabel()){
            this.mainMenu.getMainPanel().getViewStatsLabel().setBounds(560,399,320,32);
            this.mainMenu.getMainPanel().getViewStatsLabel().setIcon(this.mainMenu.getMainPanel().getViewStatsTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getChangeProfileLabel()){
            this.mainMenu.getMainPanel().getChangeProfileLabel().setBounds(496,499,448,32);
            this.mainMenu.getMainPanel().getChangeProfileLabel().setIcon(this.mainMenu.getMainPanel().getChangeProfileTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getDeleteProfileLabel()){
            this.mainMenu.getMainPanel().getDeleteProfileLabel().setBounds(496,599,448,32);
            this.mainMenu.getMainPanel().getDeleteProfileLabel().setIcon(this.mainMenu.getMainPanel().getDeleteProfileTexture()[0]);
        }else if(e.getComponent() == this.mainMenu.getMainPanel().getExitLabel()){
            this.mainMenu.getMainPanel().getExitLabel().setBounds(660,699,128,32);
            this.mainMenu.getMainPanel().getExitLabel().setIcon(this.mainMenu.getMainPanel().getExitTextures()[0]);
        }else if(e.getComponent() == this.mainMenu.getDeleteProfileList().getDeleteLabel()){
            this.mainMenu.getDeleteProfileList().getDeleteLabel().setIcon(this.mainMenu.getDeleteProfileList().getDeleteTextures()[0]);
            this.mainMenu.getDeleteProfileList().getDeleteLabel().setBounds(946, 630, 192, 32);
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getGenerateRandomWorldLabel()){
            this.mainMenu.getPlayGame().getGenerateRandomWorldLabel().setIcon(this.mainMenu.getPlayGame().getGenerateRandomWorldTextures()[0]);
            this.mainMenu.getPlayGame().getGenerateRandomWorldLabel().setBounds(50, 299, 672, 32);
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getPreviousSeedsLabel()){
            this.mainMenu.getPlayGame().getPreviousSeedsLabel().setIcon(this.mainMenu.getPlayGame().getPreviousSeedsTextures()[0]);
            this.mainMenu.getPlayGame().getPreviousSeedsLabel().setBounds(50, 599, 416, 32);
        }else if(e.getComponent() == this.mainMenu.getPlayGame().getStartLabel()){
            this.mainMenu.getPlayGame().getStartLabel().setIcon(this.mainMenu.getPlayGame().getStartTextures()[0]);
            this.mainMenu.getPlayGame().getStartLabel().setBounds(560, 700, 320, 32);
        }
    }
}
