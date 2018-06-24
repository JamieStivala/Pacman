import generator.BinaryOperations;
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

        seed = new Seed();

        boolean current[] = new boolean[0];
        for(int i = 0, rowCounter = -1, resetRow = 0; i != 800; i++){
            if(i % 40 == 0) {
                rowCounter++;
                current = seed.getSeed(rowCounter);
                resetRow = 0;
            }else{
                resetRow++;
                if(current[resetRow]){
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
