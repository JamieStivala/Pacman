package generator;

class BinaryOperations {
    private static String fixLength(String fixing, int length) {
        StringBuilder buffer = new StringBuilder(fixing);

        if (fixing.length() < length) {
            for (int i = 0; i != length - fixing.length(); i++) {
                buffer.insert(0, 0);
            }
        } else if (fixing.length() > length) {
            buffer.delete(0, fixing.length() - length);
        }else{
            return fixing;
        }
        return buffer.toString();
    }

    static BlockType[] numberToEnum(int firstNumber, int secondNumber, int thirdNumber){
        int amountWall = 0;
        int amountCoin = 0;
        int amountEmpty = 0;
        String binaryString = fixLength(Integer.toBinaryString(firstNumber), 30)
                + fixLength(Integer.toBinaryString(secondNumber), 30)
                + fixLength(Integer.toBinaryString(thirdNumber), 20);

        char binary[] = binaryString.toCharArray();
        BlockType blockType[] = new BlockType[40];

        for(int i = 0, counter = 0; i != binary.length; i++, counter++){
            char defaultI = binary[i];
            char incrementedI = binary[++i];

            if(defaultI == '0' && incrementedI == '0'){
                blockType[counter] = BlockType.EMPTY;
                amountEmpty++;
            }else if(defaultI == '0' && incrementedI == '1' || defaultI == '1' && incrementedI == '0'){
                blockType[counter] = BlockType.COIN;
                amountCoin++;
            }else if(defaultI == '1' && incrementedI == '1'){
                blockType[counter] = BlockType.WALL;
                amountWall++;
            }
        }


        if(amountWall > amountEmpty){
            System.out.println("less empty");
            for (int i = 0; i != blockType.length ; i++) {
                if(blockType[i] == BlockType.EMPTY) blockType[i] = BlockType.WALL;
                else if(blockType[i] == BlockType.WALL) blockType[i] = BlockType.EMPTY;
            }
        }else if(amountWall > amountCoin){
            for (int i = 0; i != blockType.length ; i++) {
                if(blockType[i] == BlockType.COIN) blockType[i] = BlockType.WALL;
                else if(blockType[i] == BlockType.WALL) blockType[i] = BlockType.COIN;
            }
        }
        return blockType;
    }
}
