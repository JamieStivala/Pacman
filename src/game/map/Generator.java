package game.map;

import java.util.Random;

public class Generator {
    private BlockType builtMap[][];
    private Random pseudoRandomGenerator;

    private int width, height;

    public Generator(int width, int height){
        this((int) (Math.random() * 1000000000), width, height);
    }

    public Generator(int seed, int width, int height){
        System.out.println(seed);
        this.width = width;
        this.height = height;

        this.pseudoRandomGenerator = new Random(seed);
        this.builtMap = this.buildMap();
    }

    /**
     * @param number The number to be converted into binary format
     * @return The binary number with length 20
     */
    private static String correctLengthBinaryNumber(int number){
        String binaryNumber = Integer.toBinaryString(number);
        binaryNumber =  binaryNumber.substring(0, Math.min(binaryNumber.length(), 20));
        return binaryNumber;
    }

    /**
     * This algorithm works by getting a binary number and converting it to the following way;
     * When it is '0 0' and '1 0' it is converted to preferredBlock
     * When it is '1 0' it is converted into the opposite of preferredBlock
     * When it is '1 1' it is converted into either a cherry or fruit;
     *      If there is no fruits that one will be a fruit
     *      If there is a fruit the rest will become a Power Pellet
     *
     * After it is done it makes sure that the amount of preferred block is more than the other block and if not it switches them
     *
     * @param binaryNumber The Binary Number that will be converted into the correct format of Block Types
     * @param preferredBlock The preferred block will the main generated block
     * @return An array of BlockType of length 20
     */
    private static BlockType[] stringToBinary(String binaryNumber, BlockType preferredBlock){
        char[] binaryStringC = binaryNumber.toCharArray();
        BlockType[] blockTypes = new BlockType[binaryStringC.length/2];

        int specialBlockCounter = 0;
        int preferredBlockCounter = 0;
        int otherBlockCounter = 0;

        BlockType otherBlock = preferredBlock == BlockType.PAC_DOT ? BlockType.WALL : BlockType.PAC_DOT;

        for (int binaryStringCounter = 0, blockTypeArrayPositionCounter = 0; blockTypeArrayPositionCounter != blockTypes.length ; binaryStringCounter++) {
            int binaryStringCounterIncremented = binaryStringCounter++;

            if(binaryStringC[binaryStringCounter] == '0' && binaryStringC[binaryStringCounterIncremented] == '0' || binaryStringC[binaryStringCounter] == '0' && binaryStringC[binaryStringCounterIncremented] == '1' || specialBlockCounter > 2){
                blockTypes[blockTypeArrayPositionCounter] = preferredBlock;
                preferredBlockCounter++;
            }else if(binaryStringC[binaryStringCounter] == '1' && binaryStringC[binaryStringCounterIncremented] == '0'){
                blockTypes[blockTypeArrayPositionCounter] = otherBlock;
                otherBlockCounter++;
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

        if(preferredBlockCounter > otherBlockCounter) return blockTypes;

        for (int i = 0; i != blockTypes.length ; i++) {
            if(blockTypes[i] == preferredBlock){
                blockTypes[i] = otherBlock;
            }else if(blockTypes[i] == otherBlock){
                blockTypes[i] = preferredBlock;
            }
        }
        return blockTypes;
    }

    private BlockType[] buildOneVerticalLine(BlockType preferredBlock) {
        int lengthOfString = width * 2;
        StringBuilder generatedNumber = new StringBuilder();
        do {
            generatedNumber.append(correctLengthBinaryNumber(pseudoRandomGenerator.nextInt(1000000000)));
        } while (generatedNumber.length() < lengthOfString);

        String finalGeneratedNumber = generatedNumber.toString();
        finalGeneratedNumber = finalGeneratedNumber.substring(0, Math.min(finalGeneratedNumber.length(), lengthOfString));

        return stringToBinary(finalGeneratedNumber, preferredBlock);
    }

    private BlockType[][] buildMap() {
        BlockType[][] invertedMap = new BlockType[height][width];
        BlockType preferredBlock = BlockType.PAC_DOT;
        for (int i = 0; i != height; i++) {
            invertedMap[i] = buildOneVerticalLine(preferredBlock);
            if (preferredBlock == BlockType.PAC_DOT) preferredBlock = BlockType.WALL;
            else preferredBlock = BlockType.PAC_DOT;
        }


        BlockType[][] builtMap = new BlockType[width][height];

        for (int i = 0; i != width; i++) {
            for (int j = 0; j != height; j++) {
                builtMap[i][j] = invertedMap[j][i];
            }
        }

        for (int i = 0; i != builtMap.length; i++) {
            int fruitCounter = 0;
            for (int j = 0; j != builtMap[i].length; j++) {
                if (builtMap[i][j] == BlockType.FRUIT) fruitCounter++;
                if (fruitCounter > 1) builtMap[i][j] = preferredBlock;
            }
        }

        return builtMap;
    }
}
