package map;

import items.Blob;
import items.stationery.Coin;
import items.stationery.Empty;
import items.stationery.Wall;
import map.generator.Seed;

import java.awt.*;

public class PacmanMap extends Seed {
    private Blob gameTextures[][] = new Blob[20][40];
    public PacmanMap(){
        this((long) (Math.random() * 1000000000));
    }

    public PacmanMap(long seed){
        super(seed);
        this.addSpawnBox();
        this.drawMap();
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

    private void drawMap(){
        int x = 2;
        int y = 24;
        for(int vertical = 0; vertical != super.getSeed().length; vertical++){
            BlockType current[] = super.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++){
                if(current[horizontal] == BlockType.WALL){
                    gameTextures[vertical][horizontal] = new Wall(x, y);
                }else if(current[horizontal] == BlockType.COIN){
                    gameTextures[vertical][horizontal] = new Coin(x, y);
                }else{
                    gameTextures[vertical][horizontal] = new Empty(x, y);
                }
                x += 36;
            }
            x = 2;
            y += 39;
        }
    }

    public void paint(Graphics g){
        for(int vertical = 0; vertical != super.getSeed().length; vertical++){
            BlockType current[] = super.getSeed(vertical);
            for (int horizontal = 0; horizontal != current.length; horizontal++){
                gameTextures[vertical][horizontal].paint(g);
            }
        }
    }

    public Blob[][] getGameTextures() {
        return this.gameTextures;
    }

    public Blob[] getGameTextures(int index) {
        return this.gameTextures[index];
    }
}
