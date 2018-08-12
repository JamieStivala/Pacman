package map;

import items.Blob;
import items.stationery.Coin;
import items.stationery.Empty;
import items.stationery.Wall;
import map.generator.Seed;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class extends the seed class. Here the building and rendering of the map is done
 */
public class PacmanMap extends Seed {
    private Blob gameTextures[][];
    private HashMap<BlockType, ArrayList<Blob>> organizedBlocks;
    private int wallArray[][];
    private Line verticalWallLines[];
    private Line horizontalWallLines[];
    private BufferedImage bufferedMap;

    public PacmanMap(long seed) {
        super(seed);
        this.gameTextures = new Blob[20][40];
        this.verticalWallLines = new Line[40];
        this.horizontalWallLines = new Line[20];
        this.organizedBlocks = new HashMap<>();

        this.addSpawnBox();
        this.addReflectiveWalls();
        this.drawMap();
        this.aStartWallArrayFiller();
        this.paint();
    }

    /**
    * This is called the represent the spawnBox all the ghosts are going to be inside of
     */
    private void addSpawnBox() {
        //Top & Bottom walls
        super.getSeed(7)[19] = BlockType.WALL;
        super.getSeed(7)[20] = BlockType.WALL;
        super.getSeed(7)[21] = BlockType.WALL;

        super.getSeed(11)[19] = BlockType.WALL;
        super.getSeed(11)[20] = BlockType.WALL;
        super.getSeed(11)[21] = BlockType.WALL;
        //Top & Bottom walls

        //Side walls
        super.getSeed(8)[22] = BlockType.WALL;
        super.getSeed(9)[22] = BlockType.WALL;
        super.getSeed(10)[22] = BlockType.WALL;

        super.getSeed(8)[18] = BlockType.WALL;
        super.getSeed(9)[18] = BlockType.WALL;
        super.getSeed(10)[18] = BlockType.WALL;
        //Side walls

        //Empty the outside box
        super.getSeed(11)[18] = BlockType.EMPTY;
        super.getSeed(7)[18] = BlockType.EMPTY;
        super.getSeed(11)[22] = BlockType.EMPTY;
        super.getSeed(7)[22] = BlockType.EMPTY;
        //Empty the outside box

        //Empty the inside box
        super.getSeed(8)[19] = BlockType.EMPTY;
        super.getSeed(8)[20] = BlockType.EMPTY;
        super.getSeed(8)[21] = BlockType.EMPTY;

        super.getSeed(9)[19] = BlockType.EMPTY;
        super.getSeed(9)[20] = BlockType.EMPTY;
        super.getSeed(9)[21] = BlockType.EMPTY;

        super.getSeed(10)[19] = BlockType.EMPTY;
        super.getSeed(10)[20] = BlockType.EMPTY;
        super.getSeed(10)[21] = BlockType.EMPTY;
        //Empty the inside box
    }

    /**
     * This will make if there is a wall at one end it will generate another wall at the other end.
     *
     * This was done to fix a bug where the pacman would go at one side of the map, teleport to the other side and be stuck in the wall.
     */
    private void addReflectiveWalls() {
        for (int vertical = 0; vertical != super.getSeed().length; vertical++) {
            BlockType current[] = super.getSeed(vertical);
            if (current[0] == BlockType.WALL) {
                current[39] = BlockType.WALL;
            } else if (current[39] == BlockType.WALL) {
                current[0] = BlockType.WALL;
            }
            for (int horizontal = 0; horizontal != current.length; horizontal++) {
                if (super.getSeed(0)[horizontal] == BlockType.WALL) {
                    super.getSeed(19)[horizontal] = BlockType.WALL;
                } else if (super.getSeed(19)[horizontal] == BlockType.WALL) {
                    super.getSeed(0)[horizontal] = BlockType.WALL;
                }
            }
        }
    }

