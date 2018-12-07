package game.map;

import game.items.Blob;
import game.items.stationery.PacDot;
import game.items.stationery.PowerPellet;
import game.items.stationery.Wall;
import game.map.generator.BlockType;
import game.map.generator.Generator;

import java.awt.image.BufferedImage;

public class PacmanMap {
    private BufferedImage renderedMap;
    private Generator generator;
    private Blob map[][];
    private int screenWidth, screenHeight, widthOfOneBlock, heightOfOneBlock;

    public PacmanMap(int vertical, int horizontal, int screenWidth, int screenHeight) {
        this.generator = new Generator(vertical, horizontal);
        this.map = new Blob[vertical][horizontal];

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        this.widthOfOneBlock = (screenWidth / horizontal);
        this.heightOfOneBlock = (screenHeight / vertical);

        Blob.setMaxWidth(widthOfOneBlock);
        Blob.setMaxHeight(heightOfOneBlock);

        buildMapObjects();
        this.renderedMap = renderMap();
    }

    private void buildMapObjects() {
        int x = 0;
        int y = 0;

        for (int i = 0; i != generator.getBuiltMap().length; i++) {
            for (int j = 0; j != generator.getBuiltMap(i).length; j++) {
                BlockType currentBlock = generator.getBuiltMap(i)[j];
                if (currentBlock == BlockType.WALL) this.map[i][j] = new Wall(x, y);
                if (currentBlock == BlockType.PAC_DOT) this.map[i][j] = new PacDot(x, y);
                if (currentBlock == BlockType.POWER_PELLET || currentBlock == BlockType.FRUIT)
                    this.map[i][j] = new PowerPellet(x, y);
                x += widthOfOneBlock;
            }
            x = 0;
            y += heightOfOneBlock;
        }
    }

    public BufferedImage renderMap() {
        BufferedImage map = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i != this.map.length; i++) {
            for (int j = 0; j != this.map[i].length; j++) {
                this.map[i][j].paint(map.getGraphics());
            }
        }
        return map;
    }

    public BufferedImage getRenderedMap() {
        return renderedMap;
    }
}
