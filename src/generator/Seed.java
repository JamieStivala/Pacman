package generator;

public class Seed {
    private int split[];
    private boolean seed[][];

    public Seed() {
        this((long) (Math.random() * 1000000000));
    }

    public Seed(long seed){
        this.split = new int[20];
        System.out.println(seed);

        String temp = Long.toString(seed);
        for(int i = 0; i != temp.length(); i++) {
            split[i] = temp.charAt(i) - '0';
        }

        temp = Long.toString(seed * 2);
        for(int i = 8; i != temp.length() + 8; i++){
            split[i] = temp.charAt(i - 8) - '0';
        }

        temp = Long.toString(seed * 3);
        for(int i = 17; i != 20; i++){
            split[i] = temp.charAt(i - 17) - '0';
        }
    }

    private int[] getSeed() {
        return split;
    }

    public boolean[] getSeed(int index){
        return BinaryOperations.binaryToBoolean(BinaryOperations.oneDecimalToMultipleBinary(getSeed()[index]));
    }
}
