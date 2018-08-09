package items.moving.ghosts;

import astar.AStar;
import items.Sprite;

public class Red extends Sprite {
    private AStar aStar;
    public Red(int x, int y) {
        super("red.png", x, y, 32, 32);
    }

    public AStar getAStar() {
        return aStar;
    }

    public void setAStar(AStar aStar) {
        this.aStar = aStar;
    }
}
