package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
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

    public StatsPanel(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {

    }

    @Override
    void loadTextures() {
        backTextures = new ImageIcon[2];
        try{
            profileName = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/name.png"));
            highestScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/highest_score.png"));
            gamesPlayed = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/games_played.png"));
            totalScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/total_score.png"));
            lastPlayedScore = ImageIO.read(new File("resources/menu/textures/profile/stats/panel/last_played_score.png"));

            backTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/panel/back_small.png")));
            backTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/panel/back_big.png")));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
