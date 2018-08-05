package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class MainPanel extends BasePanel {
    private JLabel startGameLabel;
    private ImageIcon startGameTextures[];

    private JLabel viewStatsLabel;
    private ImageIcon viewStatsTextures[];

    private JLabel changeProfileLabel;
    private ImageIcon changeProfileTextures[];

    private JLabel exitLabel;
    private ImageIcon exitTextures[];

    public MainPanel(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    void loadComponents() {

    }

    @Override
    void loadTextures() {
        this.startGameTextures = new ImageIcon[2];
        this.viewStatsTextures = new ImageIcon[2];
        this.changeProfileTextures = new ImageIcon[2];
        this.exitTextures = new ImageIcon[2];
        try {
            this.startGameTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/start_small.png")));
            this.startGameTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/start_big.png")));

            this.viewStatsTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/stats_small.png")));
            this.viewStatsTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/stats_big.png")));

            this.changeProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/change/change_small.png")));
            this.changeProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/change/change_big.png")));

            this.exitTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/exit/exit_small.png")));
            this.exitTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/exit/exit_big.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
