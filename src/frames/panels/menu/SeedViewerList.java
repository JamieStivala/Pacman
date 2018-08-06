package frames.panels.menu;

import frames.MainMenu;
import frames.listeners.menu.MenuListSelectionListener;
import frames.listeners.menu.MenuMouseListener;
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

    @Override
    void loadComponents() {
        super.loadComponents();
        if(super.getMainMenu().getCurrentUser() == null) return;
        DefaultListModel<Long> listModel= new DefaultListModel<>();
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
        this.deleteLabel.setIcon(deleteTexture[0]);
        this.deleteLabel.setBounds(408, 620, 192, 32);
        this.deleteLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(deleteLabel);

        this.selectLabel = new JLabel();
        this.selectLabel.setIcon(selectTexture[0]);
        this.selectLabel.setBounds(880, 620, 192, 32);
        this.selectLabel.addMouseListener(new MenuMouseListener(super.getMainMenu()));
        super.add(selectLabel);
    }

    @Override
    void loadTextures() {
        super.loadTextures();
        this.deleteTexture = new ImageIcon[2];
        this.selectTexture = new ImageIcon[2];
        try{
            listOfSeeds = ImageIO.read(new File("resources/menu/textures/start/seed/panel/list_of_seeds.png"));

            deleteTexture[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_small.png")));
            deleteTexture[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/profile/delete/delete_big.png")));

            selectTexture[0] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/panel/select_small.png")));
            selectTexture[1] = new ImageIcon(ImageIO.read(new File("resources/menu/textures/start/seed/panel/select_big.png")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(listOfSeeds, 408, 250, null);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent() instanceof JLabel) new ClickSound().start();
        if(e.getComponent() == super.getBackLabel()) {
            super.getMainMenu().goBack();
            super.getMainMenu().setPreviousFrame(Panel.MAIN_PANEL);
        }
    }

    public JList<Long> getSeeds() {
        return seeds;
    }

    public ImageIcon[] getDeleteTexture() {
        return deleteTexture;
    }

    public void setDeleteTexture(ImageIcon[] deleteTexture) {
        this.deleteTexture = deleteTexture;
    }

    public JLabel getSelectLabel() {
        return selectLabel;
    }

    public void setSelectLabel(JLabel selectLabel) {
        this.selectLabel = selectLabel;
    }

    public ImageIcon[] getSelectTexture() {
        return selectTexture;
    }

    public void setSelectTexture(ImageIcon[] selectTexture) {
        this.selectTexture = selectTexture;
    }

    public void setSeeds(JList<Long> seeds) {
        this.seeds = seeds;
    }

    public void triggerButtons(){

    }

    public void reloadComponents(){
        this.removeAll();
        this.loadComponents();
    }
}
