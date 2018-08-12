package frames.panels.menu.custom;

import javax.swing.*;
import java.awt.*;

/**
 * A custom SelectedListCellRenderer that overrides the DefaultListCellRenderer for the different colored text
 */
public class SelectedListCellRenderer extends DefaultListCellRenderer {
    public SelectedListCellRenderer() {
        super.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (isSelected) {
            component.setBackground(null);
            component.setForeground(new Color(240, 240, 200));
            super.setBorder(null);
        }
        return component;
    }
}
