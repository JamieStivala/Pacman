package generator;

public class PacmanMap extends Seed {
    PacmanMap(){
        this((long) (Math.random() * 1000000000));
    }

    PacmanMap(long seed){
        super(seed);
    }
}
