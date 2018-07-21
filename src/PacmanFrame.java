import javax.swing.*;
import java.awt.*;

class PacmanFrame extends Frame {
    private GridLayout gridLayout = new GridLayout(20, 400);
    //private PacmanMap map;
    PacmanFrame(){
        super("PacmanRunner");
        super.setSize(640, 480);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setVisible(true);
        super.setBackground(Color.BLACK);
        super.setLayout(gridLayout);
        /*
        map = new PacmanMap();

        boolean current[] = new boolean[0];
        for(int amountOfBlocks = 0, verticalPosition = 0, horizontalPosition = 0; amountOfBlocks != 800; amountOfBlocks++){
            if(amountOfBlocks % 40 == 0){
                current = map.getSeed(verticalPosition);
                verticalPosition++;
                horizontalPosition = 0;
            }
            if(map.getAmountFalse() > map.getAmountTrue())
                current[horizontalPosition] = !current[horizontalPosition];

            if(current[horizontalPosition]){
                Button button = new Button();
                button.setVisible(false);
                super.add(button);
            }else{
                super.add(new Button());
            }
            horizontalPosition++;
        }

        super.paint(super.getGraphics());
        */

    }
}
