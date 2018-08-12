package frames;

import frames.listeners.pacman.PacmanKeyListener;
import items.moving.GeneralMover;
import items.moving.ghosts.Ghosts;
import items.moving.ghosts.threads.GhostsCollisionDetection;
import items.moving.pacman.Pacman;
import items.moving.pacman.threads.ChompSoundThread;
import items.moving.pacman.threads.CoinCollisionDetection;
import items.moving.pacman.threads.OverlappingDetection;
import items.moving.pacman.threads.WallCollisionDetection;
import map.PacmanMap;
import user.manager.User;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The pacman frame is what will store everything regarding the Pacman including the Ghosts, Map, Pacman and user playing and all the threads
 * such as the generalMover, wallCollisionDetection, coinCollisionDetection, overlappingDetection, ghostsCollisionDetection and chompSoundThread
 *
 * This also represents the frame which means that rendering is done here
 */
public class PacmanFrame extends JFrame {
    private PacmanMap map;
    private Pacman pacman;
    private User user;
    private GeneralMover generalMover;
    private WallCollisionDetection wallCollisionDetection;
    private CoinCollisionDetection coinCollisionDetection;
    private OverlappingDetection overlappingDetection;
    private GhostsCollisionDetection ghostsCollisionDetection;
    private ChompSoundThread chompSoundThread;
    private Ghosts ghosts;

    private BufferedImage screen;
    private volatile boolean stopped;

    /**
     * This sets the seed to random and calls PacmanFrame(User user, long seed)
     * @param user The user of game
     */
    public PacmanFrame(User user) {
        this(user, (long) (Math.random() * 1000000000));
    }

    /**
     * This is the main constructor of the whole game.
     *
     * Here an instance of the map is created
     * It updates everything in the profile such as adding the seed and increment the amount of games played
     * Creates an instance of the Pacman
     * Creates the screen that will act as the rendering canvas
     * Sets all the frame settings such as the frame size etc
     * Starts all the threads needed for the game to work
     *
     * @param user The user playing the game
     * @param seed The seed of the map
     */
    PacmanFrame(User user, long seed) {
        this.map = new PacmanMap(seed);
        this.user = user;
        this.ghosts = new Ghosts();
        profileFlags(seed);
        this.pacman = new Pacman(0, 24);
        this.screen = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);

        this.setStopped(false);

        setFrameSettings();
        startThreads();
    }

    /**
     * Adds the seed and increments the amount of games played
     * If the seed is found it doesn't add it again
     * @param seed The seed of the map
     */
    private void profileFlags(long seed) {
        boolean found = false;
        for (int i = 0; i != user.getSeedsPlayed().size(); i++) {
            if (user.getSeedsPlayed().get(i) == seed) found = true;
        }
        if (!found) user.getSeedsPlayed().add(0, seed);
        user.incrementTotalPlayedGamed();
    }

    /**
     * Sets all the settings of the frame
     * Title to Pacman
     * Size to 1440, 799
     * Resizable to false
     * Adds the key listener
     * Sets the layout to null
     * Sets it visible
     * Requests focus
     */
    private void setFrameSettings() {
        super.setTitle("Pacman");
        super.setSize(1440, 799);
        super.setResizable(false);
        super.addKeyListener(new PacmanKeyListener(this));
        super.setLayout(null);
        super.setVisible(true);
        super.requestFocus();
    }

    /**
     * Starts all the threads that the game needs
     * coinCollisionDetection
     * generalMover
     * wallCollisionDetection
     * overlappingDetection
     * ghostsCollisionDetection
     * chompSoundThread
     */
    private void startThreads() {
        this.coinCollisionDetection = new CoinCollisionDetection(this);
        this.coinCollisionDetection.start();

        this.generalMover = new GeneralMover(this);
        this.generalMover.start();

        this.wallCollisionDetection = new WallCollisionDetection(this);
        this.wallCollisionDetection.start();

        this.overlappingDetection = new OverlappingDetection(this);
        this.overlappingDetection.start();

        this.ghostsCollisionDetection = new GhostsCollisionDetection(this);
        this.ghostsCollisionDetection.start();

        this.chompSoundThread = new ChompSoundThread(this);
        this.chompSoundThread.start();
    }

    /**
     * This renders the pacman, the ghosts and also gets the map from that was pre-rendered.  It also adds the background
     */
    public void render() {
        Graphics g = screen.getGraphics();
        g.setColor(new Color(5, 19, 28));
        g.fillRect(1, 1, screen.getWidth(), screen.getHeight());
        g.drawImage(map.getBufferedMap(), 1, 1, screen.getWidth(), screen.getHeight(), null);
        pacman.paint(g);
        ghosts.paint(g);
    }

    /**
     * Paints the screen
     * @param g The graphics from java.awt
     */
    @Override
    public void paint(Graphics g) {
        if (screen == null) return;
        g.drawImage(screen, 1, 1, null);
    }

    /**
     *  The update calls the paint()
     * @param g the graphics from java.awt
     */
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * @return The moving Pacman
     */
    public Pacman getPacman() {
        return pacman;
    }

    /**
     * @return If the game is running
     */
    public boolean isRunning() {
        return !stopped;
    }

    /**
     * @param stopped Sets if the game is stopped
     */
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    /**
     * @return The generated map object
     */
    public PacmanMap getMap() {
        return map;
    }

    /**
     * @return The WallCollisionDetection thread
     */
    public WallCollisionDetection getWallCollisionDetection() {
        return wallCollisionDetection;
    }
    /**
     * @return The CoinCollisionDetection thread
     */
    public CoinCollisionDetection getCoinCollisionDetection() {
        return coinCollisionDetection;
    }

    /**
     * @return The playing user
     */
    public User getUser() {
        return user;
    }

    /**
     * @return The Object of ghosts
     */
    public Ghosts getGhosts() {
        return ghosts;
    }

    /**
     * @return The ChompSoundThread thread
     */
    public ChompSoundThread getChompSoundThread() {
        return chompSoundThread;
    }
}