    /**
     * Draws the map with all the textures (Coin, Wall, Empty) and adds it to the 2D array called game textures.
     * To fill up the screen of 1440 * 799, an x increment of 36 was used and a y increment of 39 was used.
     *
     * This also fills up a HashMap with all the blocks organized (so that they can be used in collision systems)
     */
    private void drawMap() {
        int x = 0;
        int y = 20;
        for (int vertical = 0; vertical != super.getSeed().length; vertical++) {
            BlockType current[] = super.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++) {
                if (current[horizontal] == BlockType.WALL) {
                    Wall wall = new Wall(x, y);
                    addToOrganizedBlocks(BlockType.WALL, wall);
                    gameTextures[vertical][horizontal] = wall;
                } else if (current[horizontal] == BlockType.COIN) {
                    Coin coin = new Coin(x, y);
                    addToOrganizedBlocks(BlockType.COIN, coin);
                    gameTextures[vertical][horizontal] = coin;
                } else {
                    Empty empty = new Empty(x, y);
                    addToOrganizedBlocks(BlockType.EMPTY, empty);
                    gameTextures[vertical][horizontal] = new Empty(x, y);
                }
                x += 36;
            }
            x = 0;
            y += 39;
        }
    }

    /**
     * The A* algorithm uses an array to represent where the ghosts can go.  This is filled up at this stage.
     *
     * This method will also fill up "verticalWallLines" and "horizontalWallLines" array of lines.  This is used in the Overlapping detector
     */
    private void aStartWallArrayFiller() {
        this.wallArray = new int[this.getOrganizedBlocks().get(BlockType.WALL).size()][2];
        for (int vertical = 0, wallCounter = 0; vertical != super.getSeed().length; vertical++) {
            BlockType current[] = super.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++) {
                if (current[horizontal] == BlockType.WALL) {
                    wallArray[wallCounter] = new int[]{horizontal, vertical};
                    wallCounter++;
                }
                if (horizontal < 40) {
                    this.verticalWallLines[horizontal] = new Line(horizontal * 36 - 1, 0, horizontal * 36 - 1, 799);
                }
            }
            this.horizontalWallLines[vertical] = new Line(0, (vertical * 39) + 19, 1440, (vertical * 39) + 19);
        }
    }

    /**
     * This will paint the map in a BufferedMap beforehand so it doesn't render on request causing lag.
     * The map also requires this so when coins are picked everything is rendered again
     */
    public void paint() {
        this.bufferedMap = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedMap.getGraphics();
        for (int vertical = 0; vertical != super.getSeed().length; vertical++) {
            BlockType current[] = super.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++) {
                gameTextures[vertical][horizontal].paint(g);
            }
        }
    }

    /**
     * This is a getter for the pre-rendered buffered map
     * @return BufferedMap with all the aspects of the world loaded in
     */
    public BufferedImage getBufferedMap() {
        return this.bufferedMap;
    }

    /**
     * Adds the specified BlockType to the ArrayList of blocks of that BlockType.
     *
     * This method starts of by using Lambda expressions to check if an ArrayList of the BlockType exists. If it doesn't an ArrayList is created.
     * It then adds the block type to the ArrayList.
     *
     * This was implemented as a safe way of adding things to the HashMap and reducing the chance of an error
     * @param blockType The BlockType that is to be added
     * @param blob The loaded texture that is to be used
     */
    private void addToOrganizedBlocks(BlockType blockType, Blob blob) {
        this.organizedBlocks.computeIfAbsent(blockType, h -> new ArrayList<>());
        this.organizedBlocks.get(blockType).add(blob);
    }

    /**
     * @return The HashMap named organizedBlocks
     */
    public HashMap<BlockType, ArrayList<Blob>> getOrganizedBlocks() {
        return organizedBlocks;
    }

    /**
     * @return The 2D wall array for the A*
     */
    public int[][] getWallArray() {
        return wallArray;
    }

    /**
     * @return The vertical lines used for Overlapping Detector
     */
    public Line[] getVerticalWallLines() {
        return verticalWallLines;
    }

    /**
     * @return The horizontal lines used for the Overlapping Detector
     */
    public Line[] getHorizontalWallLines() {
        return horizontalWallLines;
    }
}
