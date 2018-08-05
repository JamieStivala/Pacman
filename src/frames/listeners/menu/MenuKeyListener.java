package frames.listeners.menu;

import frames.MainMenu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

public class MenuKeyListener implements KeyListener {
    private MainMenu mainMenu;
    private Pattern pattern;
    public MenuKeyListener (MainMenu mainMenu){
        pattern = Pattern.compile("[^ a-z]", Pattern.CASE_INSENSITIVE);
        this.mainMenu = mainMenu;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //All the keys that are used while typing and don't have a character
        boolean isTypingKey = e.getKeyChar() == 65535 || e.getKeyCode() == 8 || e.getKeyCode() == 10;
        if(!isTypingKey && e.getSource() == mainMenu.getCreateProfileMenu().getEnterProfileName() && pattern.matcher(e.getKeyChar() + "").find()){
            String currentText = mainMenu.getCreateProfileMenu().getEnterProfileName().getText();
            mainMenu.getCreateProfileMenu().getEnterProfileName().setText(currentText.substring(0, currentText.length() - 1));
        }

    }
}
