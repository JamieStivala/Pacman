import generator.BlockType;
import generator.PacmanMap;
import generator.Seed;
import listener.PacmanWindowListener;

import javax.swing.*;
import java.awt.*;

class PacmanFrame extends JFrame{
    private GridLayout gridLayout = new GridLayout(20, 40);
    private Seed map;

    PacmanFrame(){
        super.setTitle("Pacman");
        super.setSize(640, 480);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.addWindowListener(new PacmanWindowListener());
        super.getContentPane().setBackground(Color.BLACK);
        super.setLayout(gridLayout);
        super.setVisible(true);

        map = new PacmanMap(937870171);


        for(int vertical = 0; vertical != map.getSeed().length; vertical++){
            BlockType current[] = map.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++){
                if(current[horizontal] == BlockType.WALL){
                    super.add(new JButton());
                }else{
                    JButton button = new JButton();
                    button.setVisible(false);
                    super.add(button);
                }
            }

        }
    }
}