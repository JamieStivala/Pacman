package generator;

public class Seed {
    private boolean seed[][];

    public Seed() {
        this((long) (Math.random() * 1000000000));
    }

    public Seed(long seed){
        int split[] = new int[20];
        this.seed = new boolean[20][40];
        System.out.println(seed);

        String temp = Long.toString(seed);
        for(int i = 0; i != temp.length(); i++) {
            split[i] = temp.charAt(i) - '0';
        }

        temp = Long.toString(seed * 2);
        for(int i = 9; i != temp.length() + 8; i++){
            split[i] = temp.charAt(i - 8) - '0';
        }

        temp = Long.toString(seed * 3);
        for(int i = 18; i != 20; i++){
            split[i] = temp.charAt(i - 17) - '0';
        }

        for (int i = 0; i != split.length ; i++) {
            this.seed[i] = BinaryOperations.binaryToBoolean(BinaryOperations.oneDecimalToMultipleBinary(split[i]));
        }
    }

    public boolean[] getSeed(int index){
        return this.seed[index];
    }
}
