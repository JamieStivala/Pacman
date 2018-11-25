package game;

import java.util.Random;

public class Generator {
    private BlockType builtMap[][];
    private Random pseudoRandomGenerator;

    public Generator(int width, int height){
        this((int)(Math.random() * 10000), width, height);
    }

    public Generator(int seed, int width, int height){
        System.out.println(seed);
        this.builtMap  = new BlockType[width][height];
        this.pseudoRandomGenerator = new Random(seed);

        BlockType[] blockTypes = stringToBinary(correctLengthBinaryNumber(pseudoRandomGenerator.nextInt(1000000000)), BlockType.WALL);
        for (BlockType b : blockTypes) {
            System.out.println(b);
        }
    }

    private static String correctLengthBinaryNumber(int number){
        String binaryNumber = Integer.toBinaryString(number);
        binaryNumber =  binaryNumber.substring(0, Math.min(binaryNumber.length(), 20));
        return binaryNumber;
    }

    //00 -> PAC_DOT
    //01 -> PAC_DOT
    //10 -> FRUIT/PAC_DOT
    //11 -> PAC_DOT
    private static BlockType[] stringToBinary(String binaryNumber, BlockType preferredBlock){
        char[] binaryStringC = binaryNumber.toCharArray();
        BlockType[] blockTypes = new BlockType[binaryStringC.length/2];
        int specialBlockCounter = 0;

        BlockType otherBlock;
        otherBlock = preferredBlock == BlockType.PAC_DOT ? BlockType.WALL : BlockType.PAC_DOT;

        for (int binaryStringCounter = 0, blockTypeArrayPositionCounter = 0; blockTypeArrayPositionCounter != blockTypes.length ; binaryStringCounter++) {
            int binaryStringCounterIncremented = binaryStringCounter++;

            if(binaryStringC[binaryStringCounter] == '0' && binaryStringC[binaryStringCounterIncremented] == '0' || binaryStringC[binaryStringCounter] == '0' && binaryStringC[binaryStringCounterIncremented] == '1'){
                blockTypes[blockTypeArrayPositionCounter] = preferredBlock;
            }else if(binaryStringC[binaryStringCounter] == '1' && binaryStringC[binaryStringCounterIncremented] == '0'){
                blockTypes[blockTypeArrayPositionCounter] = otherBlock;
            }else if(binaryStringC[binaryStringCounter] == '1' && binaryStringC[binaryStringCounterIncremented] == '1' ){
                if(specialBlockCounter == 0) {
                    blockTypes[blockTypeArrayPositionCounter] = BlockType.FRUIT;
                }else{
                    blockTypes[blockTypeArrayPositionCounter] = BlockType.POWER_PELLET;
                }
                specialBlockCounter ++;
            }
            blockTypeArrayPositionCounter++;
        }

        return blockTypes;
    }



}
