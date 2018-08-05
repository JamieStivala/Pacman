package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class StatsPanel extends BasePanel {
    private BufferedImage profileName;
    private BufferedImage highestScore;
    private BufferedImage gamesPlayed;
    private BufferedImage totalScore;
    private BufferedImage lastPlayedScore;

    private JLabel backLabel;
    private ImageIcon backTextures[];

    private BufferedImage numbers[];
    private BufferedImage letters[];

    public StatsPanel(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    @Override
    void loadComponents() {
        super.loadComponents();
        backLabel = new JLabel();
        backLabel.setIcon(backTextures[0]);
        backLabel.setBounds(1240, 680, 128, 32);
        backLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(backLabel);
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        backTextures = new ImageIcon[2];
        try{
            profileName = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/name.png"));
            highestScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/highest_score.png"));
            gamesPlayed = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/games_played.png"));
            totalScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/total_score.png"));
            lastPlayedScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/last_played_score.png"));

            backTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/panel/back_small.png")));
            backTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/panel/back_big.png")));

            loadNumbers();
            loadLetters();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void loadNumbers() throws Exception{
        numbers = new BufferedImage[10];
        for (int i = 0; i != numbers.length ; i++) {
            numbers[i] = ImageIO.read(new File("resources/menu/textures/numbers/" + i + ".png"));
        }
    }
    private void loadLetters() throws Exception{
        letters = new BufferedImage[26];
        for (int i = 0; i != letters.length ; i++) {
            letters[i] = ImageIO.read(new File("resources/menu/textures/letters/" + i + ".png"));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(profileName, 50, 300, null);
        g.drawImage(drawText(super.getMainMenu().getCurrentUser().getCharacterName()), 626, 300, null);

        g.drawImage(highestScore, 50, 380, null);
        g.drawImage(drawNumber(super.getMainMenu().getCurrentUser().getHighestScore()), 626, 380, null);

        g.drawImage(gamesPlayed, 50, 460, null);
        g.drawImage(drawNumber(super.getMainMenu().getCurrentUser().getTotalGamesPlayed()), 626, 460, null);

        g.drawImage(totalScore, 50, 540, null);
        g.drawImage(drawNumber(super.getMainMenu().getCurrentUser().getTotalScore()), 626, 540, null);

        g.drawImage(lastPlayedScore, 50, 620, null);
        g.drawImage(drawNumber(super.getMainMenu().getCurrentUser().getLastGameScore()), 626, 620, null);
    }

    private BufferedImage drawNumber(int number){
        BufferedImage image = new BufferedImage((((number + "").length()) * 32), 32, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        char splitNumber[] = (number + "").toCharArray();

        for(int i = 0; i != splitNumber.length; i++){
            g.drawImage(this.numbers[splitNumber[i] - '0'], i * 32, 0, null);
        }
        return image;
    }

    private BufferedImage drawText(String text){
        BufferedImage image = new BufferedImage(text.length() * 32, 32, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        char textArray[] = text.toUpperCase().toCharArray();

        for(int i = 0; i != text.length(); i++){
            g.drawImage(this.letters[textArray[i] - 'A'], i * 32, 0, null);
        }

        return image;
    }

    public JLabel getBackLabel() {
        return backLabel;
    }

    public ImageIcon[] getBackTextures() {
        return backTextures;
    }
}
