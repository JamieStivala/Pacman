package generator;

class Seed {
    private boolean seed[][];

    Seed(long seed){
        int split[] = new int[20];
        this.seed = new boolean[20][40];
        System.out.println(seed);

        int currentCounter = 0;
        String temp = Long.toString(seed);

        for(; currentCounter != temp.length(); currentCounter++){
            split[currentCounter] = temp.charAt(currentCounter) - '0';
        }

        temp = Long.toString(seed * 2);
        for(int i = 0; i != temp.length(); i++, currentCounter++){
            split[currentCounter] = temp.charAt(i) - '0';
        }

        temp = Long.toString(seed * 3);
        for(int i = 0; currentCounter != split.length; i++, currentCounter++){
            split[currentCounter] = temp.charAt(i) - '0';
        }

        for (int i = 0; i != split.length; i++) {
            this.seed[i] = BinaryOperations.binaryToBoolean(BinaryOperations.oneDecimalToMultipleBinary(split[i]));
        }
    }

    public boolean[] getSeed(int index){
        return this.seed[index];
    }
}

enum BlockType{
    EMPTY,
    COIN,
    WALL
}
