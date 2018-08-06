package frames.panels.menu;

import frames.MainMenu;
import sounds.menu.ClickSound;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

abstract class BasePanel extends JPanel implements MouseListener {
    private MainMenu mainMenu;
    private Font pacFont;
    private Font pixelMiner;

    private JLabel backLabel;
    private ImageIcon backTextures[];

    private BufferedImage numbers[];
    private BufferedImage letters[];

    private boolean showBack;

    BasePanel(MainMenu mainMenu, boolean showBack){
        this.mainMenu = mainMenu;
        this.showBack = showBack;
        super.setBackground(new Color(240, 130, 0));
        super.setLayout(null);
        loadFont();
        loadTextures();
        loadComponents();
        super.repaint();
    }

    void loadComponents(){
        if(showBack){
            backLabel = new JLabel();
            backLabel.setIcon(backTextures[0]);
            backLabel.setBounds(1240, 680, 128, 32);
            backLabel.addMouseListener(this);
            super.add(backLabel);
        }
    }

    void loadTextures(){
        if(showBack){
            backTextures = new ImageIcon[2];
            try {
                backTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/back/back_small.png")));
                backTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/back/back_big.png")));

                loadNumbers();
                loadLetters();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void loadNumbers() throws Exception{
        this.numbers = new BufferedImage[10];
        for (int i = 0; i != numbers.length ; i++) {
            numbers[i] = ImageIO.read(new File("resources/menu/textures/numbers/" + i + ".png"));
        }
    }
    private void loadLetters() throws Exception{
        this.letters = new BufferedImage[26];
        for (int i = 0; i != letters.length ; i++) {
            letters[i] = ImageIO.read(new File("resources/menu/textures/letters/" + i + ".png"));
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (mainMenu.getLogo() != null) g.drawImage(mainMenu.getLogo(), 208, 0, 1024, 242, null);
    }

    private void loadFont(){
        try {
            this.pacFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/PacFont.ttf")).deriveFont(Font.PLAIN, 60);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pacFont);

            this.pixelMiner = Font.createFont(Font.TRUETYPE_FONT, new File("resources/Pixel-Miners.ttf")).deriveFont(Font.PLAIN, 18);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pixelMiner);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    BufferedImage drawNumber(int number){
        BufferedImage image = new BufferedImage((((number + "").length()) * 32), 30, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        char splitNumber[] = (number + "").toCharArray();

        for(int i = 0; i != splitNumber.length; i++){
            g.drawImage(this.numbers[splitNumber[i] - '0'], i * 32, 0, null);
        }
        return image;
    }

    BufferedImage drawText(String text){
        BufferedImage image = new BufferedImage(text.length() * 32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        char textArray[] = text.toUpperCase().toCharArray();

        for(int i = 0; i != text.length(); i++){
            if(textArray[i] - 'A' == -33) g.drawImage(null, i * 32, 0, null);
            else g.drawImage(this.letters[textArray[i] - 'A'], i * 32, 0, null);
        }

        return image;
    }

    MainMenu getMainMenu() {
        return this.mainMenu;
    }

    Font getPacFont() {
        return this.pacFont;
    }

    public Font getPixelMinerFont() {
        return pixelMiner;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent() instanceof JLabel) new ClickSound().start();
        if(e.getComponent() == this.backLabel) mainMenu.goBack();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent() == this.backLabel){
            this.backLabel.setIcon(this.backTextures[1]);
            this.backLabel.setBounds(1208, 680,160, 40);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent() == this.backLabel){
            this.backLabel.setIcon(this.backTextures[0]);
            backLabel.setBounds(1240, 680, 128, 32);
        }
    }
}
