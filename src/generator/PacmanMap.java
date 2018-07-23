package generator;

import items.Blob;
import items.stationery.Coin;

public class PacmanMap extends Seed {
    Blob items[][] = new Blob[20][40];

    PacmanMap(){
        this((long) (Math.random() * 1000000000));
    }

    PacmanMap(long seed){
        super(seed);

        for(int vertical = 0; vertical != super.getSeed().length; vertical++){
            for(int horizontal = 0; horizontal != super.getSeed(vertical).length; horizontal++){
                if(super.getSeed(vertical)[horizontal] == BlockType.COIN){
                    items[vertical][horizontal] = new Coin();
                }
            }
        }
    }
}
