package game.map.generator;

import game.map.BlockType;

import java.util.Random;

/**
 * This class represents the original generated world without the textures loaded in
 * These are loaded in 2D Arrays
 */
public class Seed {
    private Random random;
    private BlockType seed[][];

    public Seed(long seed) {
        this.seed = new BlockType[20][40];
        this.random = new Random(seed); //Pseudo-random generation

        //Looped 20 times representing the 20 vertical blocks in game
        for (int vertical = 0; vertical != 20; vertical++) {
            this.seed[vertical] = SeedOperations.numberToEnum(
                    random.nextInt(1000000000), //Generates three numbers and calls number to ENUM
                    random.nextInt(1000000000),
                    random.nextInt(1000000000));
        }
    }

    //Getter for the 2D Array
    protected BlockType[][] getSeed() {
        return seed;
    }

    //Getter for the array given the seed
    protected BlockType[] getSeed(int index) {
        return seed[index];
    }
}
