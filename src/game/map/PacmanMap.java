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
    private int mapWidth, mapHeight, screenWidth, screenHeight;

    public PacmanMap(int width, int height, int screenWidth, int screenHeight) {
        this.generator = new Generator(width, height);
        this.map = new Blob[width][height];

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.mapWidth = width;
        this.mapHeight = height;

        buildMapObjects();
        this.renderedMap = renderMap();
    }

    private void buildMapObjects() {
        int widthBetweenBlocks = (this.screenWidth / this.mapWidth) * 2;
        int heightBetweenBlocks = (this.screenHeight / this.mapHeight) * 2;

        System.out.println(heightBetweenBlocks);
        int x = 0;
        int y = 0;

        for (int i = 0; i != generator.getBuiltMap().length; i++) {
            for (int j = 0; j != generator.getBuiltMap(i).length; j++) {
                BlockType currentBlock = generator.getBuiltMap(i)[j];
                if (currentBlock == BlockType.WALL) this.map[i][j] = new Wall(x, y);
                if (currentBlock == BlockType.PAC_DOT) this.map[i][j] = new PacDot(x, y);
                if (currentBlock == BlockType.POWER_PELLET || currentBlock == BlockType.FRUIT)
                    this.map[i][j] = new PowerPellet(x, y);
                x += widthBetweenBlocks;
            }
            x = 0;
            y += heightBetweenBlocks;
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
