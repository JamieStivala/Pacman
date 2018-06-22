import generator.Seed;

import javax.swing.*;
import java.awt.*;

class PacmanFrame extends Frame {
    private GridLayout gridLayout = new GridLayout(20, 400);
    Seed seed;
    PacmanFrame(){
        super("PacmanRunner");
        super.setSize(640, 480);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setVisible(true);
        super.setBackground(Color.BLACK);
        super.setLayout(gridLayout);

        seed = new Seed();

        for(int i = 0, rowCounter = 0; i != 800; i++){
            if(i % 40 == 0) {
                rowCounter++;
                Button button = new Button("split");
                button.setBackground(Color.blue);
                super.add(button);
            }else{
                super.add(new Button(i + ""));
            }


        }
        super.paint(super.getGraphics());
    }
}
