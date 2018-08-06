package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuAnimationHandler;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainPanel extends BasePanel {
    private JLabel startGameLabel;
    private ImageIcon startGameTextures[];

    private JLabel viewStatsLabel;
    private ImageIcon viewStatsTextures[];

    private JLabel changeProfileLabel;
    private ImageIcon changeProfileTextures[];

    private JLabel deleteProfileLabel;
    private ImageIcon deleteProfileTexture[];

    private JLabel exitLabel;
    private ImageIcon exitTextures[];

    public MainPanel(MainMenu mainMenu) {
        super(mainMenu, false);
    }

    @Override
    void loadComponents() {
        super.loadComponents();
        this.startGameLabel = new JLabel();
        this.startGameLabel.setIcon(startGameTextures[0]);
        this.startGameLabel.setBounds(560, 299, 320, 32);
        this.startGameLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        this.startGameLabel.addMouseListener(new MenuAnimationHandler(this.getStartGameTextures(), this.getStartGameLabel().getBounds(), new Rectangle(520, 299, 400, 40)));
        super.add(startGameLabel);

        this.viewStatsLabel = new JLabel();
        this.viewStatsLabel.setIcon(viewStatsTextures[0]);
        this.viewStatsLabel.setBounds(560, 399, 320, 32);
        this.viewStatsLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        this.viewStatsLabel.addMouseListener(new MenuAnimationHandler(this.getViewStatsTextures(), this.getViewStatsLabel().getBounds(), new Rectangle(520,399,400,40)));
        super.add(viewStatsLabel);

        this.changeProfileLabel = new JLabel();
        this.changeProfileLabel.setIcon(changeProfileTextures[0]);
        this.changeProfileLabel.setBounds(496, 499, 448, 32);
        this.changeProfileLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        this.changeProfileLabel.addMouseListener(new MenuAnimationHandler(this.getChangeProfileTextures(), this.getChangeProfileLabel().getBounds(), new Rectangle(440,499,560,40)));
        super.add(changeProfileLabel);

        this.deleteProfileLabel = new JLabel();
        this.deleteProfileLabel.setIcon(deleteProfileTexture[0]);
        this.deleteProfileLabel.setBounds(496, 599, 448, 32);
        this.deleteProfileLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        this.deleteProfileLabel.addMouseListener(new MenuAnimationHandler(this.getDeleteProfileTexture(), this.getDeleteProfileLabel().getBounds(), new Rectangle(440,599,560,40)));
        super.add(deleteProfileLabel);

        this.exitLabel = new JLabel();
        this.exitLabel.setIcon(exitTextures[0]);
        this.exitLabel.setBounds(660, 699, 128, 32);
        this.exitLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        this.exitLabel.addMouseListener(new MenuAnimationHandler(this.getExitTextures(), this.getExitLabel().getBounds(), new Rectangle(640,699,160,40)));
        super.add(exitLabel);
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        this.startGameTextures = new ImageIcon[2];
        this.viewStatsTextures = new ImageIcon[2];
        this.changeProfileTextures = new ImageIcon[2];
        this.deleteProfileTexture = new ImageIcon[2];
        this.exitTextures = new ImageIcon[2];
        try {
            this.startGameTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/start_small.png")));
            this.startGameTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/start_big.png")));

            this.viewStatsTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/stats_small.png")));
            this.viewStatsTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/stats/stats_big.png")));

            this.changeProfileTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/change/change_small.png")));
            this.changeProfileTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/change/change_big.png")));

            this.deleteProfileTexture[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_profile_small.png")));
            this.deleteProfileTexture[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_profile_big.png")));

            this.exitTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/exit/exit_small.png")));
            this.exitTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/exit/exit_big.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JLabel getStartGameLabel() {
        return this.startGameLabel;
    }

    public ImageIcon[] getStartGameTextures() {
        return this.startGameTextures;
    }

    public JLabel getViewStatsLabel() {
        return this.viewStatsLabel;
    }

    public ImageIcon[] getViewStatsTextures() {
        return this.viewStatsTextures;
    }

    public JLabel getChangeProfileLabel() {
        return this.changeProfileLabel;
    }

    public ImageIcon[] getChangeProfileTextures() {
        return this.changeProfileTextures;
    }

    public JLabel getDeleteProfileLabel() {
        return this.deleteProfileLabel;
    }

    public ImageIcon[] getDeleteProfileTexture() {
        return this.deleteProfileTexture;
    }

    public JLabel getExitLabel() {
        return this.exitLabel;
    }

    public ImageIcon[] getExitTextures() {
        return this.exitTextures;
    }
}
