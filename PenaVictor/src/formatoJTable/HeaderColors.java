package formatoJTable;

import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;

public class HeaderColors extends DefaultTableCellRenderer {

    public HeaderColors() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(jTable, value, selected, focused, row, column);
        setBackground(new Color(37, 198, 217));
        setForeground(Color.white);
        setFont(new Font("Arial", Font.BOLD, 12));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        return this;
    }
}
