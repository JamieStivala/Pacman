package frames.listeners.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuAnimationHandler implements MouseListener {
    private ImageIcon animation[];
    private Rectangle boundsSmall;
    private Rectangle boundsBig;
    private JLabel component;

    public MenuAnimationHandler(ImageIcon animation[], Rectangle boundsSmall, Rectangle boundsBig, JLabel component) {
        this.animation = animation;
        this.boundsSmall = boundsSmall;
        this.boundsBig = boundsBig;
        this.component = component;
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
        this.component.setIcon(this.animation[1]);
        this.component.setBounds(this.boundsBig);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.component.setIcon(this.animation[0]);
        this.component.setBounds(this.boundsSmall);
    }
}
