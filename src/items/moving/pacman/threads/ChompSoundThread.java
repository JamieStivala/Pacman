package items.moving.pacman.threads;

import frames.PacmanFrame;
import sounds.pacman.Chomp;

public class ChompSoundThread extends Thread {
    private PacmanFrame pacmanFrame;

    public ChompSoundThread(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
    }
    @Override
    public void run(){
        while(pacmanFrame.isRunning()) {
            playSound();
        }
    }

    private void playSound(){
        Chomp chomp = new Chomp();
        chomp.start();
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception: " + e.getMessage());
        }
    }
}
