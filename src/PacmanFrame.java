import generator.Seed;

import javax.swing.*;
import java.awt.*;

class PacmanFrame extends Frame {
    private GridLayout gridLayout = new GridLayout(20, 400);
    private Seed seed;
    PacmanFrame(){
        super("PacmanRunner");
        super.setSize(640, 480);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setVisible(true);
        super.setBackground(Color.BLACK);
        super.setLayout(gridLayout);

        seed = new Seed(732989719);

        boolean current[] = new boolean[0];
        for(int amountOfBlocks = 0, verticalPosition = -1, horizontalPosition = 0; amountOfBlocks != 800; amountOfBlocks++){
            if(amountOfBlocks % 40 == 0){
                verticalPosition++;
                current = seed.getSeed(verticalPosition);
                horizontalPosition = 0;
            }else{
                horizontalPosition++;
                if(current[horizontalPosition]){
                    Button button = new Button();
                    button.setVisible(false);
                    super.add(button);
                }else{
                    super.add(new Button());
                }
            }
        }

        super.paint(super.getGraphics());

    }
}
