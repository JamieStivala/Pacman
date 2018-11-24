package game.items.moving.ghosts;

import game.astar.Node;
import game.items.Sprite;

import java.util.List;

/**
 * This class represents one Ghost and all the custom methods it would need
 */
public abstract class Ghost extends Sprite {
    private List<Node> path;
    private int changed;

    /**
     * It calls the constructor of the Sprite
     *
     * @param filename The resource file name of the Blob
     * @param x The spawning x coordinate
     * @param y The spawning y coordinate
     * @param width The width of the resource
     * @param height The height of the resource
     */
    public Ghost(String filename, int x, int y, int width, int height) {
        super(filename, x, y, width, height);
    }

    /**
     * @return A list of nodes with the path of the A*
     */
    public List<Node> getPath() {
        return path;
    }

    /**
     * @param path The new A* Path
     */
    public void setPath(List<Node> path) {
        changed = setChanged(path);
        this.path = path;
    }

    /**
     * A method that picks up where the last node left off.
     *
     * Since the game is constantly moving, the A* algorithm has to be consistently updated.  Because of this, it doesn't know
     * where the last one left of in rows and columns since the pointer is always being updated.
     * This method checks the old and new nodes and checks where the columns or rows have increment by one relative to the previous node
     *
     * @param newNodes The list of the new nodes
     * @return The next move position in List
     */
    private int setChanged(List<Node> newNodes){
        List<Node> oldNodes = this.getPath();
        if(oldNodes == null) return 0;

        int min = (oldNodes.size() < newNodes.size()) ? oldNodes.size() : newNodes.size(); //The size of the smallest node

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

    /**
     * @return The getter of the output in setChanged
     */
    public int getChanged() {
        return changed;
    }
}
