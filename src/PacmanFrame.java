import items.moving.Pacman;
import listener.PacmanKeyListener;
import listener.PacmanWindowListener;
import map.PacmanMap;

import javax.swing.*;
import java.awt.*;

public class PacmanFrame extends JFrame{
    private GridLayout gridLayout = new GridLayout(20, 40);
    private PacmanMap map;
    private Pacman pacman;

    PacmanFrame(){
        map = new PacmanMap(937870171);
        pacman = new Pacman(2, 24);
        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(true);
        super.addWindowListener(new PacmanWindowListener());
        super.addKeyListener(new PacmanKeyListener(pacman, this));
        super.setBackground(new Color(5, 19, 28));
        super.setLayout(null);
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        map.paint(g);
        pacman.paint(g);
    }

    @Override
    public void update(Graphics g){
        paint(g);
    }
}