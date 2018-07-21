package generator;

import java.util.Random;

class Seed {
    private Random random;
    private boolean seed[][];

    Seed() {
        this((long) (Math.random() * 1000000000));
    }

    Seed(long seed) {
        this.seed = new boolean[20][40];
        this.random = new Random(seed);
    }
}

enum BlockType{
    EMPTY,
    COIN,
    WALL
}
