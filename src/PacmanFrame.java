import listener.PacmanKeyListener;
import listener.PacmanWindowListener;
import map.PacmanMap;

import javax.swing.*;
import java.awt.*;

class PacmanFrame extends JFrame{
    private GridLayout gridLayout = new GridLayout(20, 40);
    private PacmanMap map;

    PacmanFrame(){
        map = new PacmanMap(937870171);

        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(true);
        super.addWindowListener(new PacmanWindowListener());
        super.addKeyListener(new PacmanKeyListener());
        super.getContentPane().setBackground(Color.BLACK);
        super.setLayout(null);
        super.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        map.paint(g);
    }

}