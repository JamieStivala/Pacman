package generator;

import java.util.Random;

public class Seed {
    private Random random;
    private BlockType seed[][];

    public Seed(long seed) {
        System.out.println(seed);
        this.seed = new BlockType[20][40];
        this.random = new Random(seed);

        for(int vertical = 0; vertical != 20; vertical++){
            this.seed[vertical] = SeedOperations.numberToEnum(
                    random.nextInt(1000000000),
                    random.nextInt(1000000000),
                    random.nextInt(1000000000));
        }
    }

    BlockType[][] getSeed() {
        return seed;
    }

    BlockType[] getSeed(int index) {
        return seed[index];
    }
}
