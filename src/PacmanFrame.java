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

        map = new PacmanMap();

        BlockType current[] = null;

        for(int verticalPosition = 0, horizontalPosition = 40; verticalPosition != 20; horizontalPosition++) {
            if(horizontalPosition == 40){
                current = map.getSeed(verticalPosition);
                verticalPosition++;
                horizontalPosition = 0;
            }

            if(current[horizontalPosition] == BlockType.COIN || current[horizontalPosition] == BlockType.EMPTY){
                Button button = new Button();
                button.setVisible(false);
                super.add(button);
            }else{
                super.add(new Button());
            }

        }
    }
}