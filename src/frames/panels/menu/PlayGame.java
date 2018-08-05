package frames.panels.menu;

import frames.MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PlayGame extends BasePanel {
    private BufferedImage enterSeed;
    private BufferedImage or;

    private JLabel previousSeedLabel;
    private ImageIcon previousSeedTextures[];

    private JLabel startLabel;
    private ImageIcon startTextures[];

    private JLabel generateRandomWorldLabel;
    private ImageIcon generateRandomWorldTextures[];

    public PlayGame(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    @Override
    void loadComponents() {
        super.loadComponents();

        this.generateRandomWorldLabel = new JLabel();
        this.generateRandomWorldLabel.setIcon(generateRandomWorldTextures[0]);
        this.generateRandomWorldLabel.setBounds(50, 299, 672, 32);
        super.add(generateRandomWorldLabel);

        this.previousSeedLabel = new JLabel();
        this.previousSeedLabel.setIcon(previousSeedTextures[0]);
        this.previousSeedLabel.setBounds(50, 599, 416, 32);
        super.add(previousSeedLabel);

        this.startLabel = new JLabel();
        this.startLabel.setIcon(startTextures[0]);
        this.startLabel.setBounds(640, 700, 160, 40);
        super.add(startLabel);
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        this.previousSeedTextures = new ImageIcon[2];
        this.startTextures = new ImageIcon[2];
        this.generateRandomWorldTextures = new ImageIcon[2];
        try{
            this.previousSeedTextures[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/previous_seed_small.png")));
            this.previousSeedTextures[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/previous_seed_big.png")));

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
}
