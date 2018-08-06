package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuKeyListener;
import frames.listeners.menu.MenuMouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PlayGame extends BasePanel {
    private BufferedImage enterSeed;
    private BufferedImage or;

    private JLabel previousSeedsLabel;
    private ImageIcon previousSeedsTextures[];

    private JLabel startLabel;
    private ImageIcon startTextures[];

    private JLabel generateRandomWorldLabel;
    private ImageIcon generateRandomWorldTextures[];

    private JTextField seed;

    public PlayGame(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    @Override
    void loadComponents() {
        super.loadComponents();

        this.generateRandomWorldLabel = new JLabel();
        this.generateRandomWorldLabel.setIcon(generateRandomWorldTextures[0]);
        this.generateRandomWorldLabel.setBounds(50, 299, 672, 32);
        this.generateRandomWorldLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(generateRandomWorldLabel);

        this.previousSeedsLabel = new JLabel();
        this.previousSeedsLabel.setIcon(previousSeedsTextures[0]);
        this.previousSeedsLabel.setBounds(50, 599, 416, 32);
        this.previousSeedsLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(previousSeedsLabel);

        this.startLabel = new JLabel();
        this.startLabel.setIcon(startTextures[0]);
        this.startLabel.setBounds(560, 700, 320, 32);
        this.startLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(startLabel);

        this.seed = new JTextField();
        this.seed.setBounds(422, 449, 900, 32);
        this.seed.setBackground(new Color(240, 130, 0));
        this.seed.setFont(super.getPixelMinerFont());
        this.seed.setForeground(new Color(240, 240, 200));
        this.seed.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 200), 1));
        this.seed.addKeyListener(new MenuKeyListener(super.getMainMenu()));
        super.add(seed);

    }

    @Override
    void loadTextures() {
        super.loadTextures();
        this.previousSeedsTextures = new ImageIcon[2];
        this.startTextures = new ImageIcon[2];
        this.generateRandomWorldTextures = new ImageIcon[2];
        try{
            this.previousSeedsTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/previous_seeds_small.png")));
            this.previousSeedsTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/previous_seeds_big.png")));

            this.generateRandomWorldTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/generate_random_world_small.png")));
            this.generateRandomWorldTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/generate_random_world_big.png")));

            this.startTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/start_small.png")));
            this.startTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/start_big.png")));

            this.enterSeed = ImageIO.read(new File("resources/menu/textures/start/seed/enter_seed.png"));
            this.or = ImageIO.read(new File("resources/menu/textures/start/seed/or.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(or, 50, 362, null);
        g.drawImage(enterSeed, 50, 449, null);
        g.drawImage(or, 50, 517, null);
    }

    public JLabel getPreviousSeedsLabel() {
        return previousSeedsLabel;
    }

    public ImageIcon[] getPreviousSeedsTextures() {
        return previousSeedsTextures;
    }

    public JLabel getStartLabel() {
        return startLabel;
    }

    public ImageIcon[] getStartTextures() {
        return startTextures;
    }

    public JLabel getGenerateRandomWorldLabel() {
        return generateRandomWorldLabel;
    }

    public ImageIcon[] getGenerateRandomWorldTextures() {
        return generateRandomWorldTextures;
    }

    public JTextField getSeed() {
        return seed;
    }
}
