package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuAnimationHandler;
import sounds.menu.ClickSound;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * A base class for every panel
 */
abstract class BasePanel extends JPanel implements MouseListener {
    private MainMenu mainMenu;
    private Font pacFont;
    private Font pixelMiner;

    private JLabel backLabel;
    private ImageIcon backTextures[];

    private BufferedImage numbers[];
    private BufferedImage letters[];

    private boolean showBack;

    /**
     * This sets all the default things of the panel
     * This also loads all the fonts
     *
     * It also has methods such as loadTextures() and loadComponents() and paint() that are meant to be overwritten and called via super.methodName(g);
     * In these the back button and the consistent logo are loaded.
     *
     * After the loadTextures and loadComponents that are overwritten are called the frame is repainted
     *
     * @param mainMenu The object of the MainMenu which stores most of the objects regarding the MainMenu
     * @param showBack Represents whether to show the back button or not
     */
    BasePanel(MainMenu mainMenu, boolean showBack) {
        this.mainMenu = mainMenu;
        this.showBack = showBack;
        super.setBackground(new Color(240, 130, 0));
        super.setLayout(null);
        loadFonts();
        loadTextures();
        loadComponents();
        super.repaint();
    }

    /**
     * Loads the back button
     */
    void loadComponents() {
        if (showBack) {
            backLabel = new JLabel();
            backLabel.setIcon(backTextures[0]);
            backLabel.setBounds(1240, 680, 128, 32);
            backLabel.addMouseListener(this);
            backLabel.addMouseListener(new MenuAnimationHandler(this.backTextures, new Rectangle(1240, 680, 128, 32), new Rectangle(1208, 680, 160, 40)));
            super.add(backLabel);
        }
    }

    /**
     * Loads the backTextures and the numbers and letters
     */
    void loadTextures() {
        if (showBack) {
            backTextures = new ImageIcon[2];
            try {
                backTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/back/back_small.png")));
                backTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/back/back_big.png")));

                loadNumbers();
                loadLetters();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Since the numbers are colored and not as a font, they are loaded as separate images
     */
    private void loadNumbers() throws Exception {
        this.numbers = new BufferedImage[10];
        for (int i = 0; i != numbers.length; i++) {
            numbers[i] = ImageIO.read(new File("resources/menu/textures/numbers/" + i + ".png"));
        }
    }

    /**
     * Since the letters are colored and not as a font, they are loaded as separate images
     */
    private void loadLetters() throws Exception {
        this.letters = new BufferedImage[26];
        for (int i = 0; i != letters.length; i++) {
            letters[i] = ImageIO.read(new File("resources/menu/textures/letters/" + i + ".png"));
        }
    }

    /**
     * Draws the consistent logo throughout the layout
     * @param g The java.awt Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (mainMenu.getLogo() != null) g.drawImage(mainMenu.getLogo(), 208, 0, 1024, 242, null);
    }

    /**
     * Loads the PacFont and PixelMiner font
     */
    private void loadFonts() {
        try {
            this.pacFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/PacFont.ttf")).deriveFont(Font.PLAIN, 60);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pacFont);

            this.pixelMiner = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Pixel-Miners.ttf")).deriveFont(Font.PLAIN, 18);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pixelMiner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The numbers are drawn on the buffered image.
     *
     * This is done by creating a buffered image of the amount of numbers * 32 since on x and 32 in height since the numbers are 32 x 32
     * It then splits each number into characters and draws then one by one
     *
     * @param number The numbers to be drawn
     * @return The buffered image with the numbers drawn
     */
    BufferedImage drawNumber(int number) {
        BufferedImage image = new BufferedImage((((number + "").length()) * 32), 32, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        char splitNumber[] = (number + "").toCharArray();

        for (int i = 0; i != splitNumber.length; i++) {
            g.drawImage(this.numbers[splitNumber[i] - '0'], i * 32, 0, null);
        }
        return image;
    }

    /**
     * The text is draw on the buffered image
     *
     * This works very similar to drawNumber it converts the characters into numbers to prevent a bunch of if's
     * This is done by doing the
     * char - 'A' and getting a number of the letter from 0 - 25 (A - Z)
     *
     * An exception has been made for when the character is -33 which is a space
     *
     * @param text The text to be draw
     * @return The buffered image with the text drawn
     */
    BufferedImage drawText(String text) {
        BufferedImage image = new BufferedImage(text.length() * 32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        char textArray[] = text.toUpperCase().toCharArray();

        for (int i = 0; i != text.length(); i++) {
            if (textArray[i] - 'A' == -33) g.drawImage(null, i * 32, 0, null);
            else g.drawImage(this.letters[textArray[i] - 'A'], i * 32, 0, null);
        }

        return image;
    }

    /**
     * @return The main menu
     */
    MainMenu getMainMenu() {
        return this.mainMenu;
    }

    /**
     * @return The pacFont
     */
    Font getPacFont() {
        return this.pacFont;
    }

    /**
     * @return The pixelMiner font
     */
    Font getPixelMinerFont() {
        return pixelMiner;
    }

    /**
     * @return The back label
     */
    JLabel getBackLabel() {
        return backLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * This handles what happens to the back button when it is pressed
     * @param e MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent() instanceof JLabel) new ClickSound().start();
        if (e.getComponent() == this.backLabel) mainMenu.goBack();
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
