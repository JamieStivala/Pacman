package generator;

import java.awt.*;

public class PacmanMap extends Seed{
    private Button world[][] = new Button[20][40];

    public PacmanMap() {
        this((long) (Math.random() * 1000000000));
    }

    public PacmanMap(long seed) {
        super(seed);

        boolean current[] = new boolean[0];
        for(int amountOfBlocks = 0, verticalPosition = -1, horizontalPosition = 0; amountOfBlocks != 800; amountOfBlocks++){
            if(amountOfBlocks % 40 == 0){
                verticalPosition++;
                current = super.getSeed(verticalPosition);
                horizontalPosition = 0;
            }else{
                horizontalPosition++;
                if(current[horizontalPosition]){
                    Button button = new Button();
                    button.setVisible(false);
                    world[verticalPosition][horizontalPosition] = button;
                }else{
                    world[verticalPosition][horizontalPosition] = new Button();
                }
            }
        }
    }

    public void draw(Frame f) {
        for (int amountOfBlocks = 0, verticalPosition = -1, horizontalPosition = 0; amountOfBlocks != 800; amountOfBlocks++) {
            if(amountOfBlocks % 40 == 0){
                verticalPosition++;
                horizontalPosition = 0;
            }else{
                System.out.println(world[verticalPosition][horizontalPosition]);
            }
        }
    }
}
