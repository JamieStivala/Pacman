package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuAnimationHandler;
import frames.listeners.menu.MenuListSelectionListener;
import frames.panels.menu.custom.SelectedListCellRenderer;
import sounds.menu.ClickSound;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class SeedViewerList extends BasePanel {
    private BufferedImage listOfSeeds;

    private JLabel deleteLabel;
    private ImageIcon deleteTexture[];

    private JLabel selectLabel;
    private ImageIcon selectTexture[];

    private JList<Long> seeds;

    public SeedViewerList(MainMenu mainMenu) {
        super(mainMenu, true);
    }

    /**
     * This loads all the JLabel and components needed for the frame to work
     */
    @Override
    void loadComponents() {
        super.loadComponents();
        if (super.getMainMenu().getCurrentUser() == null) return;
        DefaultListModel<Long> listModel = new DefaultListModel<>();
        for (int i = 0; i != super.getMainMenu().getCurrentUser().getSeedsPlayed().size(); i++) {
            listModel.add(i, super.getMainMenu().getCurrentUser().getSeedsPlayed().get(i));
        }

        this.seeds = new JList<>(listModel);
        this.seeds.setBounds(312, 310, 672, 300);
        this.seeds.setBackground(new Color(240, 130, 0));
        this.seeds.setFont(new Font("Pixel Miners", Font.PLAIN, 70));
        this.seeds.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        this.seeds.setCellRenderer(new SelectedListCellRenderer());
        this.seeds.addListSelectionListener(new MenuListSelectionListener(super.getMainMenu()));

        JScrollPane scrollPane = new JScrollPane(seeds);
        scrollPane.setBounds(312, 310, 826, 300);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(2, 0));
        scrollPane.getViewport().setBorder(null);
        scrollPane.setViewportBorder(null);
        super.add(scrollPane);

        this.deleteLabel = new JLabel();
        this.deleteLabel.setVisible(false);
        this.deleteLabel.setIcon(deleteTexture[0]);
        this.deleteLabel.setBounds(408, 620, 192, 32);
        this.deleteLabel.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        this.deleteLabel.addMouseListener(new MenuAnimationHandler(this.getDeleteTexture(), this.getDeleteLabel().getBounds(), new Rectangle(408, 620, 240, 40)));
        super.add(deleteLabel);

        this.selectLabel = new JLabel();
        this.selectLabel.setVisible(false);
        this.selectLabel.setIcon(selectTexture[0]);
        this.selectLabel.setBounds(880, 620, 192, 32);
        this.selectLabel.addMouseListener(super.getMainMenu().getSharedMenuMouseListener());
        this.selectLabel.addMouseListener(new MenuAnimationHandler(this.getSelectTexture(), this.getSelectLabel().getBounds(), new Rectangle(880, 620, 240, 40)));
        super.add(selectLabel);
    }

    /**
     * This loads all the textures for the JLabel
     */
    @Override
    void loadTextures() {
        super.loadTextures();
        this.deleteTexture = new ImageIcon[2];
        this.selectTexture = new ImageIcon[2];
        try {
            listOfSeeds = ImageIO.read(new File("resources/menu/textures/start/seed/panel/list_of_seeds.png"));

            deleteTexture[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_small.png")));
            deleteTexture[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_big.png")));

            selectTexture[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/panel/select_small.png")));
            selectTexture[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/panel/select_big.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Paints the list of seeds text
     * @param g The java.awt Graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(listOfSeeds, 408, 250, null);
    }

    /**
     * This is used so that the back button doesn't take you back to the new panel and then there would be no way of accessing the main menu
     * @param e MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent() instanceof JLabel) new ClickSound().start();
        if (e.getComponent() == super.getBackLabel()) {
            super.getMainMenu().goBack();
            super.getMainMenu().setPreviousFrame(Panel.MAIN_PANEL);
        }
    }

    public JList<Long> getSeeds() {
        return seeds;
    }

    public JLabel getDeleteLabel() {
        return deleteLabel;
    }

    public ImageIcon[] getDeleteTexture() {
        return deleteTexture;
    }

    public JLabel getSelectLabel() {
        return selectLabel;
    }

    public ImageIcon[] getSelectTexture() {
        return selectTexture;
    }

    /*
    Shows the back and select buttons
     */
    public void triggerButtons() {
        this.deleteLabel.setVisible(true);
        this.selectLabel.setVisible(true);
    }

    /**
     * Reloads the components for when things change during runtime
     */
    public void reloadComponents() {
        this.removeAll();
        this.loadComponents();
    }
}
