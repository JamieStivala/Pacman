package game;

import game.map.PacmanMap;

public class MapUpdater extends Thread {
    private PacmanFrame pacmanFrame;
    private PacmanMap pacmanMap;

    MapUpdater(PacmanFrame pacmanFrame, PacmanMap pacmanMap) {
        this.pacmanFrame = pacmanFrame;
        this.pacmanMap = pacmanMap;
    }

    @Override
    public void run() {

    }
}
