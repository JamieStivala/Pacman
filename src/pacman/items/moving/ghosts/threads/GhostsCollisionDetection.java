package pacman.items.moving.ghosts.threads;

import pacman.frame.PacmanFrame;
import pacman.items.moving.ghosts.Ghost;
import pacman.items.moving.ghosts.Ghosts;
import pacman.items.moving.pacman.Pacman;
import pacman.sounds.pacman.Death;

/**
 * Constantly checks if any of the ghosts have collided with the Pacman
 * This is done is a separate thread for efficiency
 */
public class GhostsCollisionDetection extends Thread{
    private PacmanFrame pacmanFrame;
    private Ghosts ghosts;
    private Pacman pacman;

    /**
     * @param pacmanFrame he pacman frame that has almost all the objects of the Pacman game
     */
    public GhostsCollisionDetection(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
        this.ghosts = pacmanFrame.getGhosts();
        this.pacman = pacmanFrame.getPacman();
    }

    /**
     * This constantly checks if the pacman has collided with the ghosts.
     * If the pacman has collided with the ghosts, the game is set to stopped, waits for the chomp start thread to finish and the death sound is played
     */
    @Override
    public void run(){
        while(pacmanFrame.isRunning()){
            for (Ghost ghost: this.ghosts.getGhosts()) {
                if(ghost.hasCollidedWith(pacman)) {
                    pacmanFrame.setStopped(true);
                    try {
                        pacmanFrame.getChompSoundThread().join();
                        new Death().start();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
