package items;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Blob {
    private BufferedImage image;
    private Rectangle area;
    private boolean visible;

    public Blob (String filename, int x, int y, int width, int height) {
        try {
            image = ImageIO.read(new File("resources/" + filename));
        } catch (Exception e) {
            System.out.println("Error loading: " + filename);
        }

        area = new Rectangle (x, y, width, height);
        visible = true;
    }

}
