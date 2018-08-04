package map;

import frames.PacmanFrame;
import items.moving.Pacman;

public class CoinCollisionDetection extends Thread {
    private PacmanFrame pacmanFrame;
    private Pacman pacman;
    private volatile boolean coinUpdateSinceLastBuffer;

    public CoinCollisionDetection(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
        this.pacman = pacmanFrame.getPacman();
    }

    @Override
    public void run(){
        while(pacmanFrame.isRunning()){
            pacmanFrame.getMap().getOrganizedBlocks().get(BlockType.COIN).removeIf(coin ->{
                if(coin.hasCollidedWith(pacman)){
                    coinUpdateSinceLastBuffer = false;
                    coin.setVisible(false);
                    return true;
                }
                return false;
            });
        }
    }

    public boolean hasCoinBeenTaken(){
        return !coinUpdateSinceLastBuffer;
    }

    public void updatedCoins(){
        this.coinUpdateSinceLastBuffer = true;
    }
}
