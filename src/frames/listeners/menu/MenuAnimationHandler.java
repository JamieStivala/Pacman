package frames.listeners.menu;

import sounds.menu.ClickSound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class handles the zoom when the mouse hovers overs the JLabel and also handles the click sounds
 */
public class MenuAnimationHandler implements MouseListener {
    private ImageIcon animation[];
    private Rectangle boundsSmall;
    private Rectangle boundsBig;

    /**
     * @param animation The zoomed in and zoomed out icons
     * @param boundsSmall The bounds of when the JLabel is small
     * @param boundsBig The bounds of when the JLabel is bug
     */
    public MenuAnimationHandler(ImageIcon animation[], Rectangle boundsSmall, Rectangle boundsBig) {
        this.animation = animation;
        this.boundsSmall = boundsSmall;
        this.boundsBig = boundsBig;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Plays the click sound
     * @param e The Mouse Event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent() instanceof JLabel) {
            new ClickSound().start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Handles the zoom in animation
     * @param e The mouse animation
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        ((JLabel) e.getComponent()).setIcon(this.animation[1]);
        e.getComponent().setBounds(this.boundsBig);
    }

    /**
     * Handles the zoom out animation
     * @param e The mouse animation
     */
    @Override
    public void mouseExited(MouseEvent e) {
        ((JLabel) e.getComponent()).setIcon(this.animation[0]);
        e.getComponent().setBounds(this.boundsSmall);
    }
}
