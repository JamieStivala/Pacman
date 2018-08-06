package frames.listeners.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuAnimationHandler implements MouseListener {
    private ImageIcon animation[];
    private Rectangle boundsSmall;
    private Rectangle boundsBig;

    public MenuAnimationHandler(ImageIcon animation[], Rectangle boundsSmall, Rectangle boundsBig) {
        this.animation = animation;
        this.boundsSmall = boundsSmall;
        this.boundsBig = boundsBig;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ((JLabel)e.getComponent()).setIcon(this.animation[1]);
        e.getComponent().setBounds(this.boundsBig);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JLabel)e.getComponent()).setIcon(this.animation[0]);
        e.getComponent().setBounds(this.boundsSmall);
    }
}
