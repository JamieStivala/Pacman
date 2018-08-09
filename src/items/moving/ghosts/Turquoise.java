package items.moving.ghosts;

import astar.Node;
import items.Sprite;

import java.util.List;

public class Turquoise extends Sprite {
    private List<Node> path;
    public Turquoise(int x, int y) {
        super("turquoise.png", x, y, 32, 32);
    }

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }
}
