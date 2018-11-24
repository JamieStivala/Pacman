package menu.listeners;

import shared.frames.MainMenu;
import menu.panels.Panel;
import shared.user.manager.User;
import shared.user.manager.UserHandler;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is the main MenuMouseListener that handles all the button clicks
 */
public class MenuMouseListener implements MouseListener {
    private MainMenu mainMenu;

    /**
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public MenuMouseListener(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * This handles what each button in all the different frames do
     * @param e The MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent() == this.mainMenu.getNewProfileMenu().getNewProfileLabel() || e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getNewProfileLbl() || e.getComponent() == this.mainMenu.getLoadProfileList().getCreateLabel()) {
            this.mainMenu.switchLayout(Panel.CREATE_PROFILE);
        } else if (e.getComponent() == this.mainMenu.getCreateProfileMenu().getCreateProfileLabel() && !this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().isEmpty() && !this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().trim().isEmpty() && mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText() != null && !UserHandler.nameExists(mainMenu.getUsers(), mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText())) {
            User user = new User(this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().toLowerCase());
            this.mainMenu.getUsers().add(user);
            this.mainMenu.setCurrentUser(user);
            this.mainMenu.switchLayout(Panel.MAIN_PANEL);
            this.mainMenu.getLoadProfileList().reloadComponents();
            this.mainMenu.getDeleteProfileList().reloadComponents();
            this.mainMenu.getSeedViewerList().reloadComponents();
            this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().setText(null);
        } else if (e.getComponent() == this.mainMenu.getProfileCreateOrSelectMenu().getLoadProfileLbl() || e.getComponent() == this.mainMenu.getMainPanel().getChangeProfileLabel()) {
            this.mainMenu.switchLayout(Panel.LOAD_PROFILE_LIST);
        } else if (e.getComponent() == this.mainMenu.getLoadProfileList().getLoadLabel()) {
            this.mainMenu.setCurrentUser(this.mainMenu.getUsers().get(this.mainMenu.getLoadProfileList().getProfilesList().getSelectedIndex()));
            this.mainMenu.getSeedViewerList().reloadComponents();
            this.mainMenu.switchLayout(Panel.MAIN_PANEL);
        } else if (e.getComponent() == this.mainMenu.getMainPanel().getExitLabel()) {
            UserHandler.saveUser(this.mainMenu.getUsers());
            System.exit(0);
        } else if (e.getComponent() == this.mainMenu.getMainPanel().getViewStatsLabel()) {
            this.mainMenu.switchLayout(Panel.STATS_PANEL);
        } else if (e.getComponent() == this.mainMenu.getMainPanel().getDeleteProfileLabel()) {
            this.mainMenu.switchLayout(Panel.DELETE_PROFILE_LIST);
        } else if (e.getComponent() == this.mainMenu.getMainPanel().getStartGameLabel()) {
            this.mainMenu.switchLayout(Panel.PLAY_GAME_PANEL);
        } else if (e.getComponent() == this.mainMenu.getDeleteProfileList().getDeleteLabel()) {
            int selected = this.mainMenu.getDeleteProfileList().getProfilesList().getSelectedIndex();
            User removed = this.mainMenu.getUsers().get(selected);

            this.mainMenu.getUsers().remove(selected);
            this.mainMenu.getLoadProfileList().reloadComponents();
            ((DefaultListModel) this.mainMenu.getDeleteProfileList().getProfilesList().getModel()).remove(selected);

            if (this.mainMenu.getUsers().isEmpty()) {
                this.mainMenu.setPreviousFrame(Panel.NEW_PROFILE);
            } else if (removed == this.mainMenu.getCurrentUser()) {
                this.mainMenu.setPreviousFrame(Panel.PROFILE_CREATE_SELECT);
            }
        } else if (e.getComponent() == this.mainMenu.getPlayGame().getGenerateRandomWorldLabel()) {
            this.mainMenu.startGame();
        } else if (e.getComponent() == this.mainMenu.getPlayGame().getStartLabel()) {
            if (this.mainMenu.getPlayGame().getSeed().getText() == null || this.mainMenu.getPlayGame().getSeed().getText().trim().isEmpty() || this.mainMenu.getPlayGame().getSeed().getText().isEmpty())
                this.mainMenu.startGame();
            else this.mainMenu.startGame(Long.parseLong(this.mainMenu.getPlayGame().getSeed().getText()));
        } else if (e.getComponent() == this.mainMenu.getPlayGame().getPreviousSeedsLabel()) {
            this.mainMenu.switchLayout(Panel.SEED_VIEWER_LIST);
        } else if (e.getComponent() == this.mainMenu.getSeedViewerList().getSelectLabel()) {
            if (this.mainMenu.getSeedViewerList().getSeeds().getSelectedValue() != null) {
                this.mainMenu.getPlayGame().getSeed().setText(this.mainMenu.getSeedViewerList().getSeeds().getSelectedValue() + "");
            }
            this.mainMenu.goBack();
            this.mainMenu.setPreviousFrame(Panel.MAIN_PANEL);
        } else if (e.getComponent() == this.mainMenu.getSeedViewerList().getDeleteLabel()) {
            int selected = this.mainMenu.getSeedViewerList().getSeeds().getSelectedIndex();
            this.mainMenu.getCurrentUser().getSeedsPlayed().remove(selected);
            ((DefaultListModel) this.mainMenu.getSeedViewerList().getSeeds().getModel()).remove(selected);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
