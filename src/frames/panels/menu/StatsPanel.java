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
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.profileName, 50, 300, null);
        g.drawImage(super.drawText(super.getMainMenu().getCurrentUser().getCharacterName()), 626, 300, null);

        g.drawImage(this.highestScore, 50, 380, null);
        g.drawImage(super.drawNumber(super.getMainMenu().getCurrentUser().getHighestScore()), 626, 380, null);

        g.drawImage(this.gamesPlayed, 50, 460, null);
        g.drawImage(super.drawNumber(super.getMainMenu().getCurrentUser().getTotalGamesPlayed()), 626, 460, null);

        g.drawImage(this.totalScore, 50, 540, null);
        g.drawImage(super.drawNumber(super.getMainMenu().getCurrentUser().getTotalScore()), 626, 540, null);

        g.drawImage(this.lastPlayedScore, 50, 620, null);
        g.drawImage(super.drawNumber(super.getMainMenu().getCurrentUser().getLastGameScore()), 626, 620, null);
    }
}
