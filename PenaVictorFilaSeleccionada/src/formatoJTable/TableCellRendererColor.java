package formatoJTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRendererColor extends DefaultTableCellRenderer {

    private Component componente;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 0) {
            componente.setBackground(new Color(37, 217, 202));
        } else {
            componente.setBackground(Color.white);
        }
        if (column == 0) {
            setFont(new Font("Arial", Font.BOLD, 12));
        }
        return componente;
    }

}
