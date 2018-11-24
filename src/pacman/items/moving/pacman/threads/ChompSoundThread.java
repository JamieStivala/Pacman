package pacman.items.moving.pacman.threads;

import pacman.PacmanFrame;
import pacman.sounds.pacman.Chomp;
import pacman.sounds.pacman.GameStart;

/**
 * This thread constantly plays the chomp sounds
 * This is done is a separate thread for efficiency
 */
public class ChompSoundThread extends Thread {
    private PacmanFrame pacmanFrame;

    /**
     * @param pacmanFrame The pacman frame that has almost all the objects of the Pacman
     */
    public ChompSoundThread(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
    }

    /**
     * This thread first runs the game start sounds, and then constantly plays the playSound
     */
    @Override
    public void run(){
        new GameStart().start();
        gameStartSleep();
        while(pacmanFrame.isRunning()) {
            playSound();
        }
    }

    /**
     * The chomp sound player
     */
    private void playSound(){
        Chomp chomp = new Chomp();
        chomp.start();
        sleep();
    }

    /**
     * A sleep with the length of the chomp sound
     */
    private void sleep() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception: " + e.getMessage());
        }
    }

    /**
     * A sleep with the length of the game start sound
     */
    private void gameStartSleep() {
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception: " + e.getMessage());
        }
    }

}
