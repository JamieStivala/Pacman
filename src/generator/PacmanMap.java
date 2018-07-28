package generator;

public class PacmanMap extends Seed {
    public PacmanMap(){
        this((long) (Math.random() * 1000000000));
    }

    public PacmanMap(long seed){
        super(seed);
    }
}
