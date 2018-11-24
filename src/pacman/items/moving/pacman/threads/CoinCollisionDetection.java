package pacman.items.moving.pacman.threads;

import pacman.PacmanFrame;
import pacman.items.moving.pacman.Pacman;
import pacman.map.BlockType;

/**
 * Checks if the pacman has collided with the coin.
 * This is done is a separate thread for efficiency
 */
public class CoinCollisionDetection extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;
    private int score = 0;
    private volatile boolean coinUpdateSinceLastBuffer;

    /**
     * @param pacmanFrame The pacman frame that has almost all the objects of the Pacman
     */
    public CoinCollisionDetection(PacmanFrame pacmanFrame) {
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    /**
     * This constantly checks if the pacman has collided with the coin.
     * If it has, the coin is set to invisible, the score is updated and it triggers coinUpdatedSinceLastBuffer.  This is then used to render the pacman.map in GeneralMover.
     * The score is dependent on the amount of pacman there are currently in game.
     *
     * The lambda expression of ArrayList.removeIf was used for better code readability and to prevent ConcurrentModificationException
     */
    @Override
    public void run() {
        while (pacmanFrame.isRunning()) {
            pacmanFrame.getMap().getOrganizedBlocks().get(BlockType.COIN).removeIf(coin -> {
                if (coin.hasCollidedWith(pacman)) {
                    score = score + (pacmanFrame.getGhosts().getAmountOfGhostsOut() * 2);
                    coinUpdateSinceLastBuffer = false;
                    coin.setVisible(false);
                    return true;
                }
                return false;
            });
        }
        pacmanFrame.getUser().setLastGameScore(score);
    }

    /**
     * @return If a coin has been taken since last buffer
     */
    public boolean hasCoinBeenTaken() {
        return !coinUpdateSinceLastBuffer;
    }

    /**
     * Used in GeneralMover to let this thread know that the pacman.map has been updated since the coin has been taken
     */
    public void updatedCoins() {
        this.coinUpdateSinceLastBuffer = true;
    }

    /**
     * @return The score of the current game
     */
    public int getScore() {
        return score;
    }
}
