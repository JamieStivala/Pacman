package frames.listeners.menu;

import frames.MainMenu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

/**
 * The MenuKeyListener that will handles the inputs and outputs of the program
 */
public class MenuKeyListener implements KeyListener {
    private MainMenu mainMenu;
    private Pattern textPattern;
    private Pattern numberPattern;

    /**
     * In here a textPattern is used to check if the things entered are letters
     * Another numberPatter is used to check if the things entered are numbers
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     */
    public MenuKeyListener(MainMenu mainMenu) {
        this.textPattern = Pattern.compile("[^ a-z]", Pattern.CASE_INSENSITIVE);
        this.numberPattern = Pattern.compile("[^1-9]");
        this.mainMenu = mainMenu;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * When a key is types it checks if it is compliant with the pattern given or if it an action key or keys such as the ctrl key etc
     * @param e The KeyEvent
     */

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField()) {
            //All the keys that are used while typing and don't have a character
            boolean isTypingKey = e.getKeyChar() == 65535 || e.getKeyCode() == 8 || e.getKeyCode() == 10;
            this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().setText(this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText().toLowerCase());
            if (!isTypingKey && textPattern.matcher(e.getKeyChar() + "").find()) {
                String currentText = this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().getText();
                this.mainMenu.getCreateProfileMenu().getEnterProfileNameTextField().setText(currentText.substring(0, currentText.length() - 1));
            }
            //All the keys that are used while typing and don't have a character
        } else if (e.getSource() == this.mainMenu.getPlayGame().getSeed()) {
            boolean isTypingKey = e.getKeyChar() == 65535 || e.getKeyCode() == 8;
            if (!isTypingKey && numberPattern.matcher(e.getKeyChar() + "").find()) {
                String currentText = this.mainMenu.getPlayGame().getSeed().getText();
                this.mainMenu.getPlayGame().getSeed().setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }
}
