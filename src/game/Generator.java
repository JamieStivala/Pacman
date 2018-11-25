package game;

import java.util.Random;

public class Generator {
    private boolean builtMap[][];
    private Random pseudoRandomGenerator;

    public Generator(int width, int height){
        this((int)(Math.random() * 10000), width, height);
    }

    public Generator(int seed, int width, int height){
        System.out.println(seed);
        this.builtMap  = new boolean[width][height];
        this.pseudoRandomGenerator = new Random(seed);
    }

    private String correctLenghtBinaryNumber(int number){
        String binaryNumber = Integer.toBinaryString(number);
        binaryNumber =  binaryNumber.substring(0, Math.min(binaryNumber.length(), 20));
        return binaryNumber;
    }

}
