package items.moving.ghosts;

import astar.AStar;
import items.Sprite;

public class Yellow extends Sprite {
    private AStar aStar;
    public Yellow(int x, int y) {
        super("yellow.png", x, y, 32, 32);
    }

    public AStar getAStar() {
        return aStar;
    }

    public void setAStar(AStar aStar) {
        this.aStar = aStar;
    }
}
