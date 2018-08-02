package items.moving.threads;

import frames.PacmanFrame;

public class PacmanMover extends Thread{
    private boolean stopped;
    private PacmanFrame pacmanFrame;

    public PacmanMover(PacmanFrame pacmanFrame){
        this.pacmanFrame = pacmanFrame;
    }

    @Override
    public void run() {
        while(!stopped) {
            pacmanFrame.getPacman().moveRight(5);
            pacmanFrame.render();
            pacmanFrame.repaint();
            try{
                Thread.sleep(105);
            }catch (InterruptedException e){
                System.err.println("Interrupted exception: " + e.getMessage());
            }
        }
    }

    public void stopThread() {
        this.stopped = true;
    }
}
