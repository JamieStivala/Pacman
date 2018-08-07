package map;

import items.Blob;
import items.stationery.Coin;
import items.stationery.Empty;
import items.stationery.Wall;
import map.generator.Seed;
import map.generator.SeedOperations;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class PacmanMap extends Seed {
    private Blob gameTextures[][];
    private HashMap<BlockType, ArrayList<Blob>> organizedBlocks;
    private int wallArray[][];
    private BufferedImage bufferedMap;

    public PacmanMap(long seed){
        super(seed);
        this.gameTextures = new Blob[20][40];
        this.organizedBlocks = new HashMap<>();
        this.addReflectiveWalls();
        this.addSpawnBox();
        this.drawMap();
        this.paint();
    }

    private void addSpawnBox(){
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

    private void addReflectiveWalls(){
        for (int vertical = 0; vertical != super.getSeed().length ; vertical++) {
            BlockType current[] = super.getSeed(vertical);
            if(current[0] == BlockType.WALL){
                current[39] = BlockType.WALL;
            }else if(current[39] == BlockType.WALL){
                current[0] = BlockType.WALL;
            }
            for (int horizontal = 0; horizontal != current.length; horizontal++){
                if(super.getSeed(0)[horizontal] == BlockType.WALL){
                    super.getSeed(19)[horizontal] = BlockType.WALL;
                }else if(super.getSeed(19)[horizontal] == BlockType.WALL){
                    super.getSeed(0)[horizontal] = BlockType.WALL;
                }
            }
        }
    }

    private void drawMap(){
        int x = 0;
        int y = 20;
        this.wallArray = new int[SeedOperations.getAmountWall()][2];
        for(int vertical = 0, emptyCounter = 0; vertical != super.getSeed().length; vertical++){
            BlockType current[] = super.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++){
                if(current[horizontal] == BlockType.WALL){
                    Wall wall = new Wall(x, y);
                    addToOrganizedBlocks(BlockType.WALL, wall);
                    gameTextures[vertical][horizontal] = wall;
                }else if(current[horizontal] == BlockType.COIN){
                    Coin coin = new Coin(x, y);
                    addToOrganizedBlocks(BlockType.COIN, coin);
                    gameTextures[vertical][horizontal] = coin;
                }else{
                    this.wallArray[emptyCounter] = new int[] {x, y};
                    emptyCounter++;
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

    public void paint(){
        this.bufferedMap = new BufferedImage(1440, 799, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedMap.getGraphics();
        for(int vertical = 0; vertical != super.getSeed().length; vertical++){
            BlockType current[] = super.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++){
                gameTextures[vertical][horizontal].paint(g);
            }
        }
    }

    public BufferedImage getBufferedMap(){
        return this.bufferedMap;
    }

    public Blob[][] getGameTextures() {
        return this.gameTextures;
    }

    public Blob[] getGameTextures(int index) {
        return this.gameTextures[index];
    }

    private void addToOrganizedBlocks(BlockType blockType, Blob blob){
        this.organizedBlocks.computeIfAbsent(blockType, h -> new ArrayList<>());
        this.organizedBlocks.get(blockType).add(blob);
    }

    public HashMap<BlockType, ArrayList<Blob>> getOrganizedBlocks() {
        return organizedBlocks;
    }
}
