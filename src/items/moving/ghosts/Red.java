package items.moving.ghosts;

import astar.Node;
import items.Sprite;

import java.util.List;

public class Red extends Sprite {
    private List<Node> path;
    private int changed;

    public Red(int x, int y) {
        super("red.png", x, y, 32, 32);
    }

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        changed = getChanged(path);
        this.path = path;
    }

    private int getChanged(List<Node> newNodes){
        List<Node> oldNodes = this.getPath();
        int oldFound = getChanged();
        if(oldNodes == null) return 0;

        int min = (oldNodes.size() < newNodes.size()) ? oldNodes.size() : newNodes.size();

        for (int i = 0; i != min ; i++) {
            Node oldNode = oldNodes.get(i);
            for (int x = 0; x != min ; x++) {
                if(oldNode.getRow() != newNodes.get(x).getRow() || oldNode.getCol() != newNodes.get(x).getCol()) if(x >= oldFound){
                    return x;
                }
            }
        }

        return 0;
    }

    public int getChanged() {
        return changed;
    }
}
