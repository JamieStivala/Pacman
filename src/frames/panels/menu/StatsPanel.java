package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class StatsPanel extends BasePanel {
    private BufferedImage profileName;
    private BufferedImage highestScore;
    private BufferedImage gamesPlayed;
    private BufferedImage totalScore;
    private BufferedImage lastPlayedScore;

    private BufferedImage numbers[];
    private BufferedImage letters[];

    public StatsPanel(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        try{
            this.profileName = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/name.png"));
            this.highestScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/highest_score.png"));
            this.gamesPlayed = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/games_played.png"));
            this.totalScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/total_score.png"));
            this.lastPlayedScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/last_played_score.png"));

            this.loadNumbers();
            this.loadLetters();
        }catch (Exception ex){
            ex.printStackTrace();
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
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.profileName, 50, 300, null);
        g.drawImage(drawText(super.getMainMenu().getCurrentUser().getCharacterName()), 626, 300, null);

        g.drawImage(this.highestScore, 50, 380, null);
        g.drawImage(drawNumber(super.getMainMenu().getCurrentUser().getHighestScore()), 626, 380, null);

        g.drawImage(this.gamesPlayed, 50, 460, null);
        g.drawImage(drawNumber(super.getMainMenu().getCurrentUser().getTotalGamesPlayed()), 626, 460, null);

        g.drawImage(this.totalScore, 50, 540, null);
        g.drawImage(drawNumber(super.getMainMenu().getCurrentUser().getTotalScore()), 626, 540, null);

        g.drawImage(this.lastPlayedScore, 50, 620, null);
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
            if(textArray[i] - 'A' == -33) g.drawImage(null, i * 32, 0, null);
            else g.drawImage(this.letters[textArray[i] - 'A'], i * 32, 0, null);
        }

        return image;
    }
}
