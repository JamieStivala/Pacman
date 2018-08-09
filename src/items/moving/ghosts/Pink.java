package items.moving.ghosts;

import astar.AStar;
import items.Sprite;

public class Pink extends Sprite {
    private AStar aStar;
    public Pink(int x, int y) {
        super("pink.png", x, y, 32, 32);
    }

    public AStar getaStar() {
        return aStar;
    }

    public void setaStar(AStar aStar) {
        this.aStar = aStar;
    }
}
