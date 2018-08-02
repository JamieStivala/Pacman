package items.stationery;

import items.Blob;

public class Coin extends Blob {
    public Coin(int x, int y) {
        super("coin.png", x + 12, y+12, 10, 10);
    }
}
