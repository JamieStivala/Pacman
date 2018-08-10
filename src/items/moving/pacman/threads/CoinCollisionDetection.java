package items.moving.pacman.threads;

import frames.PacmanFrame;
import items.moving.pacman.Pacman;
import map.BlockType;
import sounds.pacman.Chomp;

public class CoinCollisionDetection extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;
    private int score = 0;
    private volatile boolean coinUpdateSinceLastBuffer;

    public CoinCollisionDetection(PacmanFrame pacmanFrame) {
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    @Override
    public void run() {
        while (pacmanFrame.isRunning()) {
            pacmanFrame.getMap().getOrganizedBlocks().get(BlockType.COIN).removeIf(coin -> {
                if (coin.hasCollidedWith(pacman)) {
                    new Chomp().start();
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

    public boolean hasCoinBeenTaken() {
        return !coinUpdateSinceLastBuffer;
    }

    public void updatedCoins() {
        this.coinUpdateSinceLastBuffer = true;
    }

    public int getScore() {
        return score;
    }
}
