package items.moving.ghosts.threads;

import frames.PacmanFrame;
import items.moving.ghosts.Ghost;
import items.moving.ghosts.Ghosts;
import items.moving.pacman.Pacman;
import sounds.pacman.Death;

public class GhostsCollisionDetection extends Thread{
    private PacmanFrame pacmanFrame;
    private Ghosts ghosts;
    private Pacman pacman;

    public GhostsCollisionDetection(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
        this.ghosts = pacmanFrame.getGhosts();
        this.pacman = pacmanFrame.getPacman();
    }

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
