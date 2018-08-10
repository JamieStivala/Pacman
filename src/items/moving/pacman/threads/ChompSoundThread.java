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

    void playSound(){
        try{
            Chomp chomp = new Chomp();
            chomp.start();
            chomp.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
