package pacman.map.generator;

import pacman.map.BlockType;

/**
 * This "static" class is used for operations only regarding the seed
 */
class SeedOperations {
    /**
     * This will insert a string (in binary format) and a will format it by either adding 0 at the end or
     * by cutting the string from the end to match the specified length
     *
     * @param fixing This is the string (that has been converted to binary) that needs fixing
     * @param length This represents how long we want the final string to be
     * @return The return is the string with either added 0 at the end or a string cut to the length specified
     */
    private static String fixLength(String fixing, int length) {
        StringBuilder buffer = new StringBuilder(fixing);

        if (fixing.length() < length) {
            for (int i = 0; i != length - fixing.length(); i++) {
                buffer.insert(0, 0);
            }
        } else if (fixing.length() > length) {
            buffer.delete(0, fixing.length() - length);
        } else {
            return fixing;
        }
        return buffer.toString();
    }

    /**
     * This is what will be used to convert the pseudo-random numbers to enums.  The method works by converting
     * the all the numbers given to binary and then fixing the length of each String
     *
     * It then converts all the numbers into one string and converts it into a binary character array.  Afterwards it query's the String
     * 2 numbers at a time and follows this algorithm:
     *
     * When 0 and 0 = EMPTY
     * When 1 and 0 or 0 and 1 COIN
     * When 1 and 1 WALL
     *
     * Afterwards it checks which one has the most and if it's the wall that has the most blocks it switches them with the one that has the least
     *
     * @param firstNumber The first pseudo-random number
     * @param secondNumber The second pseudo-random number
     * @param thirdNumber The third pseudo-random number
     * @return This will return an array of 40 blocks (representing one horizontal line)
     */
    static BlockType[] numberToEnum(int firstNumber, int secondNumber, int thirdNumber) {
        int amountWall = 0;
        int amountCoin = 0;
        int amountEmpty = 0;
        String binaryString = fixLength(Integer.toBinaryString(firstNumber), 30)
                + fixLength(Integer.toBinaryString(secondNumber), 30)
                + fixLength(Integer.toBinaryString(thirdNumber), 20);

        char binary[] = binaryString.toCharArray();
        BlockType blockType[] = new BlockType[40];

        for (int i = 0, counter = 0; i != binary.length; i++, counter++) {
            char defaultI = binary[i];
            char incrementedI = binary[++i];

            if (defaultI == '0' && incrementedI == '0') {
                blockType[counter] = BlockType.EMPTY;
                amountEmpty++;
            } else if (defaultI == '0' && incrementedI == '1' || defaultI == '1' && incrementedI == '0') {
                blockType[counter] = BlockType.COIN;
                amountCoin++;
            } else if (defaultI == '1' && incrementedI == '1') {
                blockType[counter] = BlockType.WALL;
                amountWall++;
            }
        }

        if (amountWall > amountEmpty) {
            for (int i = 0; i != blockType.length; i++) {
                if (blockType[i] == BlockType.EMPTY) blockType[i] = BlockType.WALL;
                else if (blockType[i] == BlockType.WALL) blockType[i] = BlockType.EMPTY;
            }
        } else if (amountWall > amountCoin) {
            for (int i = 0; i != blockType.length; i++) {
                if (blockType[i] == BlockType.COIN) blockType[i] = BlockType.WALL;
                else if (blockType[i] == BlockType.WALL) blockType[i] = BlockType.COIN;
            }
        }

        return blockType;
    }
}
