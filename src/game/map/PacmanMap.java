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
    private Blob[][] map;
    private int screenWidth, screenHeight, widthOfOneBlock, heightOfOneBlock, vertical, horizontal, topDimensions;

    public PacmanMap(int vertical, int horizontal, int screenWidth, int screenHeight) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        this.generator = new Generator(vertical, horizontal);
        this.map = new Blob[vertical][horizontal];

        this.setScreenWidth(screenWidth);
        this.setScreenHeight(screenHeight, 0);

        this.widthOfOneBlock = (screenWidth / horizontal);
        this.heightOfOneBlock = (screenHeight / vertical);

        buildMapObjects();
    }

    public void buildMapObjects() {
        int x = 0;
        int y = topDimensions;

        for (int i = 0; i != generator.getBuiltMap().length; i++) {
            for (int j = 0; j != generator.getBuiltMap(i).length; j++) {
                BlockType currentBlock = generator.getBuiltMap(i)[j];
                boolean isVisible = true;
                if (this.map[i][j] != null) isVisible = this.map[i][j].isVisible();

                if (currentBlock == BlockType.WALL) this.map[i][j] = new Wall(x, y);
                if (currentBlock == BlockType.PAC_DOT) this.map[i][j] = new PacDot(x, y);
                if (currentBlock == BlockType.POWER_PELLET || currentBlock == BlockType.FRUIT)
                    this.map[i][j] = new PowerPellet(x, y);

                if (this.map[i][j] != null) this.map[i][j].setVisible(isVisible);
                x += widthOfOneBlock;
            }
            x = 0;
            y += heightOfOneBlock;
        }
    }

    public void renderMap() {
        BufferedImage map = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i != this.map.length; i++) {
            for (int j = 0; j != this.map[i].length; j++) {
                this.map[i][j].paint(map.getGraphics());
            }
        }
        this.renderedMap = map;
    }

    public BufferedImage getRenderedMap() {
        return renderedMap;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
        this.widthOfOneBlock = (screenWidth / horizontal);
        Blob.setMaxWidth(widthOfOneBlock);
    }

    public void setScreenHeight(int screenHeight, int topDimensions) {
        this.screenHeight = screenHeight;
        this.heightOfOneBlock = ((screenHeight - topDimensions) / vertical);
        Blob.setMaxHeight(heightOfOneBlock);
        this.topDimensions = topDimensions;
    }
}
