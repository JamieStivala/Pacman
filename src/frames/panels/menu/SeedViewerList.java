package frames.panels.menu;

import frames.MainMenu;
import sounds.menu.ClickSound;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class SeedViewerList extends BasePanel {
    private BufferedImage listOfSeeds;

    public SeedViewerList(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    @Override
    void loadComponents() {
        super.loadComponents();
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        try{
            listOfSeeds = ImageIO.read(new File("resources/menu/textures/start/seed/panel/list_of_seeds.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(listOfSeeds, 408, 299, null);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent() instanceof JLabel) new ClickSound().start();
        if(e.getComponent() == super.getBackLabel()) {
            super.getMainMenu().goBack();
            super.getMainMenu().setPreviousFrame(Panel.MAIN_PANEL);
        }

    }
}
