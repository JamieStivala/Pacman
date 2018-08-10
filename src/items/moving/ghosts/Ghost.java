package items.moving.ghosts;

import astar.Node;
import items.Sprite;

import java.util.List;

public abstract class Ghost extends Sprite {
    private List<Node> path;
    private int changed;

    public Ghost(String filename, int x, int y, int width, int height) {
        super(filename, x, y, width, height);
    }

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        changed = setChanged(path);
        this.path = path;
    }

    private int setChanged(List<Node> newNodes){
        List<Node> oldNodes = this.getPath();
        if(oldNodes == null) return 0;

        int min = (oldNodes.size() < newNodes.size()) ? oldNodes.size() : newNodes.size();

        for (int i = 0; i != min ; i++) {
            Node oldNode = oldNodes.get(i);
            for (int x = 0; x != min ; x++) {
                if(oldNode.getRow() == newNodes.get(x).getRow() + 1 || oldNode.getRow() == newNodes.get(x).getRow() -1 || oldNode.getCol() == newNodes.get(x).getCol() + 1 || oldNode.getCol() == newNodes.get(x).getCol() - 1){
                    return x;
                }
            }
        }

        return 0;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed){
        this.changed = changed;
    }
}
