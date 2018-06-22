package items;


public class AnimatedSprite extends Sprite {
    private int resourceStart;
    private int resourceEnd;

    public AnimatedSprite(String resourceName, String format, boolean visible, int x, int y, int width, int height) {
        super(resourceName, format, visible, x, y, width, height);
        this.resourceStart = 0;
        this.resourceEnd = 4;
    }

    public AnimatedSprite(String resourceName, String format, boolean visible, int x, int y, int width, int height, int resourceStart, int resourceEnd) {
        super(resourceName, format, visible, x, y, width, height);
        this.resourceStart = resourceStart;
        this.resourceEnd = resourceEnd;
    }
}
