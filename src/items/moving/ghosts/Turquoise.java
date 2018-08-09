package items.moving.ghosts;

import astar.AStar;
import items.Sprite;

public class Turquoise extends Sprite {
    private AStar aStar;
    public Turquoise(int x, int y) {
        super("turquoise.png", x, y, 32, 32);
    }

    public AStar getaStar() {
        return aStar;
    }

    public void setaStar(AStar aStar) {
        this.aStar = aStar;
    }
}
